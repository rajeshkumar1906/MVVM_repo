package com.raaz.mvvm_repo.domain

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {


    @Provides
    fun providesApiServiceRepository(apiService: APIService):
            APIServiceRepository = APIServiceRepository(apiService)

}