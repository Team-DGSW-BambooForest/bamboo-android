package kr.hs.dgsw.bamboo.data.network.remote

import kr.hs.dgsw.bamboo.data.network.request.post.CreatePostRequest
import kr.hs.dgsw.bamboo.data.network.response.post.PostListResponse

interface PostRemoteDataSource {

    suspend fun getPostList(): PostListResponse

    suspend fun createPost(createPostRequest: CreatePostRequest)
}
