package com.technokratos.domain.interfaces

import com.technokratos.domain.model.User
import io.reactivex.Completable
import io.reactivex.Observable

interface UserRepository {

    fun getUsers(): Observable<List<User>>

    fun updateUsers(): Completable

    fun getUser(id: Int): Observable<User>
}