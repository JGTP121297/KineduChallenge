package com.kineduchallenge.core.repository

import com.kineduchallenge.core.api.ApiInterface
import com.kineduchallenge.core.api.data.Character
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class RemoteDataSource @Inject constructor(private val mApi: ApiInterface) : DataSource {
    override suspend fun getListCharacters(forceUpdate: Boolean): List<Character> {
        return withContext(Dispatchers.IO) {
            val response = mApi.getAllCharacters()
            response.body()?.data?.results ?: emptyList()
        }
    }
}