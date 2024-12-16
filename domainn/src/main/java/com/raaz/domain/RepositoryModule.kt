package com.raaz.domain

import com.raaz.domain.repo.APIServiceRepository
import com.raaz.domain.repository.APIService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    fun providesApiServiceRepository(apiService: APIService):
            APIServiceRepository =
        APIServiceRepository(apiService)

}