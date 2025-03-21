package com.example.videomaxplayer.Presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.viewinterop.AndroidView
import androidx.core.net.toUri
import androidx.media3.common.MediaItem
import androidx.media3.exoplayer.ExoPlayer
import androidx.media3.ui.PlayerView
import androidx.navigation.NavHostController

//
//@Composable
//fun VideoPlayerScreen(url : String, navController: NavHostController) {
//
//
//}

@Composable
fun VideoPlayerScreen(url : String, navController: NavHostController) {
    // Get the current context
    val context = LocalContext.current

    // Initialize ExoPlayer
    val exoPlayer = remember {

        ExoPlayer.Builder(context).build().apply{
            val mediaItem = MediaItem.fromUri(url.toUri())

            setMediaItem(mediaItem)
            prepare()
            playWhenReady = true
        }
}

  Column(modifier = Modifier.fillMaxSize() ,
      horizontalAlignment =  Alignment.CenterHorizontally,
      verticalArrangement = Arrangement.Center

  ) {

      AndroidView(factory = {

          PlayerView(context).apply {

              player = exoPlayer
          }
      },
          update = {

              it.player = exoPlayer
          }
      )
      DisposableEffect(

          Unit
      ){
          onDispose {

              exoPlayer.release()
          }

      }

  }
}



