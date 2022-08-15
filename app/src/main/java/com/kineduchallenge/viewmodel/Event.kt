package com.kineduchallenge.viewmodel

open class Event<out T>(private val content: T) {
    var mHasBeenHandled = false
        private set // Allow external read but not write

    // Return the content and prevents it's used again
    fun getContentIfNotHandled(handleOnReceive: Boolean = false): T? {
        return if (mHasBeenHandled) {
            null
        } else {
            // Set that it has been handled once received
            if (handleOnReceive) mHasBeenHandled = true
            content
        }
    }

    fun setContentHandled() {
        mHasBeenHandled = true
    }

    // Returns the content, even if had already been handled
    fun peekContent(): T = content
}