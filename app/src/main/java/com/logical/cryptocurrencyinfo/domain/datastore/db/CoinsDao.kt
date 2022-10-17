package com.logical.cryptocurrencyinfo.domain.datastore.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.logical.cryptocurrencyinfo.domain.model.Coin


@Dao
interface CoinsDao {

    @Query("SELECT* FROM coins_table" )
    suspend fun getCoins():List<Coin>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCoins(coins:List<Coin>)


}