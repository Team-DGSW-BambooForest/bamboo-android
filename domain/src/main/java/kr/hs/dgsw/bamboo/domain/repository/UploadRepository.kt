package kr.hs.dgsw.bamboo.domain.repository

interface UploadRepository {

    suspend fun getImageByPostId(
        postId: Long
    ): String
}
