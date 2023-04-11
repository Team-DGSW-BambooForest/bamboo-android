package kr.hs.dgsw.bamboo.bamboo_android.feature.comment

import kr.hs.dgsw.bamboo.domain.entity.comment.Comment
import kr.hs.dgsw.bamboo.domain.entity.post.Post

data class CommentState(
    val comments: List<Comment>? = null,
    val contentImage: String? = null,
    val post: Post? = null,
    val exception: Throwable? = null,
)