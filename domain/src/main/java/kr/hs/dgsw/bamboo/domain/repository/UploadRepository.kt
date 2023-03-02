package kr.hs.dgsw.bamboo.domain.repository

import okhttp3.MultipartBody

interface UploadRepository {

    suspend fun getImageByPostId(postId: Long): String

    suspend fun postImage(postId: Long, image: MultipartBody.Part)
}
