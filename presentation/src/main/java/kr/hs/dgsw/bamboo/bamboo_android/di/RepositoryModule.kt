package kr.hs.dgsw.bamboo.bamboo_android.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kr.hs.dgsw.bamboo.data.network.remote.PostRemoteSource
import kr.hs.dgsw.bamboo.data.repository.PostRepositoryImpl
import kr.hs.dgsw.bamboo.domain.repository.PostRepository
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun providePostRepository(postRemoteSource: PostRemoteSource): PostRepository =
        PostRepositoryImpl(postRemoteSource)
}