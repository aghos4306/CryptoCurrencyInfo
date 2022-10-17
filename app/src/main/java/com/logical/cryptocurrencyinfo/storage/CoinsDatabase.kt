package com.logical.cryptocurrencyinfo.storage

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.logical.cryptocurrencyinfo.domain.datastore.db.CoinDetailDao
import com.logical.cryptocurrencyinfo.domain.datastore.db.CoinsDao
import com.logical.cryptocurrencyinfo.domain.model.Coin
import com.logical.cryptocurrencyinfo.domain.model.CoinDetail

@Database(
    entities = [
        Coin::class,
        CoinDetail::class],
    version = 1,
    exportSchema = false
)
@TypeConverters(CoinsTypeConverter::class)
abstract class CoinsDatabase : RoomDatabase() {
    abstract fun coinsDao(): CoinsDao
    abstract fun coinDetailDao(): CoinDetailDao
}