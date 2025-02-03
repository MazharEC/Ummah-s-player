package com.example.videomaxplayer.Presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.videomaxplayer.Presentation.ViewModel.ViewModel
import com.example.videomaxplayer.Utils.CustemTopAppBar
import com.example.videomaxplayer.Utils.VideoCard

@Composable
fun FolderVideosScreen(
    navController: NavController,
    folderName: String,
    viewModel: ViewModel = hiltViewModel()
) {


    Scaffold(
        topBar = { CustemTopAppBar(topAppBarText = folderName, navController = navController) }
    ) {innerPadding ->


        val videoFolders = viewModel.FolderList.collectAsState().value
        val videosInFolder = videoFolders[folderName] ?: emptyList()

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            contentPadding = PaddingValues(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            items(videosInFolder) { video ->
                VideoCard(
                    path = video.path,
                    title = video.title ?: "Untitled",
                    size = video.size ?: "Unknown",
                    duration = video.duration ?: "Unknown",
                    dateAdded = video.dateAdded ?: "Unknown",
                    fileNames = video.fileName?: "Unknown",
                    thumbnail = video.thumbnailUri ?: "Unknown",
                    id = video.id ?: "Unknown",
                    navController = navController

                )
            }
        }
    }


}