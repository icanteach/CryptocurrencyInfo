package co.icanteach.apps.cryptocurrencyinfo.presentation.listing

import com.google.common.truth.Truth
import org.junit.Test

class CoinListingPageViewStateTest {


    @Test
    fun `when onShowLoading is called, then return isLoading value of CoinListingPageViewState as true `() {

        // Given
        val initialViewState = CoinListingPageViewState(isLoading = false)

        // When
        val actualResult = initialViewState.onShowLoading()

        // Then
        Truth.assertThat(actualResult.isLoading).isTrue()
    }

    @Test
    fun `when onShowListingContent is called, then return isLoading value of CoinListingPageViewState as false `() {

        // Given
        val initialViewState = CoinListingPageViewState(isLoading = true)

        // When
        val actualResult = initialViewState.onShowListingContent(coins = emptyList())

        // Then
        Truth.assertThat(actualResult.isLoading).isFalse()
    }
}