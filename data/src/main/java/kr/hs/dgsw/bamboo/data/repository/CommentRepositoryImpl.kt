package kr.hs.dgsw.bamboo.data.repository

import kr.hs.dgsw.bamboo.data.mapper.toEntity
import kr.hs.dgsw.bamboo.data.network.remote.CommentRemoteDateSource
import kr.hs.dgsw.bamboo.domain.entity.comment.Comment
import kr.hs.dgsw.bamboo.domain.repository.CommentRepository
import javax.inject.Inject

class CommentRepositoryImpl @Inject constructor(
    private val remote: CommentRemoteDateSource
) : CommentRepository {

    override suspend fun getCommentByPostId(postId: Long): List<Comment> =
        remote.getCommentByPostId(postId).map { it.toEntity() }

}