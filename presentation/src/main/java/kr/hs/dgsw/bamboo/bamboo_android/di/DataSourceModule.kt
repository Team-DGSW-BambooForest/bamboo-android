package kr.hs.dgsw.bamboo.bamboo_android.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kr.hs.dgsw.bamboo.data.datasource.remote.PostRemoteSourceImpl
import kr.hs.dgsw.bamboo.data.datasource.remote.UploadRemoteSourceImpl
import kr.hs.dgsw.bamboo.data.network.remote.PostRemoteSource
import kr.hs.dgsw.bamboo.data.network.remote.UploadRemoteSource
import kr.hs.dgsw.bamboo.data.network.service.PostService
import kr.hs.dgsw.bamboo.data.network.service.UploadService
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataSourceModule {

    @Provides
    @Singleton
    fun providePostRemoteSource(postService: PostService): PostRemoteSource =
        PostRemoteSourceImpl(postService)

    @Provides
    @Singleton
    fun provideUploadRemoteSource(uploadService: UploadService): UploadRemoteSource =
        UploadRemoteSourceImpl(uploadService)
}