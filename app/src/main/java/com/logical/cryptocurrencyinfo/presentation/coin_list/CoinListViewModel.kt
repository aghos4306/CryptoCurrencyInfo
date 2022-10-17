package com.logical.cryptocurrencyinfo.presentation.coin_list

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.logical.cryptocurrencyinfo.common.Resource
import com.logical.cryptocurrencyinfo.domain.model.Coin
import com.logical.cryptocurrencyinfo.domain.use_case.get_coins.GetCoinsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CoinListViewModel @Inject constructor(
    private val getCoinsUseCase: GetCoinsUseCase
) : ViewModel() {

    private val _state = mutableStateOf<CoinListState>(CoinListState())
    val state: State<CoinListState> = _state

    private val _isFavouriteState = mutableStateOf<Boolean>(false)
    val isFavouriteState: State<Boolean> = _isFavouriteState

    init {
        getCoins()
    }



    private fun getCoins() {
        getCoinsUseCase().onEach { result ->
            when (result) {
                is Resource.Success -> {
                    _state.value = CoinListState(coins = result.data ?: emptyList())

                }
                is Resource.Error -> {
                    _state.value = CoinListState(
                        error(
                            result.message ?: "An unexpected error occurred"
                        )
                    )

                }
                is Resource.Loading -> {
                    _state.value = CoinListState(isLoading = true)

                }
            }

        }.launchIn(viewModelScope)

    }

    fun updateCoin(coin: Coin){
        viewModelScope.launch {
            getCoinsUseCase.updateCoin(coin)
            _isFavouriteState.value= !_isFavouriteState.value
        }
    }


}