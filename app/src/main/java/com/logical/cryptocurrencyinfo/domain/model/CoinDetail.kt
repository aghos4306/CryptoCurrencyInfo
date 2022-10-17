package com.logical.cryptocurrencyinfo.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.logical.cryptocurrencyinfo.common.Constants.DETAIL_TABLE
import com.logical.cryptocurrencyinfo.data.remote.dto.TeamMember
import org.jetbrains.annotations.NotNull

@Entity(tableName = DETAIL_TABLE)
data class CoinDetail(
    @PrimaryKey
    val coinId:String,
    val name:String,
    val description:String,
    val symbol:String,
    val rank:Int,
    val isActive:Boolean,

    val tags:List<String>,
    val team:List<TeamMember>,
    val isFavourite:Boolean=false
){}