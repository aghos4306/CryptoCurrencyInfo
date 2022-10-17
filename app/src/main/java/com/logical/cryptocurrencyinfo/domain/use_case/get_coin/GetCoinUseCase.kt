package com.logical.cryptocurrencyinfo.domain.use_case.get_coin

import com.logical.cryptocurrencyinfo.common.Resource
import com.logical.cryptocurrencyinfo.data.remote.dto.toCoinDetail
import com.logical.cryptocurrencyinfo.domain.model.CoinDetail
import com.logical.cryptocurrencyinfo.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import okio.IOException
import retrofit2.HttpException
import javax.inject.Inject

class GetCoinUseCase @Inject constructor(
    private val repository: CoinRepository
) {

    operator fun invoke(coinId: String): Flow<Resource<CoinDetail>> = flow {
        try {
            emit(Resource.Loading<CoinDetail>())
            val coins = repository.getCoinById(coinId)

            emit(Resource.Success<CoinDetail>(coins))

        } catch (e: HttpException) {
            emit(Resource.Error<CoinDetail>(e.localizedMessage ?: "Unexpected error occured"))
        } catch (e: IOException) {
            emit(Resource.Error<CoinDetail>("Couldn't reach server. Please check your internet connection"))
        }
    }


}