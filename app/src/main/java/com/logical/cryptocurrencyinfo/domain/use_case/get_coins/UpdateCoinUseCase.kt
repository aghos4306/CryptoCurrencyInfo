package com.logical.cryptocurrencyinfo.domain.use_case.get_coins

import com.logical.cryptocurrencyinfo.common.Resource
import com.logical.cryptocurrencyinfo.data.remote.dto.toCoinDetail
import com.logical.cryptocurrencyinfo.domain.model.CoinDetail
import com.logical.cryptocurrencyinfo.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import okio.IOException
import retrofit2.HttpException
import javax.inject.Inject

class UpdateCoinUseCase @Inject constructor(
    private val repository: CoinRepository
) {


}