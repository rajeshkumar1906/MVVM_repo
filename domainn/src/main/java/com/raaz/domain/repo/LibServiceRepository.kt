package com.raaz.domain.repo

import com.raaz.data.Resource
import com.raaz.domain.repository.OpenLibService
import javax.inject.Inject

class LibServiceRepository @Inject constructor(
    val openLibService: OpenLibService) {

    suspend fun getLibData() =
        try {
            val data = openLibService.getOpenLibService()
            Resource.Success(data)
        } catch (exception: Exception) {
            Resource.Error(exception)
        }

}