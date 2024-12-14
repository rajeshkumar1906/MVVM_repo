package com.raaz.mvvm_repo.domain

import com.raaz.mvvm_repo.model.Root
import com.raaz.mvvm_repo.network.Resource
import javax.inject.Inject

class APIServiceRepository @Inject constructor(
    val apiService: APIService
) {
    suspend fun getApiData(): Resource<Root> {
        try {
             val response = apiService.getDetails()
            Resource.Success(response)
        } catch (exception: Exception){
             Resource.Error(exception)
        }
    }
}