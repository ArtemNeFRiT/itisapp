package com.technokratos.data.di

import com.technokratos.data.network.UserApi
import com.technokratos.data.network.UserApiImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class NetworkModule {

    @Provides
    @Singleton
    fun provideUserApi(): UserApi = UserApiImpl()
}