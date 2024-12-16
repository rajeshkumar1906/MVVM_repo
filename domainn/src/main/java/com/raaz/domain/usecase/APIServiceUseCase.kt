package com.raaz.domain.usecase

import com.raaz.domain.repo.APIServiceRepository
import javax.inject.Inject

class APIServiceUseCase @Inject constructor(
   val apiServiceRepository: APIServiceRepository
) {
    operator suspend fun  invoke() = apiServiceRepository.getApiData()
}