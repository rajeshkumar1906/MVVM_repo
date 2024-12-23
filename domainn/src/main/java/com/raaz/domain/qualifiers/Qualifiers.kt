package com.raaz.domain.qualifiers

import javax.inject.Qualifier

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class APIServiceRetrofit

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class OpenLibRetrofit

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class RefreshTokenRetrofit

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class RefreshTokenHttpClient