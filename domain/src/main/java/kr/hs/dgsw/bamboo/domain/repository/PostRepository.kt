package kr.hs.dgsw.bamboo.domain.repository

import kr.hs.dgsw.bamboo.domain.model.post.PostList

interface PostRepository {

    suspend fun getPostList(
    ): PostList
}
