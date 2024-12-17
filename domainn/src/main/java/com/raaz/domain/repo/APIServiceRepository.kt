package com.raaz.domain.repo

import com.raaz.data.Resource
import com.raaz.domain.model.APIResponse
import com.raaz.domain.model.Root
import com.raaz.domain.repository.APIService
import javax.inject.Inject

class APIServiceRepository @Inject constructor(
    val apiService: APIService
) {
    suspend fun getApiData(): Resource<List<Root>> =
        try {
             val response = apiService.getDetails()
            com.raaz.data.Resource.Success(response)
        } catch (exception: Exception){
             com.raaz.data.Resource.Error(exception)
        }
}