package com.logical.cryptocurrencyinfo.presentation.coin_list.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.logical.cryptocurrencyinfo.R
import com.logical.cryptocurrencyinfo.domain.model.Coin

@Composable
fun CoinListItem(
    coin: Coin,
    onItemClicked: (Coin) -> Unit,
    onItemUpdated:(Coin)-> Unit
) {


    Row(modifier = Modifier
        .fillMaxWidth()
        .padding(20.dp),
        horizontalArrangement = Arrangement.Start) {

        Box( modifier = Modifier.weight(1f)
            .clickable { onItemUpdated(coin) }) {

            Image(
                painterResource(
                    if (!coin.isFavourite)
                        R.drawable.ic_un_favourite
                    else
                        R.drawable.ic_favourite
                ),
                contentDescription = "UnFavourite Icon",
                contentScale = ContentScale.Crop

            )


        }

        Text(
            text = ". ${coin.name} (${coin.symbol})",
            style = MaterialTheme.typography.body1,
            overflow = TextOverflow.Ellipsis,
            modifier = Modifier.weight(8f)
                .clickable { onItemClicked(coin) }
        )


        Text(
            text = if (coin.isActive) "active" else "inactive",
            fontStyle = FontStyle.Italic,
            textAlign = TextAlign.End,
            style = MaterialTheme.typography.body2,
            overflow = TextOverflow.Ellipsis,
            color = if (coin.isActive) Color.Green else Color.Red,
            modifier = Modifier.weight(2f)


            // modifier = Modifier.Companion.
        )
    }
}