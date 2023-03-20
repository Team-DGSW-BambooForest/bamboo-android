package kr.hs.dgsw.bamboo.domain.repository

import kr.hs.dgsw.bamboo.domain.entity.comment.Comment

interface CommentRepository {
    suspend fun getCommentByPostId(postId: Long): List<Comment>
}