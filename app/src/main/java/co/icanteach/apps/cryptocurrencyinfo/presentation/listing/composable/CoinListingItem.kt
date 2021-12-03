package co.icanteach.apps.cryptocurrencyinfo.presentation.listing.composable

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import co.icanteach.apps.cryptocurrencyinfo.designsystem.AppTheme
import co.icanteach.apps.cryptocurrencyinfo.domain.Coin
import co.icanteach.apps.cryptocurrencyinfo.presentation.listing.CoinListingItemViewState

@Composable
fun CoinListingItem(
    viewState: CoinListingItemViewState,
    onItemClick: (Coin) -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onItemClick(viewState.coin) }
            .padding(16.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = viewState.getDisplayText(),
            style = AppTheme.typography.body,
            overflow = TextOverflow.Ellipsis,
            color = Color.White
        )
        Text(
            text = viewState.getActivityText(),
            color = viewState.getActivityTextColor(),
            fontStyle = FontStyle.Italic,
            textAlign = TextAlign.End,
            style = AppTheme.typography.body,
            modifier = Modifier.align(CenterVertically)
        )
    }

}