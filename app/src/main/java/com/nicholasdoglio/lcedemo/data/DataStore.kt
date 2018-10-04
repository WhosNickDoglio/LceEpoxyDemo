package com.nicholasdoglio.lcedemo.data

import io.reactivex.Observable
import java.util.concurrent.TimeUnit

object DataStore {
    val data: MutableList<String> = mutableListOf()

    fun getData(): Observable<RequestState<List<String>>> = Observable.just(data)
        //Delay to show progress bar
        .delay(20000, TimeUnit.MILLISECONDS)
        //Error thrown 25% of time to show error state
        .map { throwErrorRandomly(it) }
        //Returns empty or success case depending in list is empty or not
        .map<RequestState<List<String>>> { returnCorrectState(it) }
        //Begins loading
        .startWith(RequestState.Loading)
        //Shows error state on any error
        .onErrorReturn { RequestState.Error }

    fun populateListIfEmpty() {
        if (data.isEmpty()) {
            for (i in 1..100) {
                data.add("$i Test Data")
            }
        }
    }

    private fun returnCorrectState(list: List<String>): RequestState<List<String>> =
        if (list.isEmpty()) RequestState.Empty else RequestState.Success(list)

    private fun throwErrorRandomly(list: List<String>): List<String> {
        if ((Math.random() * 100) < 25) throw Throwable("Show me the error state!")

        return list
    }
}

