package co.icanteach.apps.cryptocurrencyinfo.presentation.listing

import co.icanteach.apps.cryptocurrencyinfo.domain.Coin
import com.google.common.truth.Truth
import org.junit.Test

class CoinListingItemViewStateTest {

    @Test
    fun `given coin content, when getDisplayText, then should return expected formatted text`() {

        // Given
        val givenCoin = Coin(
            id = "btc-bitcoin",
            name = "Bitcoin",
            symbol = "BTC",
            rank = 1,
            isNew = false,
            isActive = true,
            type = "coin"
        )
        val expectedResult = "1. Bitcoin (BTC)"

        val givenViewState = CoinListingItemViewState(givenCoin)

        // When
        val actualResult = givenViewState.getDisplayText()

        // Then
        Truth.assertThat(actualResult).isEqualTo(expectedResult)
    }

    @Test
    fun `given isActive as true coin content, when getActivityText, then should return active`() {

        // Given
        val givenCoin = Coin(
            id = "btc-bitcoin",
            name = "Bitcoin",
            symbol = "BTC",
            rank = 1,
            isNew = false,
            isActive = true,
            type = "coin"
        )
        val expectedResult = "active"

        val givenViewState = CoinListingItemViewState(givenCoin)

        // When
        val actualResult = givenViewState.getActivityText()

        // Then
        Truth.assertThat(actualResult).isEqualTo(expectedResult)
    }

    @Test
    fun `given isActive as false coin content, when getActivityText, then should return inactive`() {

        // Given
        val givenCoin = Coin(
            id = "btc-bitcoin",
            name = "Bitcoin",
            symbol = "BTC",
            rank = 1,
            isNew = false,
            isActive = false,
            type = "coin"
        )
        val expectedResult = "inactive"

        val givenViewState = CoinListingItemViewState(givenCoin)

        // When
        val actualResult = givenViewState.getActivityText()

        // Then
        Truth.assertThat(actualResult).isEqualTo(expectedResult)
    }
}