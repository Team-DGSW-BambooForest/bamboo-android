package kr.hs.dgsw.bamboo.data.mapper

import kr.hs.dgsw.bamboo.data.network.response.comment.CommentResponse
import kr.hs.dgsw.bamboo.domain.entity.comment.Comment

fun CommentResponse.toEntity(): Comment = Comment(
    id = this.id,
    profileImage = this.profileImage,
    writer = this.writer,
    content = this.content,
    createdAt = this.createdAt
)
