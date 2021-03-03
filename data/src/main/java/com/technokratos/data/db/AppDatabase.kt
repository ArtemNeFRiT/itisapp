package com.technokratos.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.technokratos.data.db.dao.UserDao
import com.technokratos.data.db.model.UserLocal

@Database(
    version = 1,
    entities = [
        UserLocal::class
    ]
)
abstract class AppDatabase : RoomDatabase() {

    companion object {

        private var instance: AppDatabase? = null

        @Synchronized
        fun get(context: Context): AppDatabase {
            if (instance == null) {
                instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java, "app.db"
                )
                    .build()
            }
            return instance!!
        }
    }

    abstract fun usersDao(): UserDao
}