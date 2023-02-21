package kr.hs.dgsw.bamboo.data.network.remote

interface UploadRemoteSource {

    suspend fun getImageByPostId(
        postId: Long
    ): String
}