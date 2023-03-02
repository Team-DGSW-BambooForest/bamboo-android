package kr.hs.dgsw.bamboo.data.datasource.remote

import kr.hs.dgsw.bamboo.data.network.remote.UploadRemoteDataSource
import kr.hs.dgsw.bamboo.data.network.service.UploadService
import kr.hs.dgsw.bamboo.data.util.safeApiCall
import okhttp3.MultipartBody
import javax.inject.Inject

class UploadRemoteDataSourceImpl @Inject constructor(
    private val api: UploadService
) : UploadRemoteDataSource {

    override suspend fun getImageByPostId(postId: Long): String = safeApiCall {
        api.getImageByPostId(postId)
    }

    override suspend fun postImage(
        postId: Long,
        image: MultipartBody.Part
    ) = safeApiCall {
        api.postImageByPostId(postId, image)
    }
}
