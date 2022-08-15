package com.kineduchallenge.core.api

import com.kineduchallenge.core.api.ApiConstants.API_HASH
import com.kineduchallenge.core.api.ApiConstants.API_PUBLIC_KEY
import com.kineduchallenge.core.api.ApiConstants.API_TS
import com.kineduchallenge.core.database.schema.*
import io.realm.RealmList
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiInterface {

    @GET("characters")
    suspend fun getAllCharacters(
        @Query("apikey") apiKey: String = API_PUBLIC_KEY,
        @Query("ts") ts: Int = API_TS,
        @Query("hash") hash: String = API_HASH,
        @Query("limit") limit: Int = 10
    ): Response<ApiResponse<RealmList<Character>>>

    @GET("characters/{characterId}")
    suspend fun getCharacter(
        @Path("characterId") characterId: Int,
        @Query("apikey") apiKey: String = API_PUBLIC_KEY,
        @Query("ts") ts: Int = API_TS,
        @Query("hash") hash: String = API_HASH
    ): Response<ApiResponse<RealmList<Character>>>

    @GET("comics")
    suspend fun getAllComics(
        @Query("apikey") apiKey: String = API_PUBLIC_KEY,
        @Query("ts") ts: Int = API_TS,
        @Query("hash") hash: String = API_HASH,
        @Query("limit") limit: Int = 10
    ): Response<ApiResponse<RealmList<Comic>>>

    @GET("comics/{comicId}")
    suspend fun getComic(
        @Path("comicId") comicId: Int,
        @Query("apikey") apiKey: String = API_PUBLIC_KEY,
        @Query("ts") ts: Int = API_TS,
        @Query("hash") hash: String = API_HASH
    ): Response<ApiResponse<RealmList<Comic>>>

    @GET("events")
    suspend fun getAllEvents(
        @Query("apikey") apiKey: String = API_PUBLIC_KEY,
        @Query("ts") ts: Int = API_TS,
        @Query("hash") hash: String = API_HASH,
        @Query("limit") limit: Int = 10
    ): Response<ApiResponse<RealmList<Event>>>

    @GET("events/{eventsId}")
    suspend fun getEvent(
        @Query("apikey") apiKey: String = API_PUBLIC_KEY,
        @Query("ts") ts: Int = API_TS,
        @Query("hash") hash: String = API_HASH,
        @Query("eventsId") eventsId: Int
    ): Response<ApiResponse<RealmList<Event>>>

    @GET("series")
    suspend fun getAllSeries(
        @Query("apikey") apiKey: String = API_PUBLIC_KEY,
        @Query("ts") ts: Int = API_TS,
        @Query("hash") hash: String = API_HASH,
        @Query("limit") limit: Int = 10
    ): Response<ApiResponse<RealmList<Series>>>

    @GET("series/{seriesId}")
    suspend fun getSeries(
        @Query("apikey") apiKey: String = API_PUBLIC_KEY,
        @Query("ts") ts: Int = API_TS,
        @Query("hash") hash: String = API_HASH,
        @Query("seriesId") seriesId: Int
    ): Response<ApiResponse<RealmList<Series>>>

    @GET("stories")
    suspend fun getAllStories(
        @Query("apikey") apiKey: String = API_PUBLIC_KEY,
        @Query("ts") ts: Int = API_TS,
        @Query("hash") hash: String = API_HASH,
        @Query("limit") limit: Int = 10
    ): Response<ApiResponse<RealmList<Story>>>

    @GET("stories/{storyId}")
    suspend fun getStory(
        @Query("apikey") apiKey: String = API_PUBLIC_KEY,
        @Query("ts") ts: Int = API_TS,
        @Query("hash") hash: String = API_HASH,
        @Query("storyId") storyId: Int
    ): Response<ApiResponse<RealmList<Story>>>

}