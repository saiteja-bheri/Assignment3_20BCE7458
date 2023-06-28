package com.bst.assignment3_20bce7458

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.bst.assignment3_20bce7458.YouTubeVideo

@Composable
fun YouTubeVideoList(
    videos: List<YouTubeVideo>,
    onClick: (String) -> Unit
) {
    //update this code according to letest jetpack compose
    LazyColumn {
        items(items = videos) { video ->
            Column(
                modifier = Modifier
                    .padding(16.dp)
                    .clickable { /* Handle video item click */ }
            ) {
                AsyncImage(
                    model = video.thumbnailUrl,
                    contentDescription = "Profile picture",
                    modifier = Modifier
                        .height(200.dp)
                        .fillMaxWidth()
                        .clip(shape = RoundedCornerShape(8.dp)),
                    contentScale = ContentScale.Crop
                )
                Spacer(modifier = Modifier.height(8.dp))
                TextButton(onClick = { onClick(video.videoUrl)}) {
                    Text(
                        text = video.title,
                        style = TextStyle(fontSize = 18.sp, fontWeight = FontWeight.Bold)
                    )
                }
                Spacer(modifier = Modifier.height(4.dp))
                Text(text = video.description)
            }
        }
    }
}
