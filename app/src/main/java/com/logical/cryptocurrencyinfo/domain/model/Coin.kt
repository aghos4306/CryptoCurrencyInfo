package com.logical.cryptocurrencyinfo.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import com.logical.cryptocurrencyinfo.common.Constants.COINS_TABLE

@Entity(tableName = COINS_TABLE)
data class Coin(
    @PrimaryKey
    val id: String,
    val isActive: Boolean,
    val name: String,
    val rank: Int,
    val symbol: String,
    var isFavourite:Boolean=false
)