package com.technokratos.data.di

import com.technokratos.data.db.dao.UserDao
import com.technokratos.data.network.UserApi
import com.technokratos.data.repository.UserRepositoryImpl
import com.technokratos.domain.interfaces.UserRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepoModule {

    @Provides
    @Singleton
    fun provideUserRepository(
        userDao: UserDao,
        userApi: UserApi
    ): UserRepository {
        return UserRepositoryImpl(userApi, userDao)
    }
}