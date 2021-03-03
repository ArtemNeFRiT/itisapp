package com.technokratos.data.db.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "users")
data class UserLocal(
    @PrimaryKey val id: Int,
    val name: String,
    val age: Int
)