package com.example.videomaxplayer.Data.HiltModule

import com.example.videomaxplayer.Data.Repo.VideoFileRepoImpl
import com.example.videomaxplayer.Domain.Repo.VideoFileRepo
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object HiltModule {

    @Singleton
    @Provides
    fun ProvideVideoFileRepo() : VideoFileRepo{

        return VideoFileRepoImpl()

    }
}