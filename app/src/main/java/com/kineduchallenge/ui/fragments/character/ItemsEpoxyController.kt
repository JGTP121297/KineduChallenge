package com.kineduchallenge.ui.fragments.character

import androidx.recyclerview.widget.RecyclerView
import com.airbnb.epoxy.EpoxyController
import com.kineduchallenge.core.database.schema.Comic
import com.kineduchallenge.core.database.schema.ItemList
import com.kineduchallenge.ui.epoxyModels.ItemEpoxyModel
import com.kineduchallenge.ui.epoxyModels.ItemListEpoxyModel_

class ItemsEpoxyController : EpoxyController() {

    private var mItemListener: ItemEpoxyModel.Listener? = null
    private var mListComics: List<Comic>? = null
    private var mListener: Listener? = null

    override fun buildModels() {
        if (mListComics?.isNotEmpty() == true) {
            ItemListEpoxyModel_()
                .id("1")
                .title("Comics")
                .listItem(mListComics)
                .epoxyListener(object : ItemEpoxyModel.Listener {
                    override fun onItemClicked(id: Int) {
                        mListener?.comicClicked(id)
                    }
                })
                .addTo(this)
        }
    }

    fun setListener(listener: Listener) {
        this.mListener = listener
    }

    fun setData(comicItemList: List<Comic>) {
        this.mListComics = comicItemList
        requestModelBuild()
    }

    override fun onDetachedFromRecyclerView(recyclerView: RecyclerView) {
        super.onDetachedFromRecyclerView(recyclerView)
        mListener = null
    }

    interface Listener {
        fun comicClicked(id: Int)
    }
}