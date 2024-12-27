package com.raaz.mvvm_repo.sync

import android.annotation.SuppressLint
import android.content.Context
import android.util.Log
import androidx.hilt.work.HiltWorker
import androidx.work.Worker
import androidx.work.WorkerParameters
import com.raaz.data.local.db.DataBase
import com.raaz.domain.usecase.APIServiceUseCase
import com.raaz.domain.usecase.LibServiceUseCase
import com.raaz.mvvm_repo.di.WorkManagerService
import dagger.assisted.Assisted
import dagger.assisted.AssistedInject
import dagger.hilt.android.EntryPointAccessors
import kotlinx.coroutines.runBlocking
import javax.inject.Inject

@HiltWorker
class WorkScheduler @AssistedInject constructor(
    @Assisted val context: Context,
    @Assisted parameters: WorkerParameters) : Worker(context, parameters) {
        @Inject
        lateinit var libServiceUseCase: LibServiceUseCase
    @SuppressLint("RestrictedApi")
    override fun doWork(): Result {
        runBlocking {
            val hiltEntryPoint = EntryPointAccessors.fromApplication(context.applicationContext, WorkManagerService::class.java)
            val libRepo = hiltEntryPoint.getOpenLibRepository()
//            if (this@WorkScheduler::libServiceUseCase.isInitialized)
            Log.e("WorkScheduler","<>dowork ${libRepo.getLibData()}")
        }


      return  Result.Success()
    }

}