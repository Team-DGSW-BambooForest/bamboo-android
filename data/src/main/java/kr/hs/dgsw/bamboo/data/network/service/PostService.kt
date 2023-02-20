package kr.hs.dgsw.bamboo.data.network.service

import kr.hs.dgsw.bamboo.data.network.response.post.PostListResponse
import kr.hs.dgsw.bamboo.data.network.url.BambooUrl
import retrofit2.http.GET

interface PostService {

    @GET(BambooUrl.Post.LIST)
    suspend fun getPostList(
    ): PostListResponse
}
