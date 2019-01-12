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

package com.nicholasdoglio.lcedemo.ui

import com.airbnb.epoxy.TypedEpoxyController
import com.nicholasdoglio.lcedemo.data.RequestState
import com.nicholasdoglio.lcedemo.ui.epoxy.itemEmpty
import com.nicholasdoglio.lcedemo.ui.epoxy.itemError
import com.nicholasdoglio.lcedemo.ui.epoxy.itemListItem
import com.nicholasdoglio.lcedemo.ui.epoxy.itemLoading


/**
 * @author Nicholas Doglio
 */
class ListController(private val retry: () -> Unit) :
    TypedEpoxyController<RequestState<List<String>>>() {
    //TODO explore other Epoxy features

    override fun buildModels(state: RequestState<List<String>>) = when (state) {
        is RequestState.Loading -> renderLoading()
        is RequestState.Success -> renderSuccess(state.data)
        is RequestState.Error -> renderError()
    }

    private fun renderError() {
        itemError {
            id(ERROR_ID)
            onClickListener { retry() }
        }
    }

    private fun renderSuccess(data: List<String>) {
        if (data.isEmpty()) {
            itemEmpty {
                id(EMPTY_ID)
            }
        } else {

            data.forEach {
                itemListItem {
                    id(it)
                    data(it)
                }
            }
        }
    }

    private fun renderLoading() {
        itemLoading {
            id(LOADING_ID)
        }
    }

    companion object {
        private const val ERROR_ID = "Error"
        private const val EMPTY_ID = "Empty"
        private const val LOADING_ID = "Loading"
    }
}