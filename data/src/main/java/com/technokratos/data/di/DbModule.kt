package com.technokratos.data.di

import android.content.Context
import androidx.room.RoomDatabase
import com.technokratos.data.db.AppDatabase
import com.technokratos.data.db.dao.UserDao
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DbModule {

    @Provides
    @Singleton
    fun provideDatabase(context: Context): AppDatabase {
        return AppDatabase.get(context)
    }

    @Provides
    @Singleton
    fun provideUserDao(database: AppDatabase): UserDao = database.usersDao()
}