package com.technokratos.data.repository

import com.technokratos.data.db.dao.UserDao
import com.technokratos.data.network.UserApi
import com.technokratos.domain.interfaces.UserRepository
import com.technokratos.domain.model.User
import io.reactivex.Observable

class UserRepositoryImpl(
    val userApi: UserApi,
    val userDao: UserDao
): UserRepository {

    override fun getUsers(): Observable<List<User>> {
        return Observable.just(emptyList())
    }

    override fun getUser(id: Int): Observable<User> {
        return Observable.empty()
    }
}