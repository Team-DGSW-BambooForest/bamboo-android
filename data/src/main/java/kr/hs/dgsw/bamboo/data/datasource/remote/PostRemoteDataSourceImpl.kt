package kr.hs.dgsw.bamboo.data.datasource.remote

import kr.hs.dgsw.bamboo.data.network.remote.PostRemoteDataSource
import kr.hs.dgsw.bamboo.data.network.request.post.CreatePostRequest
import kr.hs.dgsw.bamboo.data.network.response.post.PostListResponse
import kr.hs.dgsw.bamboo.data.network.service.PostService
import kr.hs.dgsw.bamboo.data.util.safeApiCall
import javax.inject.Inject

class PostRemoteDataSourceImpl @Inject constructor(
    private val api: PostService
) : PostRemoteDataSource {

    override suspend fun getPostList(): PostListResponse = safeApiCall {
        api.getPostList()
    }

    override suspend fun createPost(createPostRequest: CreatePostRequest) = safeApiCall {
        api.createPost(createPostRequest)
    }
}

