package com.bst.assignment3_20bce7458

import retrofit2.http.GET
import retrofit2.http.Query

interface YouTubeApiService {
    @GET("search")
    suspend fun searchVideos(
        @Query("key") apiKey: String,
        @Query("part") part: String = "snippet",
        @Query("maxResults") maxResults: Int = 10,
        @Query("q") query: String
    ): YouTubeSearchResponse
}

data class YouTubeSearchResponse(
    val items: List<YouTubeSearchResult>
)

data class YouTubeSearchResult(
    val id: YouTubeVideoId,
    val snippet: YouTubeVideoSnippet
)

data class YouTubeVideoId(
    val videoId: String
)

data class YouTubeVideoSnippet(
    val title: String,
    val description: String,
    val thumbnails: YouTubeVideoThumbnails
)

data class YouTubeVideoThumbnails(
    val medium: YouTubeVideoThumbnail
)

data class YouTubeVideoThumbnail(
    val url: String
)

