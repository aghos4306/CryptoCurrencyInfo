package com.logical.cryptocurrencyinfo.domain.datastore.db

import androidx.room.*
import com.logical.cryptocurrencyinfo.domain.model.Coin
import com.logical.cryptocurrencyinfo.domain.model.CoinDetail


@Dao
interface CoinDetailDao {


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCoinDetail(coinDetail:CoinDetail)

    @Query("SELECT* FROM detail_table WHERE coinId LIKE :coinId")
    suspend fun getCoinDetail(coinId:String):CoinDetail

    @Update
    suspend fun updateCoin(coin: Coin)

}