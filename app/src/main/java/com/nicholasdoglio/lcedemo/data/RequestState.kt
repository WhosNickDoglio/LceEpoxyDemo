package com.nicholasdoglio.lcedemo.data

sealed class RequestState<out T : Any> {
    object Loading : RequestState<Nothing>()
    class Success<out T : Any>(val data: T) : RequestState<T>()
    object Error : RequestState<Nothing>()
    object Empty : RequestState<Nothing>()
}