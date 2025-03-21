package com.example.videomaxplayer.Presentation.ViewModel
import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.videomaxplayer.Data.model.VideoFile
import com.example.videomaxplayer.Domain.Repo.VideoFileRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ViewModel @Inject constructor(val repo : VideoFileRepo, val application: Application): ViewModel()  {

    val showUi = MutableStateFlow(false)

    val videoList = MutableStateFlow(emptyList<VideoFile>())
    val FolderList = MutableStateFlow(emptyMap<String, List<VideoFile>>())

    var isLoading = MutableStateFlow(false)

     fun LoadVideofiles(){

         isLoading.value = true
         viewModelScope.launch {
             repo.getAllVideos(application).collectLatest {

                 videoList.value = it
             }
         }
         isLoading.value = false
    }
     fun LoadVideoFolders(){

         isLoading.value = true
         viewModelScope.launch {
             repo.getAllFolders(application).collectLatest {

                 FolderList.value = it
             }
         }
         isLoading.value = false
    }


    init {
        viewModelScope.launch {

           LoadVideofiles()
            LoadVideoFolders()
        }


    }
}