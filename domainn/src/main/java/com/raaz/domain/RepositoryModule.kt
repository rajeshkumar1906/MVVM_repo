package com.raaz.domain

import android.content.Context
import com.raaz.domain.repo.APIServiceRepository
import com.raaz.domain.repository.APIService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import dagger.hilt.migration.DisableInstallInCheck
import javax.inject.Singleton

@Module
@DisableInstallInCheck
object RepositoryModule {

    @Provides
    @Singleton
    fun providesApiServiceRepository(apiService: APIService):
            APIServiceRepository =
        APIServiceRepository(apiService)

}