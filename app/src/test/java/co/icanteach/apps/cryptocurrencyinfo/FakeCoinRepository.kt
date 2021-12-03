package co.icanteach.apps.cryptocurrencyinfo

import co.icanteach.apps.cryptocurrencyinfo.data.CoinRepository
import co.icanteach.apps.cryptocurrencyinfo.data.source.remote.model.CoinResponse

class FakeCoinRepository : CoinRepository {
    override suspend fun fetchCoinListing(): List<CoinResponse> {
        return listOf()
    }
}