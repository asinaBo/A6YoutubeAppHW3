/*
package com.example.a6youtubeapp.core.network

import com.example.a6youtubeapp.BuildConfig
import com.example.a6youtubeapp.core.utils.Resource
import com.example.a6youtubeapp.data.model.PlaylistsModel
import com.example.a6youtubeapp.utils.Constants
import com.example.youtube.core.network.BaseDataSource

class RemoteDataSource(private val apiService: ApiService): BaseDataSource() {
    suspend fun getPlaylists():Resource<PlaylistsModel> {
        return getResult {
            apiService.getPlaylists(
                part = Constants.PART,
                channelId = Constants.CHANNEL_ID,
                apiKey = BuildConfig.API_KEY,
                maxResults = 10,
            )
        }
    }
}*/
