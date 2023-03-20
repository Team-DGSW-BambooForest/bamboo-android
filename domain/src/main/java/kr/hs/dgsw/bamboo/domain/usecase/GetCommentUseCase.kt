package kr.hs.dgsw.bamboo.domain.usecase

import kr.hs.dgsw.bamboo.domain.param.post.CreatePostParam
import kr.hs.dgsw.bamboo.domain.repository.CommentRepository
import javax.inject.Inject

class GetCommentUseCase @Inject constructor(
    private val repository: CommentRepository
) {
    suspend operator fun invoke(postId: Long) = kotlin.runCatching {
        repository.getCommentByPostId(postId)
    }
}