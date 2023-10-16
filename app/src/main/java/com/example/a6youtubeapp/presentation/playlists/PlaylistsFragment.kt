package com.example.a6youtubeapp.presentation.playlists


import android.content.Context
import android.content.Context.CONNECTIVITY_SERVICE
import android.net.ConnectivityManager
import android.net.Network
import android.net.NetworkInfo
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.a6youtubeapp.R
import com.example.a6youtubeapp.core.base.BaseFragment
import com.example.a6youtubeapp.core.network.RetrofitClient
import com.example.a6youtubeapp.core.utils.Status
import com.example.a6youtubeapp.databinding.FragmentPlaylistsBinding
import com.example.a6youtubeapp.domain.repository.Repository
import com.example.a6youtubeapp.presentation.MainActivity
import com.example.a6youtubeapp.utils.NetworkConnection


class PlaylistsFragment :
    BaseFragment<FragmentPlaylistsBinding, PlaylistsViewModel>() { // podkluchit base fragnebt

    private val playListViewModel =
        PlaylistsViewModel(Repository(RetrofitClient().createApiService()))
    private val adapter = PlaylistsAdapter()
    override val viewModel: PlaylistsViewModel
        get() = PlaylistsViewModel(MainActivity.repository)

    private val isConnectedLiveData = MutableLiveData<Boolean>()


    override fun inflaterViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ) = FragmentPlaylistsBinding.inflate(inflater, container, false)

    override fun setConnection() {

        val networkConnection = NetworkConnection(requireContext())
        networkConnection.observe(viewLifecycleOwner) { isConnected ->
            if (!isConnected) {
                binding.rcView.visibility = View.GONE
                binding.internetLayout.visibility = View.VISIBLE
            }
            binding.networkLayout.btnTryAgain.setOnClickListener {
                if (isConnected) {

                    binding.internetLayout.visibility = View.GONE
                    binding.rcView.visibility = View.VISIBLE
                }
            }
        }
    }

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

                Status.LOADING ->
                    binding.progressBar.visibility = View.VISIBLE

            }
        }
    }


}
