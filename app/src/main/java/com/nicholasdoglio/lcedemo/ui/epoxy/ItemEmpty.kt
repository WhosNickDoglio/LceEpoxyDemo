package com.nicholasdoglio.lcedemo.ui.epoxy

import android.view.View
import com.airbnb.epoxy.EpoxyHolder
import com.airbnb.epoxy.EpoxyModelClass
import com.airbnb.epoxy.EpoxyModelWithHolder
import com.nicholasdoglio.lcedemo.R

@EpoxyModelClass(layout = R.layout.item_empty)
abstract class ItemEmpty : EpoxyModelWithHolder<ItemEmpty.EmptyHolder>() {

    class EmptyHolder() : EpoxyHolder() {
        override fun bindView(itemView: View) {}
    }
}
