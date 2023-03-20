package kr.hs.dgsw.bamboo.data.network.response.comment

import com.google.gson.annotations.SerializedName

data class CommentResponse(
    @field:SerializedName("id")
    val id: Long,
    @field:SerializedName("profileImage")
    val profileImage: String,
    @field:SerializedName("writer")
    val writer: String,
    @field:SerializedName("content")
    val content: String,
    @field:SerializedName("createdAt")
    val createdAt: String
)
