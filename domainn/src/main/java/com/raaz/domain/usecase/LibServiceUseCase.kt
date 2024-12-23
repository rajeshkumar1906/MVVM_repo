package com.raaz.domain.usecase

import com.raaz.domain.repo.LibServiceRepository
import com.raaz.domain.repository.OpenLibService
import javax.inject.Inject

class LibServiceUseCase @Inject constructor(
    val libServiceRepository: LibServiceRepository
) {
    operator suspend fun invoke() = libServiceRepository.getLibData()
}