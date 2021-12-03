package co.icanteach.apps.cryptocurrencyinfo.presentation.listing

import androidx.compose.ui.graphics.Color
import co.icanteach.apps.cryptocurrencyinfo.domain.Coin

class CoinListingItemViewState(val coin: Coin) {


    fun getDisplayText(): String {
        return "${coin.rank}. ${coin.name} (${coin.symbol})"
    }

    fun getActivityText(): String {
        return if (coin.isActive) "active" else "inactive"
    }

    fun getActivityTextColor(): Color {
        return if (coin.isActive) Color.Green else Color.Black
    }
}