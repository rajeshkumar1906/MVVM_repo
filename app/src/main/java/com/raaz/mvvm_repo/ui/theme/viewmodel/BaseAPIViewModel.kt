package com.raaz.mvvm_repo.ui.theme.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.raaz.mvvm_repo.model.Root
import com.raaz.mvvm_repo.network.Resource
import com.raaz.mvvm_repo.usecase.APIServiceUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch

@HiltViewModel
class BaseAPIViewModel(
    val apiServiceUseCase: APIServiceUseCase
) : ViewModel() {

    private var _apiResponse = MutableLiveData<Root>()
    val apiResponse: LiveData<Root> = _apiResponse
    private var _errorResponse = MutableLiveData<String>()
    val error: LiveData<String> = _errorResponse


    fun getResponse() {
        viewModelScope.launch {
            when (val response = apiServiceUseCase.invoke()) {
                is Resource.Success -> _apiResponse.value = response.result
                is Resource.Error -> _errorResponse.value = response.exception.message
            }
        }
    }

}