package com.raaz.mvvm_repo.ui.theme.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.raaz.domain.model.Root
import com.raaz.domain.usecase.APIServiceUseCase
import com.raaz.data.Resource.*
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class BaseAPIViewModel @Inject constructor(
    val apiServiceUseCase: APIServiceUseCase
) : ViewModel() {

    private var _apiResponse = MutableLiveData<Root>()
    val apiResponse: LiveData<Root> = _apiResponse
    private var _errorResponse = MutableLiveData<String>()
    val error: LiveData<String> = _errorResponse


    fun getResponse() {
        viewModelScope.launch {
            when (val response = apiServiceUseCase.invoke()) {
                is Success -> _apiResponse.value = response.result
                is Error -> _errorResponse.value = response.exception.message
            }
        }
    }

}