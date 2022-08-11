package com.kineduchallenge.core.repository

import com.kineduchallenge.core.api.data.Character

interface DataSource {

    /**
     * Get the list of characters
     *
     * @return List of characters
     */
    suspend fun getListCharacters(forceUpdate: Boolean): List<Character>

}