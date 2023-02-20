package kr.hs.dgsw.bamboo.data.network.response.post

import com.google.gson.annotations.SerializedName

data class HashTagResponse(
    @SerializedName("hashTag")
    val hashTag: String,
    @SerializedName("tagId")
    val tagId: Long
)