package com.kineduchallenge.core.api

import com.kineduchallenge.core.api.ApiConstants.API_HASH
import com.kineduchallenge.core.api.ApiConstants.API_PUBLIC_KEY
import com.kineduchallenge.core.api.ApiConstants.API_TS
import com.kineduchallenge.core.api.data.Character
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface ApiInterface {


    @GET("characters")
    suspend fun getAllCharacters(
        @Query("apikey") apiKey: String = API_PUBLIC_KEY,
        @Query("ts") ts: Int = API_TS,
        @Query("hash") hash: String = API_HASH
    ): Response<ApiResponse<List<Character>>>

}