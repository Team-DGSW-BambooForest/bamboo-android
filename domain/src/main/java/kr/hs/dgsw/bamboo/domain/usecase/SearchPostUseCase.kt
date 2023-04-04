package kr.hs.dgsw.bamboo.domain.usecase

import kr.hs.dgsw.bamboo.domain.repository.PostRepository
import javax.inject.Inject

class SearchPostUseCase @Inject constructor(
    private val postRepository: PostRepository
) {
    suspend operator fun invoke(word: String) = kotlin.runCatching {
        postRepository.searchPost(word)
    }
}
