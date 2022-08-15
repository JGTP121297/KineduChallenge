package com.kineduchallenge.ui.fragments.character

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import coil.load
import com.airbnb.epoxy.EpoxyAttribute
import com.airbnb.epoxy.EpoxyHolder
import com.airbnb.epoxy.EpoxyModelClass
import com.airbnb.epoxy.EpoxyModelWithHolder
import com.kineduchallenge.R
import com.kineduchallenge.core.database.schema.Character

@EpoxyModelClass(layout = R.layout.item_epoxy_character_item)
abstract class CharacterEpoxyModel : EpoxyModelWithHolder<Holder>() {

    @EpoxyAttribute
    var character: Character? = null

    @EpoxyAttribute
    var epoxyListener: Listener? = null

    override fun bind(holder: Holder) {
        super.bind(holder)
        holder.layout.setOnClickListener { epoxyListener?.onCharacterClick(character?.id ?: 0) }
        character?.thumbnail?.let { thumbnail ->
            val url = "${thumbnail.path}.${thumbnail.extension}".replace("http", "https")
            holder.image.load(url)
        }
        holder.name.text = character?.name ?: ""
        holder.description.text = character?.description ?: ""
    }

    interface Listener {
        fun onCharacterClick(id: Int)
    }
}

class Holder : EpoxyHolder() {
    lateinit var layout: ConstraintLayout
    lateinit var image: ImageView
    lateinit var name: TextView
    lateinit var description: TextView

    override fun bindView(itemView: View) {
        layout = itemView.findViewById(R.id.layout)
        image = itemView.findViewById(R.id.image)
        name = itemView.findViewById(R.id.text_name)
        description = itemView.findViewById(R.id.text_description)
    }
}