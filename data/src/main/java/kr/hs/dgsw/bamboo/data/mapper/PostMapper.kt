package kr.hs.dgsw.bamboo.data.mapper

import kr.hs.dgsw.bamboo.data.network.request.post.CreatePostRequest
import kr.hs.dgsw.bamboo.data.network.response.post.HashTagResponse
import kr.hs.dgsw.bamboo.data.network.response.post.PostListResponse
import kr.hs.dgsw.bamboo.data.network.response.post.PostResponse
import kr.hs.dgsw.bamboo.domain.entity.post.HashTag
import kr.hs.dgsw.bamboo.domain.entity.post.Post
import kr.hs.dgsw.bamboo.domain.entity.post.PostList
import kr.hs.dgsw.bamboo.domain.param.post.CreatePostParam

fun PostListResponse.toEntity() = PostList(
    list = this.list.map { it.toEntity() }
)

fun PostResponse.toEntity() = Post(
    postId = this.postId,
    author = this.author,
    profileImage = this.profileImage,
    content = this.content,
    createTime = "${createTime.split("-", "T")[0]}.${createTime.split("-", "T")[1]}.${createTime.split("-", "T")[2]}",
    hashTags = this.hashTags.map { it.toEntity() }
)

fun HashTagResponse.toEntity() = HashTag(
    hashTag = this.hashTag,
    tagId = this.tagId
)

fun CreatePostParam.toRequest() = CreatePostRequest(
    content = this.content,
    hashTags = this.hashTags
)