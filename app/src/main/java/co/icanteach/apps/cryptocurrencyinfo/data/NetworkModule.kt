package co.icanteach.apps.cryptocurrencyinfo.data

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    private const val BASE_URL = "https://api.coinpaprika.com/v1/"

    @Singleton
    @Provides
    fun provideMoshiConverterFactory(): MoshiConverterFactory =
        MoshiConverterFactory.create()

    @Provides
    @Singleton
    fun provideCoinApi(
        moshiConverterFactory: MoshiConverterFactory
    ): CoinApi {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(moshiConverterFactory)
            .build()
            .create(CoinApi::class.java)
    }

    @Provides
    @Singleton
    fun provideCoinRepository(api: CoinApi): CoinRepository {
        return CoinRepositoryImpl(api)
    }
}