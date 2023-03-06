package kr.hs.dgsw.bamboo.data.network.remote

import okhttp3.MultipartBody

interface UploadRemoteDataSource {

    suspend fun getImageByPostId(postId: Long): String

    suspend fun postImage(
        postId: Long,
        image: MultipartBody.Part
    )
}
