package com.kineduchallenge.core.repository

import com.kineduchallenge.core.database.dao.*
import com.kineduchallenge.core.database.schema.*
import javax.inject.Inject

class LocalDataSource @Inject constructor(
    private val mCharacterDao: CharacterDao,
    private val mComicDao: ComicDao,
    private val mEventDao: EventDao,
    private val mSeriesDao: SeriesDao,
    private val mStoryDao: StoryDao
) : DataSource {

    override suspend fun getListCharacters(forceUpdate: Boolean): List<Character> =
        mCharacterDao.getAll()

    override suspend fun getCharacter(id: Int, forceUpdate: Boolean): Character =
        mCharacterDao.get(id)

    override suspend fun getListComics(forceUpdate: Boolean): List<Comic> = mComicDao.getAll()

    override suspend fun getComic(id: Int, forceUpdate: Boolean): Comic = mComicDao.get(id)

    override suspend fun getListEvents(forceUpdate: Boolean): List<Event> = mEventDao.getAll()

    override suspend fun getEvent(id: Int, forceUpdate: Boolean): Event = mEventDao.get(id)

    override suspend fun getListSeries(forceUpdate: Boolean): List<Series> = mSeriesDao.getAll()

    override suspend fun getSeries(id: Int, forceUpdate: Boolean): Series = mSeriesDao.get(id)

    override suspend fun getListStories(forceUpdate: Boolean): List<Story> = mStoryDao.getAll()

    override suspend fun getStory(id: Int, forceUpdate: Boolean): Story = mStoryDao.get(id)

    override suspend fun addCharacter(character: Character) {
        mCharacterDao.add(character)
    }

    override suspend fun addComic(comic: Comic) {
        mComicDao.add(comic)
    }

    override suspend fun addEvent(event: Event) {
        mEventDao.add(event)
    }

    override suspend fun addSeries(series: Series) {
        mSeriesDao.add(series)
    }

    override suspend fun addStory(story: Story) {
        mStoryDao.add(story)
    }

}