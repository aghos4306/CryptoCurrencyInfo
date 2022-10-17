package com.logical.cryptocurrencyinfo.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.logical.cryptocurrencyinfo.presentation.coin_detail.CoinDetailScreen
import com.logical.cryptocurrencyinfo.presentation.coin_list.CoinListScreen
import com.logical.cryptocurrencyinfo.presentation.ui.theme.CryptoCurrencyInfoTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CryptoCurrencyInfoTheme {
                androidx.compose.material.Surface(
                    modifier =
                    Modifier.background(color = MaterialTheme.colors.background)
                ) {
                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        //startDestination = Screen.LoginScreen.route
                        startDestination = Screen.CoinListScreen.route
                    ) {
                        composable(route = Screen.CoinListScreen.route) {
                            CoinListScreen(navController)
                        }
                        composable(
                            route = Screen.CoinDetailScreen.route + "/{coinId}"
                        ) {
                            CoinDetailScreen()
                        }

                    }

                }

            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    CryptoCurrencyInfoTheme {

    }
}
