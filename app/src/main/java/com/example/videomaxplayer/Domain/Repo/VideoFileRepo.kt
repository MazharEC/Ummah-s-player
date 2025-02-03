package com.example.videomaxplayer.Domain.Repo

import android.app.Application
import com.example.videomaxplayer.Data.model.VideoFile
import kotlinx.coroutines.flow.Flow


interface VideoFileRepo {
suspend fun getAllVideos(application: Application) : Flow<ArrayList<VideoFile>>
suspend fun getAllFolders(application: Application) : Flow<Map<String,List<VideoFile> >>

}