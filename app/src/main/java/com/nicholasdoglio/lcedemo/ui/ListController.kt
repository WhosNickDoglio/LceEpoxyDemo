package com.nicholasdoglio.lcedemo.ui

import com.airbnb.epoxy.TypedEpoxyController
import com.nicholasdoglio.lcedemo.data.RequestState
import com.nicholasdoglio.lcedemo.ui.epoxy.model.itemEmpty
import com.nicholasdoglio.lcedemo.ui.epoxy.model.itemError
import com.nicholasdoglio.lcedemo.ui.epoxy.model.itemListItem
import com.nicholasdoglio.lcedemo.ui.epoxy.model.itemLoading

//TODO explore other Epoxy features
class ListController(private val retry: () -> Unit) :
    TypedEpoxyController<RequestState<List<String>>>() {

    override fun buildModels(state: RequestState<List<String>>) = when (state) {
        is RequestState.Loading -> {
            itemLoading {
                id("Loading")
            }
        }
        is RequestState.Success -> {
            for (item in state.data) {
                itemListItem {
                    id(item)
                    data(item)
                }
            }
        }
        is RequestState.Empty -> {
            itemEmpty {
                id("Empty")
            }
        }
        is RequestState.Error -> {
            itemError {
                id("Error")
                onClickListener { retry() }
            }
        }
    }
}