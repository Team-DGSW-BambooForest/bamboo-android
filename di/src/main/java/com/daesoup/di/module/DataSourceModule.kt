package com.daesoup.di.module

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kr.hs.dgsw.bamboo.data.datasource.remote.PostRemoteDataSourceImpl
import kr.hs.dgsw.bamboo.data.datasource.remote.UploadRemoteDataSourceImpl
import kr.hs.dgsw.bamboo.data.network.remote.PostRemoteDataSource
import kr.hs.dgsw.bamboo.data.network.remote.UploadRemoteDataSource
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class DataSourceModule {

    @Binds
    @Singleton
    abstract fun bindPostRemoteDataSource(postRemoteDataSourceImpl: PostRemoteDataSourceImpl): PostRemoteDataSource
    @Binds
    @Singleton
    abstract fun bindUploadRemoteDataSource(uploadRemoteDataSourceImpl: UploadRemoteDataSourceImpl): UploadRemoteDataSource
}
