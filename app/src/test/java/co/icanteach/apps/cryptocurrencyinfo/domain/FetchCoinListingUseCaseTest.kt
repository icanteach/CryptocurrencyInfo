package co.icanteach.apps.cryptocurrencyinfo.domain

import co.icanteach.apps.cryptocurrencyInfo.Resource
import co.icanteach.apps.cryptocurrencyinfo.FakeCoinRepository
import co.icanteach.apps.cryptocurrencyinfo.TestCoroutineRule
import co.icanteach.apps.cryptocurrencyinfo.data.CoinRepository
import com.google.common.truth.Truth
import io.mockk.every
import io.mockk.verify
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.collectIndexed
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.last
import kotlinx.coroutines.launch
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.TestCoroutineExceptionHandler
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class FetchCoinListingUseCaseTest {

    private lateinit var repository: CoinRepository
    private lateinit var mapper: CoinListingMapper

    private lateinit var listingUseCase: FetchCoinListingUseCase

    @get:Rule
    val testCoroutineRule = TestCoroutineRule()

    @Before
    fun setUp() {

        repository = FakeCoinRepository()
        mapper = CoinListingMapper()
        listingUseCase = FetchCoinListingUseCase(repository, mapper)
    }

    @Test
    fun `test always first emit Resource Loading`() {
        testCoroutineRule.runBlockingTest {
            val coinListingFlow = listingUseCase.fetchCoinListing().first()
            Truth.assertThat(coinListingFlow).isInstanceOf(Resource.Loading::class.java)
        }
    }

    @Test
    fun `test always emit Resource Success when result is success`() {
        testCoroutineRule.runBlockingTest {
            val coinListingFlow = listingUseCase.fetchCoinListing().last()
            Truth.assertThat(coinListingFlow).isInstanceOf(Resource.Success::class.java)
        }
    }
}