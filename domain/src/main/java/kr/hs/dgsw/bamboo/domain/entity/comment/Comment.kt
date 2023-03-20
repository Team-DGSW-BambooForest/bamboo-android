package kr.hs.dgsw.bamboo.domain.entity.comment

data class Comment(
    val id: Long,
    val profileImage: String,
    val writer: String,
    val content: String,
    val createdAt: String
)
