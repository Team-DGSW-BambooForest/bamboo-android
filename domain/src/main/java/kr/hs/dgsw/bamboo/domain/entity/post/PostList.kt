package kr.hs.dgsw.bamboo.domain.entity.post

data class PostList(
    val hasMorePage: Boolean,
    val currentPage: Long,
    val list: List<Post>
)
