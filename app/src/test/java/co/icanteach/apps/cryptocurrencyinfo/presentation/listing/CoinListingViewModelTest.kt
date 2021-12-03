package co.icanteach.apps.cryptocurrencyinfo.presentation.listing

import co.icanteach.apps.cryptocurrencyInfo.Resource
import co.icanteach.apps.cryptocurrencyinfo.TestCoroutineRule
import co.icanteach.apps.cryptocurrencyinfo.domain.Coin
import co.icanteach.apps.cryptocurrencyinfo.domain.FetchCoinListingUseCase
import com.google.common.truth.Truth
import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.impl.annotations.MockK
import kotlinx.coroutines.flow.flow
import org.junit.Before
import org.junit.Rule
import org.junit.Test


class CoinListingViewModelTest {

    @MockK
    lateinit var fetchCoinListingUseCase: FetchCoinListingUseCase

    private lateinit var viewModel: CoinListingViewModel

    // Set the main coroutines dispatcher for unit testing.
    @get:Rule
    var testCoroutineRule = TestCoroutineRule()

    @Before
    fun setUp() {
        MockKAnnotations.init(this)
    }


    @Test
    fun `given Resource Loading, then update _pageViewState isLoading as true`() {

        // Given
        every { fetchCoinListingUseCase.fetchCoinListing() } returns flow {
            emit(Resource.Loading<List<Coin>>())
        }

        // When
        viewModel = CoinListingViewModel(fetchCoinListingUseCase)

        // Then
        val actualResult = viewModel.pageViewState
        Truth.assertThat(actualResult.value.isLoading).isTrue()

    }

    @Test
    fun `given Resource Success, then update _pageViewState isLoading as false`() {

        // Given
        every { fetchCoinListingUseCase.fetchCoinListing() } returns flow {
            emit(Resource.Success<List<Coin>>(emptyList()))
        }

        // When
        viewModel = CoinListingViewModel(fetchCoinListingUseCase)

        // Then
        val actualResult = viewModel.pageViewState
        Truth.assertThat(actualResult.value.isLoading).isFalse()
    }

    @Test
    fun `given Resource Success, then update _pageViewState coins field`() {

        // Given
        val coin = Coin(
            id = "btc-bitcoin",
            name = "Bitcoin",
            symbol = "BTC",
            rank = 1,
            isNew = false,
            isActive = true,
            type = "coin"
        )
        every { fetchCoinListingUseCase.fetchCoinListing() } returns flow {
            emit(Resource.Success<List<Coin>>(listOf(coin)))
        }

        // When
        viewModel = CoinListingViewModel(fetchCoinListingUseCase)

        // Then
        val actualResult = viewModel.pageViewState
        Truth.assertThat(actualResult.value.coins).isNotEmpty()
    }
}