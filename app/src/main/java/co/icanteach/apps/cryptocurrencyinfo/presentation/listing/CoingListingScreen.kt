package co.icanteach.apps.cryptocurrencyinfo.presentation.listing

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.compose.foundation.lazy.items
import co.icanteach.apps.cryptocurrencyinfo.presentation.listing.composable.CoinListingItem

@Composable
fun CoinListingScreen(
    navController: NavController,
    viewModel: CoinListingViewModel = hiltViewModel()
) {

    val state = viewModel.pageViewState.value

    Box(modifier = Modifier.fillMaxSize()) {
        LazyColumn {
            items(state.coins) { coin ->
                CoinListingItem(
                    viewState = CoinListingItemViewState(coin = coin),
                    onItemClick = {
                    }
                )
            }
        }

    }
}