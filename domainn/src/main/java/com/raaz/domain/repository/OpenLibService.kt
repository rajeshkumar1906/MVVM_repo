package com.raaz.domain.repository

import com.raaz.domain.model.openlib.OpenLibData
import retrofit2.http.GET

interface OpenLibService  {

    @GET("/search.json?q=the+lord+of+the+rings")
   suspend fun getOpenLibService(): OpenLibData
}
