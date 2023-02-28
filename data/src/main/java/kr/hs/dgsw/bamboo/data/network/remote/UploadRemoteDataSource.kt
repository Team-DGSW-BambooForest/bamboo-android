package kr.hs.dgsw.bamboo.data.network.remote

import kr.hs.dgsw.bamboo.data.network.request.post.UploadImageRequest

interface UploadRemoteDataSource {

    suspend fun getImageByPostId(postId: Long): String

    suspend fun postImageByPostId(
        postId: Long,
        uploadImageRequest: UploadImageRequest
    )
}
