package com.raaz.mvvm_repo.domain

import com.raaz.mvvm_repo.model.Root
import retrofit2.http.GET
import retrofit2.http.POST

interface APIService {
    @GET("public/v2/comments")
    suspend fun getDetails(): Root
}