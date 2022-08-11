package com.kineduchallenge.core.repository

import com.kineduchallenge.core.api.data.Character
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class Repository @Inject constructor(
    private val mLocalDataSource: LocalDataSource,
    private val mRemoteDataSource: RemoteDataSource
) : DataSource {

    override suspend fun getListCharacters(forceUpdate: Boolean): List<Character> {
        return if (forceUpdate) {
            mRemoteDataSource.getListCharacters(forceUpdate)
        } else {
            mLocalDataSource.getListCharacters(forceUpdate)
        }
    }

}