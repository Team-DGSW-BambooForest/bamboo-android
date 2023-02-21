package kr.hs.dgsw.bamboo.data.network.service

import kr.hs.dgsw.bamboo.data.network.url.BambooUrl
import retrofit2.http.GET
import retrofit2.http.Path

interface UploadService {

    @GET(BambooUrl.Upload.POST_ID)
    suspend fun getImageByPostId(
        @Path("postId") postId: Long
    ): String
}
