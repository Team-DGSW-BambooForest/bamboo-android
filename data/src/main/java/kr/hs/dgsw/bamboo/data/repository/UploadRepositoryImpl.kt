package kr.hs.dgsw.bamboo.data.repository

import kr.hs.dgsw.bamboo.data.network.remote.UploadRemoteDataSource
import kr.hs.dgsw.bamboo.domain.repository.UploadRepository
import javax.inject.Inject

class UploadRepositoryImpl @Inject constructor(
    private val remote: UploadRemoteDataSource
) : UploadRepository {

    override suspend fun getImageByPostId(postId: Long): String =
        remote.getImageByPostId(postId)
}
