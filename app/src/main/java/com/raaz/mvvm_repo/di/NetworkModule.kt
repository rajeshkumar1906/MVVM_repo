package com.raaz.mvvm_repo.di

import android.content.Context
import com.raaz.domain.qualifiers.APIServiceRetrofit
import com.raaz.domain.qualifiers.OpenLibRetrofit
import com.raaz.domain.repo.LibServiceRepository
import com.raaz.domain.repository.APIService
import com.raaz.domain.repository.OpenLibService
import com.raaz.mvvm_repo.MyApplication
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.DelicateCoroutinesApi
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Qualifier
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {
    private const val TIMEOUT = 60L

    @OptIn(DelicateCoroutinesApi::class)
    @Provides
    @Singleton
    fun providesMainApplication(@ApplicationContext context: Context): MyApplication {
        return context as MyApplication
    }

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

    @APIServiceRetrofit
    @Provides
    fun providesRetrofit(httpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://gorest.co.in/")
            .addConverterFactory(GsonConverterFactory.create())
//            .addCallAdapterFactory(RX)
            .client(httpClient)
            .build()
    }

    @OpenLibRetrofit
    @Provides
    fun providesLibRetrofit(httpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl("http://openlibrary.org/")
            .addConverterFactory(GsonConverterFactory.create())
//            .addCallAdapterFactory(RX)
            .client(httpClient)
            .build()
    }


    @Provides
    fun providesAPIService(@APIServiceRetrofit retrofit: Retrofit):
            APIService = retrofit.create(APIService::class.java)

    @Provides
    fun providesLibApiService(@OpenLibRetrofit retrofit: Retrofit):
            OpenLibService = retrofit.create(OpenLibService::class.java)

}