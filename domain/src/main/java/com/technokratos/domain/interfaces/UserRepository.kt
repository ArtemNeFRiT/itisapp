package com.technokratos.domain.interfaces

import com.technokratos.domain.model.User
import io.reactivex.Observable

interface UserRepository {

    fun getUsers(): Observable<List<User>>

    fun getUser(id: Int): Observable<User>
}