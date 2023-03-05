package kr.hs.dgsw.bamboo.domain.usecase

import kr.hs.dgsw.bamboo.domain.param.post.CreatePostParam
import kr.hs.dgsw.bamboo.domain.repository.PostRepository
import javax.inject.Inject

class CreatePostUseCase @Inject constructor(
    private val repository: PostRepository
) {
    suspend operator fun invoke(createPostParam: CreatePostParam) = kotlin.runCatching {
        repository.createPost(createPostParam)
    }
}
