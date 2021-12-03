package co.icanteach.apps.cryptocurrencyinfo.domain

import co.icanteach.apps.cryptocurrencyInfo.Resource
import co.icanteach.apps.cryptocurrencyinfo.data.CoinRepository
import co.icanteach.apps.cryptocurrencyinfo.data.source.remote.model.CoinResponse
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import javax.inject.Inject

class FetchCoinListingUseCase @Inject constructor(
    private val repository: CoinRepository,
    private val mapper: CoinListingMapper
) {

    fun fetchCoinListing(): Flow<Resource<List<Coin>>> = flow {
        try {
            emit(Resource.Loading())
            val result = repository.fetchCoinListing().map { response ->
                mapper.from(response)
            }
            emit(Resource.Success(result))
        } catch (ex: HttpException) {
            emit(value = Resource.Error<List<Coin>>(ex))
        }
    }
}

class CoinListingMapper @Inject constructor() {

    fun from(response: CoinResponse): Coin {
        return Coin(
            id = response.id,
            name = response.name,
            symbol = response.symbol,
            isActive = response.isActive,
            isNew = response.isNew,
            type = response.type,
            rank = response.rank
        )
    }
}

data class Coin(
    val id: String,
    val name: String,
    val symbol: String,
    val rank: Int,
    val isNew: Boolean,
    val isActive: Boolean,
    val type: String
) {}