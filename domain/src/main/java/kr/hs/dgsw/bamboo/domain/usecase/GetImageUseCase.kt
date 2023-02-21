package kr.hs.dgsw.bamboo.domain.usecase

import kr.hs.dgsw.bamboo.domain.repository.UploadRepository
import javax.inject.Inject

class GetImageUseCase @Inject constructor(
    private val repository: UploadRepository
) {
    suspend fun invoke(postId: Long) = kotlin.runCatching {
        repository.getImageByPostId(postId)
    }
}
