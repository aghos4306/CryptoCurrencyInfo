package com.logical.cryptocurrencyinfo.presentation.coin_detail

import com.logical.cryptocurrencyinfo.domain.model.Coin
import com.logical.cryptocurrencyinfo.domain.model.CoinDetail

data class CoinDetailState(
    val isLoading:Boolean=false,
    val Error:String="",
    val coin:CoinDetail? = null
)