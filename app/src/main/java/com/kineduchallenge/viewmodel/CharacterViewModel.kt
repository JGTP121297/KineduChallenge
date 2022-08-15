package com.kineduchallenge.viewmodel

import android.app.Application
import androidx.lifecycle.viewModelScope
import com.kineduchallenge.core.database.schema.Comic
import com.kineduchallenge.core.database.schema.ItemList
import com.kineduchallenge.core.repository.Repository
import com.kineduchallenge.ui.events.ShowCharacter
import com.kineduchallenge.ui.events.ShowListComics
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CharacterViewModel @Inject constructor(private val mRepository: Repository) :
    BaseViewModel(Application()) {

    fun consultCharacter(id: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val character = mRepository.getCharacter(id, true)
                postUIEvent(ShowCharacter(character))
                character?.comics?.let { consultComics(it) }
            } catch (e: Exception) {
                println(e)
            }

        }
    }

    private fun consultComics(comics: ItemList) {
        viewModelScope.launch {
            try {
                val listComics: MutableList<Comic> = mutableListOf()
                comics.itemList?.forEach { comic ->
                    val comicId = comic?.id ?: 0
                    val comic = mRepository.getComic(comicId, true)
                    listComics.add(comic)
                }
                postUIEvent(ShowListComics(listComics))
            } catch (e: Exception) {
                println(e)
            }
        }
    }
}