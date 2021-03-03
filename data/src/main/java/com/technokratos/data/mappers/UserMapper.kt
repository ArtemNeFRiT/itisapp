package com.technokratos.data.mappers

import com.technokratos.data.db.model.UserLocal
import com.technokratos.data.network.model.UserRemote
import com.technokratos.domain.model.User

fun mapUserLocalToUser(user: UserLocal): User {
    return with (user) {
        User(id, name, age)
    }
}

fun mapUserRemoteToUserLocal(user: UserRemote): UserLocal {
    return with (user) {
        UserLocal(id, firstName, age)
    }
}