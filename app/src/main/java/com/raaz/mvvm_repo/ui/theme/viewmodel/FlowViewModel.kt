package com.raaz.mvvm_repo.ui.theme.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FlowViewModel @Inject constructor(): ViewModel() {

    private var _liveData = MutableLiveData<String>("Hello Live data")
    val liveData: LiveData<String> = _liveData

    private var _stateFlow = MutableStateFlow("Hello State flow")
    val stateFlow = _stateFlow.asStateFlow()

    private var _sharedFlow = MutableSharedFlow<String>()
    val sharedFlow = _sharedFlow.asSharedFlow()


    fun getLiveData1() {
        _liveData.value = "Hello Rajesh"
    }

    fun getFlowData() = flow<String> {

        repeat(10){
            emit("Hello $it")
            delay(1000L)
        }
    }

    fun getStateFlow(){
        _stateFlow.value = "State Flow called"
    }

     fun getSharedFlow() {
        viewModelScope.launch {
            _sharedFlow.emit("shared Flow called")
        }

    }

}