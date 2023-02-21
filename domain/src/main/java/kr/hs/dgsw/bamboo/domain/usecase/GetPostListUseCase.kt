package kr.hs.dgsw.bamboo.domain.usecase

import kr.hs.dgsw.bamboo.domain.repository.PostRepository
import javax.inject.Inject

class GetPostListUseCase @Inject constructor(
    private val repository: PostRepository
) {
    suspend fun invoke() = kotlin.runCatching {
        repository.getPostList()
    }
}
