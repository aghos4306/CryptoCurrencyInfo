package com.logical.cryptocurrencyinfo.data.remote

import com.logical.cryptocurrencyinfo.data.remote.dto.CoinDetailDto
import com.logical.cryptocurrencyinfo.data.remote.dto.CoinDto
import com.logical.cryptocurrencyinfo.domain.model.Coin
import retrofit2.http.GET
import retrofit2.http.Path

interface CoinPaprikaApi
{
   @GET("/v1/coins")
   suspend fun getCoins():List<CoinDto>

   @GET("/v1/coins/{coinId}")
   suspend fun getCoinById(@Path("coinId") coinId:String ):CoinDetailDto




}