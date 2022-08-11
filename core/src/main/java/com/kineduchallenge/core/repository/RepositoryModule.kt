package com.kineduchallenge.core.repository

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