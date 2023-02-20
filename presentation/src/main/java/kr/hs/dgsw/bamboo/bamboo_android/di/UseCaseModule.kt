package kr.hs.dgsw.bamboo.bamboo_android.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kr.hs.dgsw.bamboo.domain.repository.PostRepository
import kr.hs.dgsw.bamboo.domain.usecase.GetPostListUseCase
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {

    @Singleton
    @Provides
    fun provideGetPostListUseCase(postRepository: PostRepository): GetPostListUseCase =
        GetPostListUseCase(postRepository)
}