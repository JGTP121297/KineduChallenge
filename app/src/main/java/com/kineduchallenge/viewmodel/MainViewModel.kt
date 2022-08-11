package com.kineduchallenge.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kineduchallenge.core.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val mRepository: Repository) : ViewModel() {

    fun consultRepository() {
        viewModelScope.launch(Dispatchers.IO) {
            val characters = mRepository.getListCharacters(true)
            println(characters)
        }
        //
    }

}