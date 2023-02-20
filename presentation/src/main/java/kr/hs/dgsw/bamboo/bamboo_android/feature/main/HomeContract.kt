package kr.hs.dgsw.bamboo.bamboo_android.feature.main

import kr.hs.dgsw.bamboo.domain.model.post.PostList

data class HomeState(
    val postList: PostList? = null,
    val exception: Throwable? = null,
)
