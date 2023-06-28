package com.bst.assignment3_20bce7458

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class YouTubeViewModel : ViewModel() {
    private val apiKey = "AIzaSyDylNfqOp2GeYfa0Uv-ojz8lTATf1to3tQ" // Replace with your API key

    private val retrofit = Retrofit.Builder()
        .baseUrl("https://www.googleapis.com/youtube/v3/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private val apiService = retrofit.create(YouTubeApiService::class.java)

    private val _videos = mutableStateListOf<YouTubeVideo>()
    val videos: List<YouTubeVideo>
        get() = _videos

    fun searchVideos(query: String) {
        viewModelScope.launch {
            try {
                val response = apiService.searchVideos(apiKey = apiKey, query = query)
                _videos.clear()
                _videos.addAll(response.items.map { item ->
                    val videoId = item.id.videoId
                    val snippet = item.snippet
                    YouTubeVideo(
                        title = snippet.title,
                        description = snippet.description,
                        thumbnailUrl = snippet.thumbnails.medium.url,
                        videoUrl = "https://www.youtube.com/watch?v=$videoId"
                    )
                })
            } catch (e: Exception) {
                // Handle error
            }
        }
    }
}
