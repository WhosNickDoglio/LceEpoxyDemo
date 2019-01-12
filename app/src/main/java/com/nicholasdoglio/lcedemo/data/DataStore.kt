/*
 * MIT License
 *
 * Copyright (c) 2019 Nicholas Doglio
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

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

