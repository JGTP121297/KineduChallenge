package com.kineduchallenge.ui.epoxyModels

import android.view.View
import android.widget.TextView
import com.airbnb.epoxy.*
import com.kineduchallenge.R
import com.kineduchallenge.core.database.schema.Comic
import com.kineduchallenge.core.database.schema.ItemList

@EpoxyModelClass(layout = R.layout.item_epoxy_item_list)
abstract class ItemListEpoxyModel : EpoxyModelWithHolder<ItemListEpoxyModel.Holder>() {

    @EpoxyAttribute
    var title: String? = null

    @EpoxyAttribute
    var listItem: List<Comic>? = null

    @EpoxyAttribute
    var epoxyListener: ItemEpoxyModel.Listener? = null

    override fun bind(holder: Holder) {
        super.bind(holder)
        holder.title.text = title
        holder.itemList.withModels {
            listItem?.forEach { comic ->
                item {
                    id(comic.id)
                    comic(comic)
                    listener(epoxyListener)
                }
            }
        }
    }

    inner class Holder : EpoxyHolder() {
        lateinit var title: TextView
        lateinit var itemList: EpoxyRecyclerView

        override fun bindView(itemView: View) {
            title = itemView.findViewById(R.id.text_title)
            itemList = itemView.findViewById(R.id.recycler_view)
        }
    }

}