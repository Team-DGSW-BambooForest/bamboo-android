package kr.hs.dgsw.bamboo.bamboo_android.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kr.hs.dgsw.bamboo.domain.repository.PostRepository
import kr.hs.dgsw.bamboo.domain.repository.UploadRepository
import kr.hs.dgsw.bamboo.domain.usecase.CreatePostUseCase
import kr.hs.dgsw.bamboo.domain.usecase.GetImageUseCase
import kr.hs.dgsw.bamboo.domain.usecase.GetPostListUseCase
import kr.hs.dgsw.bamboo.domain.usecase.SearchPostUseCase
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {

    @Singleton
    @Provides
    fun provideGetPostListUseCase(repository: PostRepository): GetPostListUseCase =
        GetPostListUseCase(repository)

    @Singleton
    @Provides
    fun provideGetImageUseCase(repository: UploadRepository): GetImageUseCase =
        GetImageUseCase(repository)

    @Singleton
    @Provides
    fun provideCreatePostUseCase(repository: PostRepository): CreatePostUseCase =
        CreatePostUseCase(repository)

    @Singleton
    @Provides
    fun provideSearchPostUseCase(repository: PostRepository): SearchPostUseCase =
        SearchPostUseCase(repository)
}
