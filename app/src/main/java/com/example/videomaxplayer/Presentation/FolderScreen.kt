package com.example.videomaxplayer.Presentation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.videomaxplayer.Presentation.ViewModel.ViewModel
import com.example.videomaxplayer.Utils.FolderCard


@Composable
fun FolderScreen(
    navController: NavController,
    viewModel: ViewModel = hiltViewModel()
) {
    val videoFolders = viewModel.FolderList.collectAsState().value

    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(16.dp)
    ) {
        items(videoFolders.toList()) { (folderName, videos) ->
            FolderCard(
                folderName = folderName,
                videoCount = videos.size,
                navController = navController
            )
        }
    }
}