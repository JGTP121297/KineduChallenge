package com.kineduchallenge.ui.epoxyModels

import android.content.Context
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import coil.load
import com.airbnb.epoxy.*
import com.kineduchallenge.R
import com.kineduchallenge.core.database.schema.Comic
import com.kineduchallenge.core.database.schema.Item
import com.kineduchallenge.core.database.schema.ItemList
import com.kineduchallenge.core.repository.Repository
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import javax.inject.Inject

@EpoxyModelClass(layout = R.layout.item_epoxy_item_individual)
abstract class ItemEpoxyModel : EpoxyModelWithHolder<ItemEpoxyModel.Holder>() {

    @EpoxyAttribute
    var comic: Comic? = null

    @EpoxyAttribute
    var listener: Listener? = null

    override fun bind(holder: Holder) {
        super.bind(holder)
        holder.title.text = comic?.title
        holder.image.load(comic?.thumbnail?.url)
        holder.layout.setOnClickListener {
            listener?.onItemClicked(comic?.id ?: 0)
        }
    }

    interface Listener {
        fun onItemClicked(id: Int)
    }

    inner class Holder : EpoxyHolder() {
        lateinit var layout: ConstraintLayout
        lateinit var image: ImageView
        lateinit var title: TextView

        override fun bindView(itemView: View) {
            layout = itemView.findViewById(R.id.layout)
            image = itemView.findViewById(R.id.image)
            title = itemView.findViewById(R.id.text_title)
        }
    }

}