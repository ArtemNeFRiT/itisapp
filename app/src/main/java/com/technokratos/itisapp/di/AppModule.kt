package com.technokratos.itisapp.di

import android.content.Context
import com.technokratos.domain.UserInteractor
import com.technokratos.itisapp.common.ResourceManager
import com.technokratos.domain.interfaces.UserRepository
import com.technokratos.itisapp.common.ResourceManagerImpl
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

    @Provides
    @Singleton
    fun provideResourceManager(context: Context): ResourceManager {
        return ResourceManagerImpl(context)
    }
}