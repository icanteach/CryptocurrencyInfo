package co.icanteach.apps.cryptocurrencyinfo.data

import co.icanteach.apps.cryptocurrencyinfo.data.source.remote.model.CoinResponse
import javax.inject.Inject

class CoinRepositoryImpl @Inject constructor(private val coinApi: CoinApi) : CoinRepository {
    override suspend fun fetchCoinListing(): List<CoinResponse> {
        return coinApi.fetchCoinListing()
    }
}