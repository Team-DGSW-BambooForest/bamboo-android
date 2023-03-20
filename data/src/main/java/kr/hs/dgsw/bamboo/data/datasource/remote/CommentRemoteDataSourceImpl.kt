package kr.hs.dgsw.bamboo.data.datasource.remote

import kr.hs.dgsw.bamboo.data.network.remote.CommentRemoteDateSource
import kr.hs.dgsw.bamboo.data.network.remote.UploadRemoteDataSource
import kr.hs.dgsw.bamboo.data.network.response.comment.CommentResponse
import kr.hs.dgsw.bamboo.data.network.service.CommentService
import kr.hs.dgsw.bamboo.data.network.service.UploadService
import kr.hs.dgsw.bamboo.data.util.safeApiCall
import javax.inject.Inject

class CommentRemoteDataSourceImpl @Inject constructor(
    private val api: CommentService
) : CommentRemoteDateSource {

    override suspend fun getCommentByPostId(postId: Long): List<CommentResponse> = safeApiCall {
        api.getCommentByPostId(postId)
    }

}
