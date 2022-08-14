package com.kineduchallenge.core.repository

import com.kineduchallenge.core.api.ApiInterface
import com.kineduchallenge.core.database.schema.*
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

    override suspend fun getCharacter(id: Int, forceUpdate: Boolean): Character {
        return withContext(Dispatchers.IO) {
            val response = mApi.getCharacters(characterId = id)
            response.body()?.data?.results ?: Character()
        }
    }

    override suspend fun getListComics(forceUpdate: Boolean): List<Comic> {
        return withContext(Dispatchers.IO) {
            val response = mApi.getAllComics()
            response.body()?.data?.results ?: emptyList()
        }
    }

    override suspend fun getComic(id: Int, forceUpdate: Boolean): Comic {
        return withContext(Dispatchers.IO) {
            val response = mApi.getComic(comicId = id)
            response.body()?.data?.results ?: Comic()
        }
    }

    override suspend fun getListEvents(forceUpdate: Boolean): List<Event> {
        return withContext(Dispatchers.IO) {
            val response = mApi.getAllEvents()
            response.body()?.data?.results ?: emptyList()
        }
    }

    override suspend fun getEvent(id: Int, forceUpdate: Boolean): Event {
        return withContext(Dispatchers.IO) {
            val response = mApi.getEvent(eventsId = id)
            response.body()?.data?.results ?: Event()
        }
    }

    override suspend fun getListSeries(forceUpdate: Boolean): List<Series> {
        return withContext(Dispatchers.IO) {
            val response = mApi.getAllSeries()
            response.body()?.data?.results ?: emptyList()
        }
    }

    override suspend fun getSeries(id: Int, forceUpdate: Boolean): Series {
        return withContext(Dispatchers.IO) {
            val response = mApi.getSeries(seriesId = id)
            response.body()?.data?.results ?: Series()
        }
    }

    override suspend fun getListStories(forceUpdate: Boolean): List<Story> {
        return withContext(Dispatchers.IO) {
            val response = mApi.getAllStories()
            response.body()?.data?.results ?: emptyList()
        }
    }

    override suspend fun getStory(id: Int, forceUpdate: Boolean): Story {
        return withContext(Dispatchers.IO) {
            val response = mApi.getStory(storyId = id)
            response.body()?.data?.results ?: Story()
        }
    }

    override suspend fun addCharacter(character: Character) {
        throw UnsupportedOperationException("Unsupported operation")
    }

    override suspend fun addComic(comic: Comic) {
        throw UnsupportedOperationException("Unsupported operation")
    }

    override suspend fun addEvent(event: Event) {
        throw UnsupportedOperationException("Unsupported operation")
    }

    override suspend fun addSeries(series: Series) {
        throw UnsupportedOperationException("Unsupported operation")
    }

    override suspend fun addStory(story: Story) {
        throw UnsupportedOperationException("Unsupported operation")
    }
}