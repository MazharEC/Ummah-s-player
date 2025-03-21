package com.example.videomaxplayer.Presentation.Navigation

import androidx.compose.runtime.Composable

import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.example.videomaxplayer.Presentation.App
import com.example.videomaxplayer.Presentation.FolderScreen
import com.example.videomaxplayer.Presentation.FolderVideosScreen
import com.example.videomaxplayer.Presentation.HomeScreen
import com.example.videomaxplayer.Presentation.VideoPlayerScreen

@Composable
fun AppNavigation() {

    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = NavigationItems.App) {

        composable<NavigationItems.App>{
           App(navController = navController)
        }

        composable<NavigationItems.HomeScreen>{

            HomeScreen(navController)
        }

        composable<NavigationItems.PlayerScreen> {BackStackEntry-> // how backstackEntry helps in data transfer
            val url : NavigationItems.PlayerScreen = BackStackEntry.toRoute<NavigationItems.PlayerScreen>()
            VideoPlayerScreen(url.VideoUrl, navController = navController)

        }

        composable<NavigationItems.AllVideoFolder> {
            val folderName : NavigationItems.AllVideoFolder = it.toRoute()
            FolderScreen(navController = navController)

        }

        composable<NavigationItems.FolderVideosScreen>{
            val foldername : NavigationItems.FolderVideosScreen = it.toRoute()
            FolderVideosScreen(navController = navController, folderName = foldername.folderName)

        }

    }
}