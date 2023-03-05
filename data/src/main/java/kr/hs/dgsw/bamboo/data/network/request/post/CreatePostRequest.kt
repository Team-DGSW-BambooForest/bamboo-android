package kr.hs.dgsw.bamboo.data.network.request.post

import com.google.gson.annotations.SerializedName

data class CreatePostRequest(
    @SerializedName("content")
    val content: String,
    @SerializedName("hashtags")
    val hashTags: List<String>
)
