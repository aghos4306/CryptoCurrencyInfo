package com.logical.cryptocurrencyinfo.domain.use_case.get_coins

import com.logical.cryptocurrencyinfo.data.repository.CoinsRepositoryImpl
import com.logical.cryptocurrencyinfo.domain.model.Coin
import com.logical.cryptocurrencyinfo.domain.model.CoinDetail
import com.logical.cryptocurrencyinfo.domain.use_case.get_coin.GetCoinUseCase
import com.nhaarman.mockitokotlin2.given
import kotlinx.coroutines.runBlocking
import org.junit.Assert.*

import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.MockitoAnnotations

class GetCoinsUseCaseTest {

    private val coinOne = Coin("1", false, "Bitcoin", 1, "BTC", true)
    private val coinTwo = Coin("2", false, "Bitcoin", 2, "ETH", true)

    private val listOfCoins = listOf<Coin>(coinOne, coinTwo)
    private val coinDetail = CoinDetail(
        "1", "Bitcoin",
        "", "BTC", 1, false, emptyList(), emptyList(), false
    )
    @Mock
    lateinit var repository: CoinsRepositoryImpl
    private lateinit var classUnderTest: GetCoinsUseCase

    @Before
    fun setUp() {
        MockitoAnnotations.openMocks(this)
        classUnderTest = GetCoinsUseCase(repository)
    }

    @Test
    operator fun invoke() = runBlocking {

        // given
        val expectedResult = listOfCoins

        given(repository.getCoins()).willReturn(
            listOfCoins
        )

        // when
        var actualResult: List<Coin>? = null
        classUnderTest().collect {
            actualResult = it.data
        }

        // then
        assertEquals(expectedResult, actualResult)
    }
}