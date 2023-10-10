package com.example.a6youtubeapp.core.network

import com.example.a6youtubeapp.data.model.PlaylistsModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("playlists")
    fun getPlaylists(
        @Query("part")
        part: String,
        @Query("key")
        apiKey: String,
        @Query("channelId")
        channelId: String,
        @Query("maxResults")
        maxResults: Int
    ): Call<PlaylistsModel>  //  ): Response<PlaylistsModel
}