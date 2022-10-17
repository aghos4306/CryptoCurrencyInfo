package com.logical.cryptocurrencyinfo.presentation.coin_list

import com.logical.cryptocurrencyinfo.domain.model.Coin

data class CoinListState(
    val isLoading:Boolean=false,
    val Error:String="",
    val coins:List<Coin> = emptyList()
)