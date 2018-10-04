package com.nicholasdoglio.lcedemo.ui.epoxy

import android.view.View
import android.widget.Button
import com.airbnb.epoxy.EpoxyAttribute
import com.airbnb.epoxy.EpoxyHolder
import com.airbnb.epoxy.EpoxyModelClass
import com.airbnb.epoxy.EpoxyModelWithHolder
import com.nicholasdoglio.lcedemo.R
import kotlinx.android.synthetic.main.item_error.view.*

@EpoxyModelClass(layout = R.layout.item_error)
abstract class ItemError() : EpoxyModelWithHolder<ItemError.ErrorHolder>() {
    @EpoxyAttribute lateinit var onClickListener: () -> Unit

    override fun bind(holder: ErrorHolder) {
        super.bind(holder)
        holder.retryButton.setOnClickListener { onClickListener() }
    }

    class ErrorHolder() : EpoxyHolder() {

        lateinit var retryButton: Button

        override fun bindView(itemView: View) {
            retryButton = itemView.retryButton
        }
    }
}