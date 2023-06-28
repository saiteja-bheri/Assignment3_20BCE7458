package com.bst.assignment3_20bce7458

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.bst.assignment3_20bce7458.ui.theme.Assignment3_20BCE7458Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Assignment3_20BCE7458Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    App()
                }
            }
        }
    }

    @SuppressLint("RememberReturnType")
    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun App() {
        val viewModel: YouTubeViewModel = viewModel()
        val videos = viewModel.videos

        var value by remember { mutableStateOf("") }

        Column {
            TextField(
                value = value,
                onValueChange = { value = it },
                placeholder = { Text("Search videos") },
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth(),
                trailingIcon = {
                    IconButton(onClick = { viewModel.searchVideos(value) }) {
                        Icon(Icons.Default.Search, contentDescription = "Search")
                    }
                }
            )
            YouTubeVideoList(videos, onClick = {
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse(it))
                startActivity(intent)
            })
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun GreetingPreview() {
        Assignment3_20BCE7458Theme {
            App()
        }
    }
}

