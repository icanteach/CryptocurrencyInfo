package co.icanteach.apps.cryptocurrencyinfo.presentation.listing

import co.icanteach.apps.cryptocurrencyinfo.domain.Coin

data class CoinListingPageViewState constructor(
    val isLoading: Boolean = false,
    val coins: List<Coin> = emptyList(),
    val error: Throwable? = null
) {

    fun onShowLoading(): CoinListingPageViewState {
        return copy(isLoading = true)
    }

    fun onShowListingContent(coins: List<Coin>): CoinListingPageViewState {
        return copy(isLoading = false, coins = coins)
    }

}