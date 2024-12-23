package com.raaz.mvvm_repo.di


import android.content.Context
import com.raaz.domain.usecase.APIServiceUseCase
import com.raaz.domain.repo.APIServiceRepository
import com.raaz.domain.repo.LibServiceRepository
import com.raaz.domain.usecase.LibServiceUseCase
import com.raaz.mvvm_repo.MyApplication
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun providesMainApplication(@ApplicationContext context: Context): MyApplication {
        return context as MyApplication
    }

    @Provides
    fun provideAPIServiceUseCase(apiServiceRepository: APIServiceRepository):
            APIServiceUseCase =
        APIServiceUseCase(apiServiceRepository)

    @Provides
    fun providesLibServiceUseCase(libServiceRepository: LibServiceRepository):
            LibServiceUseCase = LibServiceUseCase(libServiceRepository)
}