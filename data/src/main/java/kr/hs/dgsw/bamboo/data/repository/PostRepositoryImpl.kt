package kr.hs.dgsw.bamboo.data.repository

import kr.hs.dgsw.bamboo.data.mapper.toEntity
import kr.hs.dgsw.bamboo.data.mapper.toRequest
import kr.hs.dgsw.bamboo.data.network.remote.PostRemoteDataSource
import kr.hs.dgsw.bamboo.domain.entity.post.PostList
import kr.hs.dgsw.bamboo.domain.param.post.CreatePostParam
import kr.hs.dgsw.bamboo.domain.repository.PostRepository
import javax.inject.Inject

class PostRepositoryImpl @Inject constructor(
    private val remote: PostRemoteDataSource,
) : PostRepository {

    override suspend fun getPostList(): PostList =
        remote.getPostList().toEntity()

    override suspend fun createPost(createPostParam: CreatePostParam): Long =
        remote.createPost(createPostParam.toRequest())

    override suspend fun searchPost(word: String): PostList =
        remote.searchPost(word).toEntity()
}
