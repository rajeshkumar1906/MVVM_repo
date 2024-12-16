package com.raaz.domain.repository

import com.raaz.domain.model.Root
import retrofit2.http.GET

interface APIService {
    @GET("public/v2/comments")
    suspend fun getDetails(): Root
}