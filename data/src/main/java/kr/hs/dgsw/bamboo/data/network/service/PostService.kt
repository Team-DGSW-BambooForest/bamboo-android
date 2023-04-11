package kr.hs.dgsw.bamboo.data.network.service

import kr.hs.dgsw.bamboo.data.network.request.post.CreatePostRequest
import kr.hs.dgsw.bamboo.data.network.response.post.PostListResponse
import kr.hs.dgsw.bamboo.data.network.response.post.PostResponse
import kr.hs.dgsw.bamboo.data.network.url.BambooUrl
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface PostService {

    @GET(BambooUrl.Post.LIST)
    suspend fun getPostList(): PostListResponse

    @POST(BambooUrl.Post.CREATE)
    suspend fun createPost(
        @Body createPostRequest: CreatePostRequest
    ): Long

    @GET(BambooUrl.Post.ID)
    suspend fun getPostById(
        @Path("id") id: Long
    ): PostResponse
}
