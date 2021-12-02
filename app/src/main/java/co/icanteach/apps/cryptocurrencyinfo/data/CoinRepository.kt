package co.icanteach.apps.cryptocurrencyinfo.data

import co.icanteach.apps.cryptocurrencyinfo.data.source.remote.model.CoinResponse

interface CoinRepository {

    suspend fun fetchCoinListing(): List<CoinResponse>
}