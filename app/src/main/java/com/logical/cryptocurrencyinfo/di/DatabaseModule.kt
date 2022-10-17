package com.logical.cryptocurrencyinfo.di

import android.content.Context
import androidx.room.Room
import com.logical.cryptocurrencyinfo.common.Constants.DATABASE_NAME
import com.logical.cryptocurrencyinfo.storage.CoinsDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context) =
        Room.databaseBuilder(context, CoinsDatabase::class.java, DATABASE_NAME)
            .build()

    @Provides
    @Singleton
    fun provideDao(database: CoinsDatabase) = database.coinsDao()

    @Provides
    @Singleton
    fun provideDetailsDao(database: CoinsDatabase) = database.coinDetailDao()


}