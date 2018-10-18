package com.nicholasdoglio.lcedemo.ui

import com.airbnb.epoxy.TypedEpoxyController
import com.nicholasdoglio.lcedemo.data.RequestState
import com.nicholasdoglio.lcedemo.ui.epoxy.itemEmpty
import com.nicholasdoglio.lcedemo.ui.epoxy.itemError
import com.nicholasdoglio.lcedemo.ui.epoxy.itemListItem
import com.nicholasdoglio.lcedemo.ui.epoxy.itemLoading

//TODO explore other Epoxy features
class ListController(private val retry: () -> Unit) :
    TypedEpoxyController<RequestState<List<String>>>() {

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