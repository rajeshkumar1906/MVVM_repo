package com.raaz.domain.di

import android.content.Context
import com.raaz.data.local.db.DataBase
import com.raaz.domain.repo.APIServiceRepository
import com.raaz.domain.repository.APIService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {


    @Provides
    @Singleton
    fun providesMainApplication(@ApplicationContext context: Context): Context {
        return context
    }


    @Provides
    @Singleton
    fun providesApiServiceRepository(apiService: APIService, context: Context,dataBase: DataBase):
            APIServiceRepository =
        APIServiceRepository(apiService,context,dataBase)

}