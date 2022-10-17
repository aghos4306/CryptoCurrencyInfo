package com.logical.cryptocurrencyinfo.presentation

sealed class Screen(
   val route:String )
{
    object CoinListScreen:Screen("coin_list_screen")
    object CoinDetailScreen:Screen("coin_detail_screen")
    object LoginScreen:Screen("login_screen")
    object RegistrationScreen:Screen("registration_screen")

}