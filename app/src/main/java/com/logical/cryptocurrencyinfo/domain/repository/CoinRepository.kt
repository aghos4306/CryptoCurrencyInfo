package com.logical.cryptocurrencyinfo.domain.repository

import com.logical.cryptocurrencyinfo.domain.model.Coin
import com.logical.cryptocurrencyinfo.domain.model.CoinDetail

interface CoinRepository {

    suspend fun getCoins(): List<Coin>
    suspend fun getCoinById(coinId: String): CoinDetail
    suspend fun updateCoin(coin: Coin)


}