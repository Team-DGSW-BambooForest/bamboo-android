package kr.hs.dgsw.bamboo.data.network.request.post

import com.google.gson.annotations.SerializedName

data class UploadImageRequest(
    @SerializedName("image")
    val image: String
)
