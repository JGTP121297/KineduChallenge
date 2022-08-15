package com.kineduchallenge.ui.fragments.comic

import androidx.recyclerview.widget.RecyclerView
import com.airbnb.epoxy.EpoxyController
import com.kineduchallenge.core.database.schema.Comic

class ComicEpoxyController : EpoxyController() {

    private var mListener: Listener? = null
    private var mListComics: List<Comic> = emptyList()


    override fun buildModels() {
        
    }

    fun setListener(listener: Listener) {
        this.mListener = listener
    }

    override fun onDetachedFromRecyclerView(recyclerView: RecyclerView) {
        super.onDetachedFromRecyclerView(recyclerView)
        mListener = null
    }

    interface Listener {
        fun itemClicked()
    }
}