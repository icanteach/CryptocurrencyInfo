package co.icanteach.apps.cryptocurrencyinfo.data

import co.icanteach.apps.cryptocurrencyinfo.data.source.remote.model.CoinResponse
import retrofit2.http.GET

interface CoinApi {

    @GET("coins")
    suspend fun fetchCoinListing(): List<CoinResponse>
}