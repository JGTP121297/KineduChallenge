package com.kineduchallenge.core.module

import com.kineduchallenge.core.database.dao.BaseDao
import com.kineduchallenge.core.database.dao.CharacterDao
import com.kineduchallenge.core.database.schema.Character
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class DataBaseModule {
    @Binds
    abstract fun provideCharacterDao(dao: CharacterDao): BaseDao<Character>
}