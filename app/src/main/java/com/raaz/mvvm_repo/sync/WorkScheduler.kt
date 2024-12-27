package com.raaz.mvvm_repo.sync

import android.annotation.SuppressLint
import android.content.Context
import android.util.Log
import androidx.hilt.work.HiltWorker
import androidx.work.Worker
import androidx.work.WorkerParameters
import com.raaz.data.Resource
import com.raaz.data.local.db.DataBase
import com.raaz.data.local.entity.UserEntity
import com.raaz.mvvm_repo.di.WorkManagerService
import dagger.assisted.Assisted
import dagger.assisted.AssistedInject
import dagger.hilt.android.EntryPointAccessors
import kotlinx.coroutines.runBlocking

@HiltWorker
class WorkScheduler @AssistedInject constructor(
    @Assisted val context: Context,
    @Assisted parameters: WorkerParameters) : Worker(context, parameters) {

    @SuppressLint("RestrictedApi")
    override fun doWork(): Result {
        runBlocking {
            val hiltEntryPoint = EntryPointAccessors.fromApplication(context.applicationContext, WorkManagerService::class.java)
//            val libRepo = hiltEntryPoint.getOpenLibRepository()
            val apiServiceRepo = hiltEntryPoint.getAPIServiceRepository()
            val dataBaseManager = hiltEntryPoint.getDataBaseManager()
            val apiData = apiServiceRepo.getApiData()
//            val database = DataBase.getInstance(context)
//
//
//
//            val dao = database.userDao()
//            dao.deleteAll()
//            val apiData = apiServiceRepo.getApiData()
//            Log.e("WorkScheduler","<>dowork ${apiData}")
//            val dataBaseItems:ArrayList<UserEntity> = ArrayList()
//            when (apiData){
//                is Resource.Success -> {
//                    val data = apiData.result as ArrayList
//                    data.forEach {
//                        dataBaseItems.add(UserEntity(it.id,it.name,it.email))
//                    }
//                    dao.insertAll(dataBaseItems)
//                }
//                is Resource.Error -> {
//                    Result.Failure()
//                }
//            }
            dataBaseManager.updateDB(apiData){
                when(it){
                    true -> Result.Success()
                    false -> Result.Failure()
                }
            }

        }
      return  Result.Success()
    }

}