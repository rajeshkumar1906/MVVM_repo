package com.raaz.mvvm_repo

import android.app.Application
import androidx.multidex.MultiDexApplication
import dagger.hilt.android.HiltAndroidApp
import kotlinx.coroutines.DelicateCoroutinesApi

@DelicateCoroutinesApi
@HiltAndroidApp
class MyApplication: MultiDexApplication() {
    override fun onCreate() {
        super.onCreate()

    }
}