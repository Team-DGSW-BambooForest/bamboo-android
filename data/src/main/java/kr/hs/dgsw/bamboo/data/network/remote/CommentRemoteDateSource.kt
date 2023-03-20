package kr.hs.dgsw.bamboo.data.network.remote

import kr.hs.dgsw.bamboo.data.network.response.comment.CommentResponse

interface CommentRemoteDateSource {

    suspend fun getCommentByPostId(postId: Long): List<CommentResponse>

}