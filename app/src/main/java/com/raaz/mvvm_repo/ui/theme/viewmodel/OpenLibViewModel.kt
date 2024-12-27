package com.raaz.mvvm_repo.ui.theme.viewmodel

import android.annotation.SuppressLint
import android.content.Context
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asFlow
import androidx.lifecycle.viewModelScope
import androidx.work.Constraints
import androidx.work.NetworkType
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkManager
import androidx.work.PeriodicWorkRequest
import androidx.work.WorkRequest
import androidx.work.workDataOf
import com.raaz.data.Resource
import com.raaz.domain.model.openlib.OpenLibData
import com.raaz.domain.usecase.LibServiceUseCase
import com.raaz.mvvm_repo.MyApplication
import com.raaz.mvvm_repo.sync.WorkScheduler
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject
import java.util.concurrent.TimeUnit



@OptIn(DelicateCoroutinesApi::class)
@HiltViewModel
class OpenLibViewModel @Inject constructor(
    val libServiceUseCase: LibServiceUseCase
): ViewModel() {

    private var _libData = MutableLiveData<OpenLibData>()
    val libResponse: LiveData<OpenLibData> = _libData
    val error = MutableLiveData<String>()

   private var _libDataFlow = MutableSharedFlow<OpenLibData>()
    val libDataFlow = _libDataFlow.asSharedFlow()


    fun getLibResponse(){
        viewModelScope.launch {
            when(val response = libServiceUseCase.invoke()){
                is Resource.Success -> {
                    _libData.value = response.result
                    _libDataFlow.emit(response.result)
                    syncToDB()
                }
                is Resource.Error -> error.value = response.exception.message
            }
        }
    }

    private fun syncToDB() {
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
            val workManager: WorkManager =  WorkManager.getInstance()
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