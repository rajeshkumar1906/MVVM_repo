package com.raaz.data.local.db

import android.content.ContentResolver
import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.raaz.data.local.dao.UserDao
import com.raaz.data.local.entity.UserEntity
import dagger.hilt.android.internal.Contexts

@Database(entities = [(UserEntity::class)], version = 1)
abstract class DataBase: RoomDatabase() {
    abstract fun userDao(): UserDao

    companion object {
        @Volatile
        private var INSTANCE: DataBase? = null

        fun getInstance(context: Context): DataBase {
            synchronized(this) {
                var instance = INSTANCE

                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        DataBase::class.java,
                        "raaz_database"
                    ).fallbackToDestructiveMigration()
                        .build()

                    INSTANCE = instance
                }
                return instance
            }
        }

    }
}