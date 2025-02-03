package com.example.videomaxplayer.Presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.videomaxplayer.Presentation.ViewModel.ViewModel
import com.example.videomaxplayer.Utils.VideoCard

@Composable
fun VideosScreen(
    navController: NavController,
    modifier: Modifier = Modifier,
    viewModel: ViewModel = hiltViewModel()
) {

  Column(
      modifier = modifier.fillMaxSize()
  ) {

      LaunchedEffect(key1 = true) {
          viewModel.LoadVideofiles()
      }

      val videoList = viewModel.videoList.collectAsState()
      LazyColumn( modifier = Modifier.fillMaxSize(),
          contentPadding = PaddingValues(16.dp),
          verticalArrangement = Arrangement.spacedBy(16.dp)) {
          items(videoList.value){

              VideoCard(
                  path = it.path,
                  title = it.title,
                  size = it.size,
                  duration = it.duration,
                  dateAdded = it.dateAdded,
                  fileNames = it.fileName,
                  thumbnail = it.thumbnailUri.toString(),
                  id = it.id.toString(),
                  navController = navController
              )
          }
      }
  }
}