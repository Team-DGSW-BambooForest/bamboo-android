package kr.hs.dgsw.bamboo.bamboo_android.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kr.hs.dgsw.bamboo.data.network.remote.PostRemoteDataSource
import kr.hs.dgsw.bamboo.data.network.remote.UploadRemoteDataSource
import kr.hs.dgsw.bamboo.data.repository.PostRepositoryImpl
import kr.hs.dgsw.bamboo.data.repository.UploadRepositoryImpl
import kr.hs.dgsw.bamboo.domain.repository.PostRepository
import kr.hs.dgsw.bamboo.domain.repository.UploadRepository
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun providePostRepository(remote: PostRemoteDataSource): PostRepository =
        PostRepositoryImpl(remote)

    @Provides
    @Singleton
    fun provideUploadRepository(remote: UploadRemoteDataSource): UploadRepository =
        UploadRepositoryImpl(remote)

}
