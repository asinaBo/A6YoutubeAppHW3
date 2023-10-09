package com.example.a6youtubeapp.presentation.playlists

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.a6youtubeapp.data.model.PlaylistsModel
import com.example.a6youtubeapp.databinding.ItemPlaylistsFragmentBinding

class PlaylistsAdapter :
    RecyclerView.Adapter<PlaylistsAdapter.ViewHolder>() {

    private val _playlist = mutableListOf<PlaylistsModel.Item>()
    private val playlist get() = _playlist


    fun addData(list: List<PlaylistsModel.Item>) {
        _playlist.clear()
        _playlist.addAll(list)
        notifyItemRangeInserted(playlist.size, list.size - _playlist.size)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemPlaylistsFragmentBinding.inflate
                (LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun getItemCount(): Int {
        return playlist.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(playlist[position])
    }

    inner class ViewHolder(private val binding: ItemPlaylistsFragmentBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(playList: PlaylistsModel.Item) {
            binding.tvTitle.text = playList.snippet.title
            binding.tvSubtitle.text = playList.contentDetails.itemCount.toString() + " video series"
            binding.imgPlaylist.load(playList.snippet.thumbnails.default.url)

        }
    }
}
