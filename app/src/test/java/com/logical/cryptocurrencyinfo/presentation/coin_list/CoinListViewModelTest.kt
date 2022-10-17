package com.logical.cryptocurrencyinfo.presentation.coin_list

import androidx.compose.runtime.internal.illegalDecoyCallException
import com.logical.cryptocurrencyinfo.common.Resource
import com.logical.cryptocurrencyinfo.data.repository.CoinsRepositoryImpl
import com.logical.cryptocurrencyinfo.domain.model.Coin
import com.logical.cryptocurrencyinfo.domain.model.CoinDetail
import com.logical.cryptocurrencyinfo.domain.use_case.get_coins.GetCoinsUseCase
import com.logical.cryptocurrencyinfo.presentation.MainDispatcherRule
import com.nhaarman.mockitokotlin2.given
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.advanceUntilIdle
import kotlinx.coroutines.test.runTest
import net.bytebuddy.implementation.bytecode.Throw
import org.junit.Assert
import org.junit.Assert.assertEquals
import org.junit.Assert.assertThrows
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mock
import org.mockito.MockitoAnnotations
import retrofit2.HttpException
import retrofit2.Response

class CoinListViewModelTest {


    private val coinOne = Coin("1", false, "Bitcoin", 1, "BTC", true)
    private val coinTwo = Coin("2", false, "Bitcoin", 2, "ETH", true)

    private val listOfCoins = listOf<Coin>(coinOne, coinTwo)
    private val coinDetail = CoinDetail(
        "1", "Bitcoin",
        "", "BTC", 1, false, emptyList(), emptyList(), false
    )

    @Mock
    lateinit var repositoryImpl: CoinsRepositoryImpl

    lateinit var getCoinsUseCase: GetCoinsUseCase

    private lateinit var viewModel: CoinListViewModel

    @get:Rule
    val mainDispatcherRule = MainDispatcherRule()


    @Before
    fun setUp() {
        MockitoAnnotations.openMocks(this)
        getCoinsUseCase= GetCoinsUseCase(repositoryImpl)
        viewModel= CoinListViewModel(getCoinsUseCase)

    }


    @Test
    fun `Given initial state when called init Then set viewState dataLoading sets false`() {
        runBlocking {
            val expectedResult = CoinListState(
                isLoading = false,
                Error = "",
                coins = emptyList()
            )
            // When
            val actualResult = viewModel.state.value

            // Then
            assertEquals(expectedResult, actualResult)
        }
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun `Given successful usecase execution When called init Then update the view state with listOf coins`() {
        runTest {
            // Given
            given(repositoryImpl.getCoins()).willReturn(
                listOf(coinOne)
            )

            val expectedResult = CoinListState(
                isLoading = false,
                Error = "",
                coins = listOf(coinOne)
            )
            getCoinsUseCase = GetCoinsUseCase(repositoryImpl)
            viewModel = CoinListViewModel(getCoinsUseCase)
            advanceUntilIdle()
            // When
            val actualResult = viewModel.state.value

            // Then
            assertEquals(expectedResult, actualResult)
        }
    }

}