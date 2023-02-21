package kr.hs.dgsw.bamboo.data.repository

import kr.hs.dgsw.bamboo.data.network.remote.PostRemoteSource
import kr.hs.dgsw.bamboo.domain.model.post.PostList
import kr.hs.dgsw.bamboo.domain.repository.PostRepository
import javax.inject.Inject

class PostRepositoryImpl @Inject constructor(
    private val postRemoteSource: PostRemoteSource,
) : PostRepository {

    override suspend fun getPostList(): PostList =
        postRemoteSource.getPostList()
}
