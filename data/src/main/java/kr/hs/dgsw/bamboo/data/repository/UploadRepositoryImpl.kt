package kr.hs.dgsw.bamboo.data.repository

import kr.hs.dgsw.bamboo.data.network.remote.UploadRemoteSource
import kr.hs.dgsw.bamboo.domain.repository.UploadRepository
import javax.inject.Inject

class UploadRepositoryImpl @Inject constructor(
    private val uploadRemoteSource: UploadRemoteSource
) : UploadRepository {

    override suspend fun getImageByPostId(postId: Long): String =
        uploadRemoteSource.getImageByPostId(postId)
}
