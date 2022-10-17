package com.logical.cryptocurrencyinfo.di

import com.logical.cryptocurrencyinfo.common.Constants.BASE_URL
import com.logical.cryptocurrencyinfo.data.remote.CoinPaprikaApi
import com.logical.cryptocurrencyinfo.data.repository.CoinsRepositoryImpl
import com.logical.cryptocurrencyinfo.domain.datastore.db.CoinDetailDao
import com.logical.cryptocurrencyinfo.domain.datastore.db.CoinsDao
import com.logical.cryptocurrencyinfo.domain.repository.CoinRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun providePaprikaApi(): CoinPaprikaApi {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(CoinPaprikaApi::class.java)
    }

    @Provides
    @Singleton
    fun provideCoinRepository(
        api: CoinPaprikaApi,
        coinsDao: CoinsDao,
        coinDetailDao: CoinDetailDao
    ): CoinRepository {
        return CoinsRepositoryImpl(api,coinsDao, coinDetailDao = coinDetailDao)
    }


}