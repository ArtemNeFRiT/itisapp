package com.technokratos.data.di

import com.technokratos.data.repository.UserRepositoryImpl
import com.technokratos.domain.UserInteractor
import com.technokratos.domain.interfaces.UserRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule {

    @Provides
    @Singleton
    fun provideUserInteractor(userRepository: UserRepository): UserInteractor {
        return UserInteractor(userRepository)
    }
}