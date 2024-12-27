package com.raaz.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.raaz.data.local.entity.UserEntity

@Dao
interface UserDao {
    @Query("SELECT * FROM USERENTITY")
    suspend fun getAll(): List<UserEntity>

    @Insert
    suspend fun insertAll(details: List<UserEntity>)

    @Delete
    suspend fun delete(details: UserEntity)

    @Query("DELETE FROM USERENTITY")
    fun deleteAll()
}