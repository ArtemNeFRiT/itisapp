package com.technokratos.data.network

import com.technokratos.data.network.response.GetUsersResponse
import io.reactivex.Single

interface UserApi {

    fun getUsers(): Single<GetUsersResponse>
}