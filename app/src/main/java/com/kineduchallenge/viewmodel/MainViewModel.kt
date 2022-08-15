package com.kineduchallenge.viewmodel

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.kineduchallenge.core.repository.Repository
import com.kineduchallenge.ui.events.UIEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val mRepository: Repository,
) : BaseViewModel(Application()) {



}