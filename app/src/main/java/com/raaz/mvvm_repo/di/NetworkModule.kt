package com.raaz.mvvm_repo.di

import com.raaz.domain.repository.APIService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {
    private const val TIMEOUT = 60L


   @Provides
   fun providesHTTPClient(): OkHttpClient {

       val httpClient = OkHttpClient().newBuilder()
//       httpClient.addInterceptor(logInterceptor)
//       httpClient.addInterceptor(authInterceptor)
//       httpClient.addInterceptor(
//           ChuckerInterceptor.Builder(context)
//               .collector(ChuckerCollector(context))
//               .build(),
//       )
       httpClient.readTimeout(TIMEOUT, TimeUnit.SECONDS)
       httpClient.writeTimeout(TIMEOUT, TimeUnit.SECONDS)
       httpClient.connectTimeout(TIMEOUT, TimeUnit.SECONDS)
       return httpClient.build()
   }

    @Provides
    fun providesRetrofit(httpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://gorest.co.in/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(httpClient)
            .build()
    }

    @Provides
    fun providesAPIService(retrofit: Retrofit):
            APIService = retrofit.create(APIService::class.java)

}