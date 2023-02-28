package kr.hs.dgsw.bamboo.data.network.service

import kr.hs.dgsw.bamboo.data.network.request.post.UploadImageRequest
import kr.hs.dgsw.bamboo.data.network.url.BambooUrl
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.Part
import retrofit2.http.Path

interface UploadService {

    @GET(BambooUrl.Upload.POST_ID)
    suspend fun getImageByPostId(
        @Path("postId") postId: Long
    ): String

    @POST(BambooUrl.Upload.POST_ID)
    suspend fun postImageByPostId(
        @Path("postId") postId: Long,
        @Body image: UploadImageRequest
    )
}
