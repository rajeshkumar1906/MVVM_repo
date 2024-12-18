package com.raaz.mvvm_repo.repository

import android.content.Context
import com.raaz.mvvm_repo.db.DataBase
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
}