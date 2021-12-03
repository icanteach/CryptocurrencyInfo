package co.icanteach.apps.cryptocurrencyinfo.presentation.listing

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import co.icanteach.apps.cryptocurrencyInfo.Resource
import co.icanteach.apps.cryptocurrencyinfo.domain.FetchCoinListingUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class CoinListingViewModel @Inject constructor(
    private val listingUseCase: FetchCoinListingUseCase
) : ViewModel() {

    private val _pageViewState = mutableStateOf(CoinListingPageViewState())
    val pageViewState: State<CoinListingPageViewState> = _pageViewState


    init {
        fetchCoinListing()
    }

    private fun fetchCoinListing() {
        listingUseCase.fetchCoinListing()
            .onEach { result ->
                when (result) {
                    is Resource.Success -> {
                        _pageViewState.value =
                            _pageViewState.value.onShowListingContent(coins = result.data)
                    }
                    is Resource.Error -> {

                    }
                    is Resource.Loading -> {
                        _pageViewState.value = CoinListingPageViewState().onShowLoading()
                    }
                }
            }.launchIn(viewModelScope)
    }
}