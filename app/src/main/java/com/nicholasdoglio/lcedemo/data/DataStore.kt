package com.nicholasdoglio.lcedemo.data

import io.reactivex.Observable
import java.util.concurrent.TimeUnit

/**
 * @author Nicholas Doglio
 */
object DataStore {

    val data: MutableList<String> = mutableListOf()

    fun getData(): Observable<RequestState<List<String>>> = Observable.just(data)
        //Delay to show progress bar
        .delay(20000, TimeUnit.MILLISECONDS)
        //Error thrown 25% of time to show error state
        .map { throwErrorRandomly(it) }
        //Returns Success state with a list of data
        .map<RequestState<List<String>>> { RequestState.Success(it) }
        //Begins with loading state
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

    private fun throwErrorRandomly(list: List<String>): List<String> =
        if ((Math.random() * 100) < 25) throw IllegalStateException("Show me the error state!") else list
}

