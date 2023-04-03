package kr.hs.dgsw.bamboo.data.network.response.post

import com.google.gson.annotations.SerializedName

data class PostListResponse(
    @field:SerializedName("hasMorePage")
    val hasMorePage: Boolean,
    @field:SerializedName("currentPage")
    val currentPage: Long,
    @field:SerializedName("list")
    val list: List<PostResponse>,

)
