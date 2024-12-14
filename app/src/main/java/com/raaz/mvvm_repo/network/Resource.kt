package com.raaz.mvvm_repo.network

import androidx.annotation.Keep
import retrofit2.HttpException

sealed class Resource<out T> {
    @Keep
    data class Success<T>(val result: T) : Resource<T>()

    @Keep
    data class Error<T>(val exception: Exception) : Resource<T>()
}

val <T> Resource<T>.isSuccessful get() = this is Resource.Success<T>
val <T> Resource<T>.isError get() = this is Resource.Error<T>

fun <T> T.toResource(): Resource<T> =
    try {
        Resource.Success(this)
    } catch (exception: HttpException) {
        Resource.Error(exception)
    }