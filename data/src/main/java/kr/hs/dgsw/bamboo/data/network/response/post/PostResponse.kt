package kr.hs.dgsw.bamboo.data.network.response.post

import com.google.gson.annotations.SerializedName

data class PostResponse(
    @SerializedName("postId")
    val postId: Long,
    @SerializedName("author")
    val author: String,
    @SerializedName("profileImage")
    val profileImage: String,
    @SerializedName("content")
    val content: String,
    @SerializedName("ceeatAt")
    val createTime: String,
    @SerializedName("hashTags")
    val hashTags: List<HashTagResponse>,
)