package com.raaz.mvvm_repo.sync

import android.content.Context
import androidx.work.BackoffPolicy
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkManager
import dagger.hilt.EntryPoint
import dagger.hilt.android.qualifiers.ApplicationContext
import java.util.concurrent.TimeUnit
import javax.inject.Inject



//@EntryPoint'
object WorkManagerBuilder {

//    @Inject
//    lateinit var context: ApplicationContext
//
//    fun createWorkRequest(){
//        val workRequest = OneTimeWorkRequestBuilder<WorkScheduler>()
//            .setBackoffCriteria(
//                BackoffPolicy.LINEAR,
//                30,
//                TimeUnit.SECONDS
//            ).build()
//        WorkManager.getInstance(context as Context).enqueue(workRequest)
//    }
}

