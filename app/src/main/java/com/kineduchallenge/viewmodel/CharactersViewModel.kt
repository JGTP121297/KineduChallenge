package com.kineduchallenge.viewmodel

import android.app.Activity
import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kineduchallenge.core.repository.Repository
import com.kineduchallenge.ui.MainActivity
import com.kineduchallenge.ui.events.ShowListCharacters
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CharactersViewModel @Inject constructor(
    private val mRepository: Repository
) : BaseViewModel(Application()) {

    fun consultCharacters() {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val characters = mRepository.getListCharacters(true)
                postUIEvent(ShowListCharacters(characters))
            } catch (e: Exception) {
                println(e)
            }
        }
    }

}