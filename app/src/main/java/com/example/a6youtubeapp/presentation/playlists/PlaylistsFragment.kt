package com.example.a6youtubeapp.presentation.playlists

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.example.a6youtubeapp.core.base.BaseFragment
import com.example.a6youtubeapp.core.network.RetrofitClient
import com.example.a6youtubeapp.core.utils.Status
import com.example.a6youtubeapp.databinding.FragmentPlaylistsBinding
import com.example.a6youtubeapp.domain.repository.Repository

class PlaylistsFragment : BaseFragment<FragmentPlaylistsBinding>() { // podkluchit base fragnebt

    private val playListViewModel =
        PlaylistsViewModel(Repository(RetrofitClient().createApiService()))
    private val adapter = PlaylistsAdapter()

    override fun inflaterViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ) = FragmentPlaylistsBinding.inflate(inflater, container, false)


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        playListViewModel.getPlaylists().observe(viewLifecycleOwner) { resource ->
            when (resource.status) {
                Status.SUCCESS -> {
                    resource.data?.let {
                        adapter.addData(it.items)
                        binding.rcView.adapter = adapter
                    }
                    Log.e("the", "data: ${resource.message}")
                }

                Status.ERROR -> {
                }

                Status.LOADING -> TODO()
            }
        }
    }
}

