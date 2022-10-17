package com.logical.cryptocurrencyinfo.data.repository

import com.logical.cryptocurrencyinfo.data.remote.CoinPaprikaApi
import com.logical.cryptocurrencyinfo.data.remote.dto.toCoin
import com.logical.cryptocurrencyinfo.data.remote.dto.toCoinDetail
import com.logical.cryptocurrencyinfo.domain.datastore.db.CoinDetailDao
import com.logical.cryptocurrencyinfo.domain.datastore.db.CoinsDao
import com.logical.cryptocurrencyinfo.domain.model.Coin
import com.logical.cryptocurrencyinfo.domain.model.CoinDetail
import com.logical.cryptocurrencyinfo.domain.repository.CoinRepository
import javax.inject.Inject


class CoinsRepositoryImpl @Inject constructor(
    private val api: CoinPaprikaApi,
    private val coinsDao: CoinsDao,
    private val coinDetailDao: CoinDetailDao
) : CoinRepository {
    override suspend fun getCoins(): List<Coin> {
        val localData = coinsDao.getCoins().sortedBy {
             !it.isFavourite
        }
        return localData.ifEmpty {
            val coins = api.getCoins().map { it.toCoin() }
            coinsDao.insertCoins(coins)
            coins
        }

    }


    override suspend fun getCoinById(coinId: String): CoinDetail {
        val localData = coinDetailDao.getCoinDetail(coinId)
        return if (localData != null) localData
        else {
            val coinDetail = api.getCoinById(coinId).toCoinDetail()
            coinDetailDao.insertCoinDetail(coinDetail)
            coinDetail
        }
    }

    override suspend fun updateCoin(coin: Coin) {
        coinDetailDao.updateCoin(coin)
    }
}