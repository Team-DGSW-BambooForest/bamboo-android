package kr.hs.dgsw.bamboo.data.datasource.remote

import kr.hs.dgsw.bamboo.data.network.remote.UploadRemoteDataSource
import kr.hs.dgsw.bamboo.data.network.request.post.UploadImageRequest
import kr.hs.dgsw.bamboo.data.network.service.UploadService
import kr.hs.dgsw.bamboo.data.util.safeApiCall
import javax.inject.Inject

class UploadRemoteDataSourceImpl @Inject constructor(
    private val api: UploadService
) : UploadRemoteDataSource {

    override suspend fun getImageByPostId(postId: Long): String = safeApiCall {
        api.getImageByPostId(postId)
    }

    override suspend fun postImageByPostId(
        postId: Long,
        uploadImageRequest: UploadImageRequest
    ) = safeApiCall {
        api.postImageByPostId(postId, uploadImageRequest)
    }
}
