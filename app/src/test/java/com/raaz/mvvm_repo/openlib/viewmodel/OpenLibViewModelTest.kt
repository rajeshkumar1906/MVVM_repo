package com.raaz.mvvm_repo.openlib.viewmodel

import com.raaz.data.Resource
import com.raaz.domain.model.openlib.OpenLibData
import com.raaz.domain.usecase.LibServiceUseCase
import com.raaz.mvvm_repo.sync.WorkManagerBuilder
import com.raaz.mvvm_repo.ui.theme.viewmodel.OpenLibViewModel
import com.raaz.testutils.CoroutineTestRule
import com.raaz.testutils.InstantExecutorExtension
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.junit.jupiter.api.extension.RegisterExtension

@OptIn(ExperimentalCoroutinesApi::class)
@ExtendWith(InstantExecutorExtension::class)
class OpenLibViewModelTest {
    @JvmField
    @RegisterExtension
    val coroutineTestRule = CoroutineTestRule()

    private val libServiceUseCase = mockk<LibServiceUseCase>(relaxed = true)
    private val workManagerBuilder = mockk<WorkManagerBuilder>()
    private val sut = OpenLibViewModel(libServiceUseCase,workManagerBuilder)

    @Test
    fun `return valid response when getting lib response`() =
        coroutineTestRule.runBlockingTest {
            coEvery { libServiceUseCase.invoke() }.returns(Resource.Success(openLibResponse))

            sut.getLibResponse()

            assert(openLibResponse == sut.libResponse.value)
        }


    private val openLibResponse = OpenLibData()
}