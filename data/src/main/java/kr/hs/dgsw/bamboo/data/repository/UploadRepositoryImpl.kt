package kr.hs.dgsw.bamboo.data.repository

import kr.hs.dgsw.bamboo.data.network.remote.UploadRemoteDataSource
import kr.hs.dgsw.bamboo.domain.repository.UploadRepository
import okhttp3.MultipartBody
import javax.inject.Inject

class UploadRepositoryImpl @Inject constructor(
    private val remote: UploadRemoteDataSource
) : UploadRepository {

    override suspend fun getImageByPostId(postId: Long): String =
        remote.getImageByPostId(postId)

    override suspend fun postImage(postId: Long, image: MultipartBody.Part) =
        remote.postImage(postId, image)
}
