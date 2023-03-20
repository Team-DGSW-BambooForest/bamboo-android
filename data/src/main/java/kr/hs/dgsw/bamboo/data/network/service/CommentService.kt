package kr.hs.dgsw.bamboo.data.network.service

import kr.hs.dgsw.bamboo.data.network.response.comment.CommentResponse
import kr.hs.dgsw.bamboo.data.network.url.BambooUrl
import retrofit2.http.GET
import retrofit2.http.Path

interface CommentService {
    @GET(BambooUrl.Comment.POST_ID)
    suspend fun getCommentByPostId(
        @Path("postId") postId: Long
    ): List<CommentResponse>
}