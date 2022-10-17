package com.logical.cryptocurrencyinfo.presentation.coin_list

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.logical.cryptocurrencyinfo.presentation.Screen
import com.logical.cryptocurrencyinfo.presentation.coin_list.components.CoinListItem

@Composable
fun CoinListScreen(
    navController: NavController,
    viewModel: CoinListViewModel = hiltViewModel()

) {
    val state = viewModel.state.value


    LaunchedEffect(key1 = viewModel.isFavouriteState.value) {}



    Box(modifier = Modifier.fillMaxSize()) {
        LazyColumn(modifier = Modifier.fillMaxSize()) {
            items(state.coins) { coin ->
                CoinListItem(coin = coin, onItemClicked = {
                    navController.navigate(
                        Screen.CoinDetailScreen.route + "/${coin.id}"
                    )

                }, onItemUpdated = {
                    coin.isFavourite = !coin.isFavourite
                    viewModel.updateCoin(coin)
                })

            }

        }
        if (state.Error.isNotBlank()) {
            Text(
                text = state.Error,
                color = MaterialTheme.colors.error,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp)
                    .align(Alignment.Center)
            )

        }
        if (state.isLoading) {
            CircularProgressIndicator(
                modifier =
                Modifier.align(Alignment.Center)
            )
        }

    }

}