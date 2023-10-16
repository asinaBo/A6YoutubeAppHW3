package com.example.a6youtubeapp.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.a6youtubeapp.BuildConfig
import com.example.a6youtubeapp.R
import com.example.a6youtubeapp.core.network.RetrofitClient
import com.example.a6youtubeapp.databinding.ActivityMainBinding
import com.example.a6youtubeapp.domain.repository.Repository


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        BuildConfig.API_KEY
        BuildConfig.BASE_URL
    }
companion object{
    val retrofitClient = RetrofitClient().createApiService()
  //  private val remoteDataSource = RemoteDataSource(retrofitClient)
    val repository = Repository(retrofitClient)
}

}