package kr.hs.dgsw.bamboo.data.network.service

import kr.hs.dgsw.bamboo.data.network.url.BambooUrl
import okhttp3.MultipartBody
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

    @Multipart
    @POST(BambooUrl.Upload.POST_ID)
    suspend fun postImageByPostId(
        @Path("postId") postId: Long,
        @Part image: MultipartBody.Part
    )
}
