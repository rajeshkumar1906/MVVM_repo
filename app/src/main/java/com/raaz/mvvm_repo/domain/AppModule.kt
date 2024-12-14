package com.raaz.mvvm_repo.domain

import com.raaz.mvvm_repo.usecase.APIServiceUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    fun provideAPIServiceUseCase(apiServiceRepository: APIServiceRepository):
            APIServiceUseCase = APIServiceUseCase(apiServiceRepository)
}