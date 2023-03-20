package kr.hs.dgsw.bamboo.bamboo_android.feature.comment

import kr.hs.dgsw.bamboo.domain.entity.comment.Comment

data class CommentState(
    val comments: List<Comment>? = null,
    val contentImage: String? = null,
    val postId: Long? = null,
    val exception: Throwable? = null,
)