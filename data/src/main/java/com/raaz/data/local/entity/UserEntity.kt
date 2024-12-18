package com.raaz.data.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class UserEntity(
    @PrimaryKey val userId: Int,
    @ColumnInfo(name = "name") var name: String?,
    @ColumnInfo(name = "email") var email: String?
)
