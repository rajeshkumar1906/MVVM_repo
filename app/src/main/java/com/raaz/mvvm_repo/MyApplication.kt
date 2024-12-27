package com.raaz.mvvm_repo

import android.app.Application
import android.content.Context
import androidx.hilt.work.HiltWorkerFactory
import androidx.multidex.MultiDexApplication
import androidx.work.Configuration
import dagger.hilt.android.HiltAndroidApp
import kotlinx.coroutines.DelicateCoroutinesApi
import javax.inject.Inject

@DelicateCoroutinesApi
@HiltAndroidApp
class MyApplication : MultiDexApplication(), Configuration.Provider {
    @Inject
    lateinit var workerFactory : HiltWorkerFactory
    override fun onCreate() {
        super.onCreate()

    }
    override fun getApplicationContext(): Context {
        return this
    }


    override val workManagerConfiguration: Configuration
        get() = Configuration.Builder()
            .setWorkerFactory(workerFactory)
            .build()

}