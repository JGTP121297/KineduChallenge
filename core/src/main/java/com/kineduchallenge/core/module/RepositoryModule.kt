package com.kineduchallenge.core.module

import com.kineduchallenge.core.repository.DataSource
import com.kineduchallenge.core.repository.LocalDataSource
import com.kineduchallenge.core.repository.RemoteDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {
    @Provides
    fun provideLocalDataSource(localDataSource: LocalDataSource): DataSource = localDataSource

    @Provides
    fun provideRemoteDataSource(remoteDataSource: RemoteDataSource): DataSource = remoteDataSource
}