package com.daesoup.di.module

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kr.hs.dgsw.bamboo.data.repository.PostRepositoryImpl
import kr.hs.dgsw.bamboo.data.repository.UploadRepositoryImpl
import kr.hs.dgsw.bamboo.domain.repository.PostRepository
import kr.hs.dgsw.bamboo.domain.repository.UploadRepository
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindPostRepository(postRepositoryImpl: PostRepositoryImpl): PostRepository

    @Binds
    @Singleton
    abstract fun bindUploadRepository(uploadRepositoryImpl: UploadRepositoryImpl): UploadRepository
}
