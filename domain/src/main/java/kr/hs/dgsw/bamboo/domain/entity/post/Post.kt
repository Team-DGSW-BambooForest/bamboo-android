package kr.hs.dgsw.bamboo.domain.entity.post

data class Post(
    val postId: Long,
    val author: String,
    val profileImage: String,
    val content: String,
    val createTime: String,
)
