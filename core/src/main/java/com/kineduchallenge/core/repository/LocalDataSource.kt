package com.kineduchallenge.core.repository

import com.kineduchallenge.core.api.data.Character
import javax.inject.Inject

class LocalDataSource @Inject constructor(): DataSource{

    override suspend fun getListCharacters(forceUpdate: Boolean): List<Character> {
        return emptyList()
    }

}