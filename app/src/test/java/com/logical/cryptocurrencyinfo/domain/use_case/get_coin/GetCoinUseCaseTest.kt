package com.logical.cryptocurrencyinfo.domain.use_case.get_coin


import android.util.Log
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.logical.cryptocurrencyinfo.common.Resource
import com.logical.cryptocurrencyinfo.data.repository.CoinsRepositoryImpl
import com.logical.cryptocurrencyinfo.domain.model.Coin
import com.logical.cryptocurrencyinfo.domain.model.CoinDetail
import com.logical.cryptocurrencyinfo.domain.use_case.get_coins.GetCoinsUseCase
import com.nhaarman.mockitokotlin2.given
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule
import org.mockito.Mock
import org.mockito.MockitoAnnotations

class GetCoinUseCaseTest {

    private val coinOne = Coin("1", false, "Bitcoin", 1, "BTC", true)
    private val coinTwo = Coin("2", false, "Bitcoin", 2, "ETH", true)

    private val listOfCoins = listOf<Coin>(coinOne, coinTwo)
    private val coinDetail = CoinDetail(
        "1", "Bitcoin",
        "", "BTC", 1, false, emptyList(), emptyList(), false
    )
    @Mock
    lateinit var repository: CoinsRepositoryImpl
    private lateinit var classUnderTest: GetCoinUseCase

    @Before
    fun setUp() {
        MockitoAnnotations.openMocks(this)
        classUnderTest = GetCoinUseCase(repository)
    }

    @Test
     fun `invoke() valid input return CoinDetail`() = runBlocking {

        // given
        val expectedResult = coinDetail

        given(repository.getCoinById("1")).willReturn(
            coinDetail
        )

        // when
        var actualResult: CoinDetail? = null
        classUnderTest("1").collect {
            actualResult = it.data
        }

        // then
        assertEquals(expectedResult, actualResult)
    }


    @Test
    fun `invoke() wrong coinId return wrong coin details`() = runBlocking {

        // given
        val expectedResult = coinDetail

        given(repository.getCoinById("1")).willReturn(
            coinDetail
        )

        // when
        var actualResult: CoinDetail? = null
        classUnderTest("2").collect {
            actualResult = it.data
        }

        // then
        assertNotEquals(expectedResult, actualResult)
    }
}