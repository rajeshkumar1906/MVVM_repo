package com.raaz.mvvm_repo.di


import com.raaz.domain.usecase.APIServiceUseCase
import com.raaz.domain.repo.APIServiceRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    fun provideAPIServiceUseCase(apiServiceRepository: APIServiceRepository):
            APIServiceUseCase =
        APIServiceUseCase(apiServiceRepository)
}