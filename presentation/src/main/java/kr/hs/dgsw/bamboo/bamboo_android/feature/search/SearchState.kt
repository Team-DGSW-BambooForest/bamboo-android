package kr.hs.dgsw.bamboo.bamboo_android.feature.search

import kr.hs.dgsw.bamboo.domain.entity.post.PostList

data class SearchState(
    val postList: PostList? = null,
    val contentImage: String? = null,
    val exception: Throwable? = null,
)
