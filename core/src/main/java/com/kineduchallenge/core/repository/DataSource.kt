package com.kineduchallenge.core.repository

import com.kineduchallenge.core.database.schema.*

interface DataSource {

    /**
     * GETS
     */

    /**
     * Get the list of characters
     *
     * @return List of characters
     */
    suspend fun getListCharacters(forceUpdate: Boolean): List<Character>

    /**
     * Get a specific character
     * @param id ID of the character
     * @param forceUpdate Force the update or get from local
     * @return Character
     */
    suspend fun getCharacter(id: Int, forceUpdate: Boolean): Character

    /**
     * Get the list of comics
     *
     * @return List of comics
     */
    suspend fun getListComics(forceUpdate: Boolean): List<Comic>

    /**
     * Get a specific series
     * @param id ID of the comic
     * @param forceUpdate Force the update or get from local
     * @return Comic
     */
    suspend fun getComic(id: Int, forceUpdate: Boolean): Comic

    /**
     * Get the list of events
     *
     * @return List of events
     */
    suspend fun getListEvents(forceUpdate: Boolean): List<Event>

    /**
     * Get a specific event
     * @param id ID of the event
     * @param forceUpdate Force the update or get from local
     * @return Event
     */
    suspend fun getEvent(id: Int, forceUpdate: Boolean): Event

    /**
     * Get the list of series
     *
     * @return List of series
     */
    suspend fun getListSeries(forceUpdate: Boolean): List<Series>

    /**
     * Get a specific series
     * @param id ID of the series
     * @param forceUpdate Force the update or get from local
     * @return Series
     */
    suspend fun getSeries(id: Int, forceUpdate: Boolean): Series

    /**
     * Get the list of stories
     *
     * @return List of stories
     */
    suspend fun getListStories(forceUpdate: Boolean): List<Story>

    /**
     * Get a specific series
     * @param id ID of the story
     * @param forceUpdate Force the update or get from local
     * @return Story
     */
    suspend fun getStory(id: Int, forceUpdate: Boolean): Story

    /**
     * ADDS
     */

    /**
     * Add a character to the database
     */
    suspend fun addCharacter(character: Character)

    /**
     * Add a comic to the database
     */
    suspend fun addComic(comic: Comic)

    /**
     * Add a event to the database
     */
    suspend fun addEvent(event: Event)

    /**
     * Add a series to the database
     */
    suspend fun addSeries(series: Series)

    /**
     * Add a story to the database
     */
    suspend fun addStory(story: Story)

}