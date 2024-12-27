package com.raaz.mvvm_repo.ui.theme.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.raaz.data.Resource
import com.raaz.domain.model.openlib.OpenLibData
import com.raaz.domain.usecase.LibServiceUseCase
import com.raaz.mvvm_repo.sync.WorkManagerBuilder
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class OpenLibViewModel @Inject constructor(
    val libServiceUseCase: LibServiceUseCase,
    val workManagerBuilder: WorkManagerBuilder
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
                    workManagerBuilder.syncToDB()
                }
                is Resource.Error -> error.value = response.exception.message
            }
        }
    }
}