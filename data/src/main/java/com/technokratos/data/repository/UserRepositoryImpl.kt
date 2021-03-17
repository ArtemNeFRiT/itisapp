package com.technokratos.data.repository

import com.technokratos.data.db.dao.UserDao
import com.technokratos.data.mappers.mapUserLocalToUser
import com.technokratos.data.mappers.mapUserRemoteToUserLocal
import com.technokratos.data.network.UserApi
import com.technokratos.domain.interfaces.UserRepository
import com.technokratos.domain.model.User
import io.reactivex.Completable
import io.reactivex.Observable

class UserRepositoryImpl(
    val userApi: UserApi,
    val userDao: UserDao
) : UserRepository {

    override fun getUsers(): Observable<List<User>> {
        return userDao.observeUsers()
            .map { it.map(::mapUserLocalToUser) }
    }

    override fun updateUsers(): Completable {
        return userApi.getUsers()
            .map { it.data }
            .map { it.map(::mapUserRemoteToUserLocal) }
            .doOnSuccess { userDao.insertUsers(it) }
            .ignoreElement()
    }

    override fun getUser(id: Int): Observable<User> {
        return userDao.observeUser(id)
            .map(::mapUserLocalToUser)
    }
}