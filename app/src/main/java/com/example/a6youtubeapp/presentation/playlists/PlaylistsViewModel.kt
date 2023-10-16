package com.example.a6youtubeapp.presentation.playlists

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.a6youtubeapp.core.base.BaseViewModel
import com.example.a6youtubeapp.core.utils.Resource
import com.example.a6youtubeapp.data.model.PlaylistsModel
import com.example.a6youtubeapp.domain.repository.Repository


class PlaylistsViewModel(private val repository: Repository) : BaseViewModel() {

    fun getPlaylists(): LiveData<Resource<PlaylistsModel>> {
        return repository.getPlaylists()
    }
}