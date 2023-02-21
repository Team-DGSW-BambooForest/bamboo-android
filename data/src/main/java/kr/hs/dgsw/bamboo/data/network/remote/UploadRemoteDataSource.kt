package kr.hs.dgsw.bamboo.data.network.remote

interface UploadRemoteDataSource {

    suspend fun getImageByPostId(postId: Long): String
}
