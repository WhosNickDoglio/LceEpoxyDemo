package com.nicholasdoglio.lcedemo.ui.epoxy

import android.view.View
import android.widget.TextView
import com.airbnb.epoxy.EpoxyAttribute
import com.airbnb.epoxy.EpoxyHolder
import com.airbnb.epoxy.EpoxyModelClass
import com.airbnb.epoxy.EpoxyModelWithHolder
import com.nicholasdoglio.lcedemo.R
import kotlinx.android.synthetic.main.item_list.view.*

@EpoxyModelClass(layout = R.layout.item_list)
abstract class ItemListItem : EpoxyModelWithHolder<ItemListItem.ListItemHolder>() {
    @EpoxyAttribute lateinit var data: String

    override fun bind(holder: ListItemHolder) {
        super.bind(holder)
        holder.textView.text = data
    }

    class ListItemHolder : EpoxyHolder() {

        lateinit var textView: TextView

        override fun bindView(itemView: View) {
            textView = itemView.itemText
        }
    }
}