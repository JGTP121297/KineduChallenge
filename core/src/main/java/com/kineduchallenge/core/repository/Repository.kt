package com.kineduchallenge.core.repository

import com.kineduchallenge.core.database.schema.*
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class Repository @Inject constructor(
    private val mLocalDataSource: LocalDataSource,
    private val mRemoteDataSource: RemoteDataSource
) : DataSource {
    override suspend fun getListCharacters(forceUpdate: Boolean): List<Character> {
        return if (forceUpdate) {
            mRemoteDataSource.getListCharacters(forceUpdate).forEach { addCharacter(it) }
            getListCharacters(forceUpdate = false)
        } else {
            mLocalDataSource.getListCharacters(forceUpdate)
        }
    }

    override suspend fun getCharacter(id: Int, forceUpdate: Boolean): Character {
        return if (forceUpdate) {
            val character = mRemoteDataSource.getCharacter(id, forceUpdate)
            addCharacter(character)
            getCharacter(id, forceUpdate = false)
        } else {
            mLocalDataSource.getCharacter(id, forceUpdate)
        }
    }

    override suspend fun getListComics(forceUpdate: Boolean): List<Comic> {
        return if (forceUpdate) {
            mRemoteDataSource.getListComics(forceUpdate).forEach { addComic(it) }
            getListComics(forceUpdate = false)
        } else {
            mLocalDataSource.getListComics(forceUpdate)
        }
    }

    override suspend fun getComic(id: Int, forceUpdate: Boolean): Comic {
        return if (forceUpdate) {
            val comic = mRemoteDataSource.getComic(id, forceUpdate)
            addComic(comic)
            getComic(id, forceUpdate = false)
        } else {
            mLocalDataSource.getComic(id, forceUpdate)
        }
    }

    override suspend fun getListEvents(forceUpdate: Boolean): List<Event> {
        return if (forceUpdate) {
            mRemoteDataSource.getListEvents(forceUpdate).forEach { addEvent(it) }
            getListEvents(forceUpdate = false)
        } else {
            mLocalDataSource.getListEvents(forceUpdate)
        }
    }

    override suspend fun getEvent(id: Int, forceUpdate: Boolean): Event {
        return if (forceUpdate) {
            val event = mRemoteDataSource.getEvent(id, forceUpdate)
            addEvent(event)
            getEvent(id, forceUpdate = false)
        } else {
            mLocalDataSource.getEvent(id, forceUpdate)
        }
    }

    override suspend fun getListSeries(forceUpdate: Boolean): List<Series> {
        return if (forceUpdate) {
            mRemoteDataSource.getListSeries(forceUpdate).forEach { addSeries(it) }
            getListSeries(forceUpdate = false)
        } else {
            mLocalDataSource.getListSeries(forceUpdate)
        }
    }

    override suspend fun getSeries(id: Int, forceUpdate: Boolean): Series {
        return if (forceUpdate) {
            val character = mRemoteDataSource.getSeries(id, forceUpdate)
            addSeries(character)
            getSeries(id, forceUpdate = false)
        } else {
            mLocalDataSource.getSeries(id, forceUpdate)
        }
    }

    override suspend fun getListStories(forceUpdate: Boolean): List<Story> {
        return if (forceUpdate) {
            mRemoteDataSource.getListStories(forceUpdate).forEach { addStory(it) }
            getListStories(forceUpdate = false)
        } else {
            mLocalDataSource.getListStories(forceUpdate)
        }
    }

    override suspend fun getStory(id: Int, forceUpdate: Boolean): Story {
        return if (forceUpdate) {
            val story = mRemoteDataSource.getStory(id, forceUpdate)
            addStory(story)
            getStory(id, forceUpdate = false)
        } else {
            mLocalDataSource.getStory(id, forceUpdate)
        }
    }

    override suspend fun addCharacter(character: Character) {
        mLocalDataSource.addCharacter(character)
    }

    override suspend fun addComic(comic: Comic) {
        mLocalDataSource.addComic(comic)
    }

    override suspend fun addEvent(event: Event) {
        mLocalDataSource.addEvent(event)
    }

    override suspend fun addSeries(series: Series) {
        mLocalDataSource.addSeries(series)
    }

    override suspend fun addStory(story: Story) {
        mLocalDataSource.addStory(story)
    }

}