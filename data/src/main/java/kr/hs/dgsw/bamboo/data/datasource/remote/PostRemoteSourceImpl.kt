package kr.hs.dgsw.bamboo.data.datasource.remote

import kr.hs.dgsw.bamboo.data.mapper.toModel
import kr.hs.dgsw.bamboo.data.network.remote.PostRemoteSource
import kr.hs.dgsw.bamboo.data.network.service.PostService
import kr.hs.dgsw.bamboo.data.util.handleNetwork
import kr.hs.dgsw.bamboo.domain.model.post.PostList
import javax.inject.Inject

class PostRemoteSourceImpl @Inject constructor(
    private val postService: PostService
) : PostRemoteSource {

    override suspend fun getPostList(): PostList = handleNetwork {
        postService.getPostList().toModel()
    }
}