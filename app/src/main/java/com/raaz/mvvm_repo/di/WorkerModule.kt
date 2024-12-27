package com.raaz.mvvm_repo.di

import com.raaz.mvvm_repo.sync.WorkManagerBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)
object MyWorkerModule {

    @Provides
    fun providesWorkBuilder(): WorkManagerBuilder =
        WorkManagerBuilder()
}