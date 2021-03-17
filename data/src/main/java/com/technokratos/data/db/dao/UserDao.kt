package com.technokratos.data.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.technokratos.data.db.model.UserLocal
import io.reactivex.Observable

@Dao
interface UserDao {

    @Query("select * from users")
    fun observeUsers(): Observable<List<UserLocal>>

    @Query("select * from users where id = :id")
    fun observeUser(id: Int): Observable<UserLocal>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertUsers(users: List<UserLocal>)
}