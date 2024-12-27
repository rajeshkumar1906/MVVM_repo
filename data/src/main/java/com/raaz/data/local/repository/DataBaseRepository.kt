package com.raaz.data.local.repository

import android.content.Context
import com.raaz.data.local.db.DataBase
import com.raaz.data.local.db.DataBaseManager
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object DataBaseRepository {

    @Provides
    fun provideDataBase(@ApplicationContext context: Context): DataBase = DataBase.getInstance(context)

    @Provides
    fun provideDataBaseManager(@ApplicationContext context: Context, dataBase: DataBase): DataBaseManager =
        DataBaseManager(context,dataBase)
}