package kr.hs.dgsw.bamboo.data.mapper

import kr.hs.dgsw.bamboo.data.network.response.post.HashTagResponse
import kr.hs.dgsw.bamboo.data.network.response.post.PostListResponse
import kr.hs.dgsw.bamboo.data.network.response.post.PostResponse
import kr.hs.dgsw.bamboo.domain.model.post.HashTag
import kr.hs.dgsw.bamboo.domain.model.post.Post
import kr.hs.dgsw.bamboo.domain.model.post.PostList

fun PostListResponse.toModel() = PostList(
    list = this.list.map { it.toModel() }
)

fun PostResponse.toModel() = Post(
    postId = this.postId,
    author = this.author,
    profileImage = this.profileImage,
    content = this.content,
    createTime = "${createTime.split("-", "T")[0]}.${createTime.split("-", "T")[1]}.${createTime.split("-", "T")[2]}",
    hashTags = this.hashTags.map { it.toModel() }
)

fun HashTagResponse.toModel() = HashTag(
    hashTag = this.hashTag,
    tagId = this.tagId
)
