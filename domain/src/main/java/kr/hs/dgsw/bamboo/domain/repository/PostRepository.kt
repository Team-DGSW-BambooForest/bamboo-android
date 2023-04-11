package kr.hs.dgsw.bamboo.domain.repository

import kr.hs.dgsw.bamboo.domain.entity.post.Post
import kr.hs.dgsw.bamboo.domain.entity.post.PostList
import kr.hs.dgsw.bamboo.domain.param.post.CreatePostParam

interface PostRepository {

    suspend fun getPostList(): PostList

    suspend fun createPost(createPostParam: CreatePostParam): Long

    suspend fun getPostById(id: Long): Post
}
