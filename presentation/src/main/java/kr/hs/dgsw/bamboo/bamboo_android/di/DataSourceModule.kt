package kr.hs.dgsw.bamboo.bamboo_android.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kr.hs.dgsw.bamboo.data.datasource.remote.PostRemoteDataSourceImpl
import kr.hs.dgsw.bamboo.data.datasource.remote.UploadRemoteDataSourceImpl
import kr.hs.dgsw.bamboo.data.network.remote.PostRemoteDataSource
import kr.hs.dgsw.bamboo.data.network.remote.UploadRemoteDataSource
import kr.hs.dgsw.bamboo.data.network.service.PostService
import kr.hs.dgsw.bamboo.data.network.service.UploadService
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataSourceModule {

    @Provides
    @Singleton
    fun providePostRemoteDataSource(api: PostService): PostRemoteDataSource =
        PostRemoteDataSourceImpl(api)

    @Provides
    @Singleton
    fun provideUploadRemoteDataSource(api: UploadService): UploadRemoteDataSource =
        UploadRemoteDataSourceImpl(api)
}
