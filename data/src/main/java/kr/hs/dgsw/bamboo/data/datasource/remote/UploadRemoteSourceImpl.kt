package kr.hs.dgsw.bamboo.data.datasource.remote

import kr.hs.dgsw.bamboo.data.network.remote.UploadRemoteSource
import kr.hs.dgsw.bamboo.data.network.service.UploadService
import kr.hs.dgsw.bamboo.data.util.handleNetwork
import javax.inject.Inject

class UploadRemoteSourceImpl @Inject constructor(
    private val uploadService: UploadService
) : UploadRemoteSource {

    override suspend fun getImageByPostId(postId: Long): String = handleNetwork {
        uploadService.getImageByPostId(postId)
    }
}
