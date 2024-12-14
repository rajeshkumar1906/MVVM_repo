package com.raaz.mvvm_repo.usecase

import com.raaz.mvvm_repo.domain.APIServiceRepository
import javax.inject.Inject

class APIServiceUseCase @Inject constructor(
   val apiServiceRepository: APIServiceRepository
) {
    operator suspend fun  invoke() = apiServiceRepository.getApiData()
}