package kr.hs.dgsw.bamboo.bamboo_android.feature.comment

import kr.hs.dgsw.bamboo.domain.entity.comment.Comment

data class CommentState(
    val postId: Long? = null,
    val comments: List<Comment>? = null,
    val exception: Throwable? = null,
)