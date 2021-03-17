package com.technokratos.domain

import com.technokratos.domain.interfaces.UserRepository
import com.technokratos.domain.model.User
import io.reactivex.Completable
import io.reactivex.Observable
import io.reactivex.Single

class UserInteractor(
    private val userRepository: UserRepository
) {

    fun getUsers(): Observable<List<User>> {
        return userRepository.getUsers()
    }

    fun updateUsers(): Completable {
        return userRepository.updateUsers()
    }

    fun getUser(id: Int): Observable<User> {
        return userRepository.getUser(id)
    }
}