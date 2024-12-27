package com.raaz.mvvm_repo.sync

import androidx.work.Constraints
import androidx.work.NetworkType
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkManager
import androidx.work.workDataOf
import javax.inject.Inject


class WorkManagerBuilder @Inject constructor() {

    companion object {
        private var INSTANCE: WorkManagerBuilder? = null

        fun getInstance(): WorkManagerBuilder? {
            synchronized(this) {
                val instance = INSTANCE

                if (instance == null) {

                    INSTANCE = instance
                }
                return instance
            }
        }

    }

    fun syncToDB() {
//            val constraints: Constraints = Constraints.Builder()
//                .setRequiresCharging(true)
//                .setRequiredNetworkType(NetworkType.CONNECTED)
//                .build()
//            val workRequest: WorkRequest = PeriodicWorkRequest.Builder(
//                WorkScheduler::class.java, 5,
//                TimeUnit.SECONDS
//            )
//                .setConstraints(constraints)
//                .build()
        val workManager: WorkManager = WorkManager.getInstance()
//            workManager.enqueue(workRequest)
////        workManager.getWorkInfoByIdLiveData(workRequest.id)
//            workManager.getWorkInfoByIdLiveData(workRequest.id)

        // One time request
        val constraints = Constraints.Builder()
            .setRequiredNetworkType(NetworkType.CONNECTED)
            .build()

        val request = OneTimeWorkRequestBuilder<WorkScheduler>()
            .setConstraints(constraints)
            .setInputData(
                workDataOf("URI" to "")
            )
            .build()
        workManager.enqueue(request)

    }
}

