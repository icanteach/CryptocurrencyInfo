package co.icanteach.apps.cryptocurrencyInfo

sealed class Resource<T> {

    data class Success<T>(val data: T) : Resource<T>()

    data class Error<T>(val exception: Throwable) : Resource<T>()

    data class Loading<T>(val data: T? = null) : Resource<T>()

}