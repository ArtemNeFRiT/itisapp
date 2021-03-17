package com.technokratos.data.network

import com.technokratos.data.network.model.UserRemote
import com.technokratos.data.network.response.GetUsersResponse
import io.reactivex.Single

class UserApiImpl: UserApi {

    override fun getUsers(): Single<GetUsersResponse> {
        val mockUsers = mutableListOf<UserRemote>().apply {
            add(UserRemote(1, "Иван", "Иванов", 21, "Иванович"))
            add(UserRemote(2, "Петр", "Сергеев", 18, "Максимович"))
        }
        return Single.just(GetUsersResponse(mockUsers))
    }
}