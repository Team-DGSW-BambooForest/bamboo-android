package kr.hs.dgsw.bamboo.data.network.remote

import kr.hs.dgsw.bamboo.domain.model.post.PostList

interface PostRemoteSource {

    suspend fun getPostList(
    ): PostList
}