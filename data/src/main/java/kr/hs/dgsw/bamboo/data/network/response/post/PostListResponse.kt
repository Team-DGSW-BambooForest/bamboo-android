package kr.hs.dgsw.bamboo.data.network.response.post

import com.google.gson.annotations.SerializedName

data class PostListResponse(
    @SerializedName("list")
    val list: List<PostResponse>,

)
