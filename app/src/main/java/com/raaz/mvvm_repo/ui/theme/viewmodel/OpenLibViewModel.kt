package com.raaz.mvvm_repo.ui.theme.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.raaz.data.Resource
import com.raaz.domain.model.openlib.OpenLibData
import com.raaz.domain.usecase.LibServiceUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class OpenLibViewModel @Inject constructor(
    val libServiceUseCase: LibServiceUseCase
): ViewModel() {

    private var _libData = MutableLiveData<OpenLibData>()
    val libResponse: LiveData<OpenLibData> = _libData
    val error = MutableLiveData<String>()


    fun getLibResponse(){
        viewModelScope.launch {
            when(val response = libServiceUseCase.invoke()){
                is Resource.Success -> _libData.value = response.result
                is Resource.Error -> error.value = response.exception.message
            }
        }

    }
}