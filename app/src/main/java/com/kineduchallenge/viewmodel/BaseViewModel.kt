package com.kineduchallenge.viewmodel

import android.app.Application
import android.content.Context
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.kineduchallenge.ui.events.NavigationEvents
import com.kineduchallenge.ui.events.UIEvent
import dagger.hilt.android.qualifiers.ActivityContext
import dagger.hilt.android.qualifiers.ApplicationContext

open class BaseViewModel(application: Application) : AndroidViewModel(application) {

    private val mNavigationEvent = MutableLiveData<Event<NavigationEvents>>()
    val mNavigationEventListener: LiveData<Event<NavigationEvents>> get() = mNavigationEvent

    // List of events to post
    private val mUIEvent = MutableLiveData<Event<UIEvent>>()
    private val mUIEventsToPost = mutableListOf<Event<UIEvent>>()
    val mUIEventListener: LiveData<Event<UIEvent>> get() = mUIEvent

    fun postUIEvent(event: UIEvent? = null) {
        // Save the event in a list
        event?.let { mUIEventsToPost.add(Event(it)) }
        // Check if there's an event to be posted
        if (mUIEventsToPost.isEmpty()) return
        when {
            // If it has already handled remove from the list
            mUIEventsToPost.first().mHasBeenHandled -> {
                mUIEventsToPost.removeFirst()
                postUIEvent()
            }
            // Post the event
            else -> mUIEvent.postValue(mUIEventsToPost.first())
        }
    }

    fun postNavigationEvent(event: NavigationEvents) {
        mNavigationEvent.postValue(Event(event))
    }

}