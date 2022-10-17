package com.logical.cryptocurrencyinfo.data.repository

import com.logical.cryptocurrencyinfo.data.remote.CoinPaprikaApi
import com.logical.cryptocurrencyinfo.domain.datastore.db.CoinDetailDao
import com.logical.cryptocurrencyinfo.domain.datastore.db.CoinsDao
import com.logical.cryptocurrencyinfo.domain.model.Coin
import com.logical.cryptocurrencyinfo.domain.model.CoinDetail
import com.nhaarman.mockitokotlin2.whenever
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.MockitoAnnotations

class CoinsRepositoryImplTest {

    private val coinOne = Coin("1", false, "Bitcoin", 1, "BTC", true)
    private val coinOneUpdated = Coin("1", false, "Bitcoin", 1, "BTC", false)
    private val coinTwo = Coin("2", false, "Bitcoin", 2, "ETH", true)
    private val coinDetail = CoinDetail(
        "1", "Bitcoin",
        "", "BTC", 1, false, emptyList(), emptyList(), false
    )
    private val listOfCoins = listOf<Coin>(coinOne, coinTwo)


    @Mock
    lateinit var api: CoinPaprikaApi

    @Mock
    lateinit var coinsDao: CoinsDao

    @Mock
    lateinit var coinDetailDao: CoinDetailDao

    private lateinit var classUnderTest: CoinsRepositoryImpl


    @Before
    fun setUp() {
        MockitoAnnotations.openMocks(this)
        classUnderTest = CoinsRepositoryImpl(api, coinsDao, coinDetailDao)
    }

    @Test
    fun `getCoins()_return list of Coin`() = runBlocking {
        val expectedResult = listOfCoins
        whenever(coinsDao.getCoins()).thenReturn(listOfCoins)
        val result = classUnderTest.getCoins()
        assertEquals(expectedResult, result)
    }

    @Test
    fun `getCoinById() with valid id _return  CoinDetail`() = runBlocking {
        val expectedResult = coinDetail
        whenever(coinDetailDao.getCoinDetail("1")).thenReturn(coinDetail)
        val result = classUnderTest.getCoinById("1")
        assertEquals(expectedResult, result)

    }

}