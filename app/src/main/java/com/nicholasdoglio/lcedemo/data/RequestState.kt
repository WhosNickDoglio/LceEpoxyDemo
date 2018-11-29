package com.nicholasdoglio.lcedemo.data

/**
 * @author Nicholas Doglio
 */
sealed class RequestState<out T : Any> {
    object Loading : RequestState<Nothing>()
    class Success<out T : Any>(val data: T) : RequestState<T>()
    object Error : RequestState<Nothing>()
}