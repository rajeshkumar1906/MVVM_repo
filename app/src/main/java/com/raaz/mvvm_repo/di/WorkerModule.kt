package com.raaz.mvvm_repo.di

import android.content.Context
import androidx.work.Worker
import androidx.work.WorkerParameters
import com.raaz.data.local.db.DataBase
import com.raaz.domain.usecase.APIServiceUseCase
import com.raaz.mvvm_repo.sync.WorkScheduler
import dagger.Binds
import dagger.MapKey
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dagger.multibindings.IntoMap
import kotlin.reflect.KClass

@Retention(AnnotationRetention.RUNTIME)
@MapKey
annotation class WorkerKey(val value: KClass<out Worker>)

@Module
@InstallIn(SingletonComponent::class)
object MyWorkerModule {

//    @Binds
//    @IntoMap
//    @WorkerKey(WorkScheduler::class)
//    internal abstract fun bindMyWorker(worker: WorkScheduler): Worker
//    @Provides
//    fun providesWorker(context: Context, dataBase: DataBase, apiServiceUseCase: APIServiceUseCase, workerParameters: WorkerParameters):
//        WorkScheduler = WorkScheduler(context,dataBase,apiServiceUseCase,workerParameters )
}