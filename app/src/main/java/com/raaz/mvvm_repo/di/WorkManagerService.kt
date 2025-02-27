package com.raaz.mvvm_repo.di

import com.raaz.data.local.db.DataBaseManager
import com.raaz.data.local.db.IDataBaseManager
import com.raaz.domain.repo.APIServiceRepository
import com.raaz.domain.repo.LibServiceRepository
import dagger.hilt.EntryPoint
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@EntryPoint
@InstallIn(SingletonComponent::class)
interface WorkManagerService {
    fun getOpenLibRepository(): LibServiceRepository
    fun getAPIServiceRepository(): APIServiceRepository
    fun getDataBaseManager(): IDataBaseManager
}