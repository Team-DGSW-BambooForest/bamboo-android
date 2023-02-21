package kr.hs.dgsw.bamboo.domain.usecase

import kr.hs.dgsw.bamboo.domain.repository.UploadRepository
import javax.inject.Inject

class GetImageUseCase @Inject constructor(
    private val uploadRepository: UploadRepository
) {
    suspend operator fun invoke(postId: Long) = kotlin.runCatching {
        uploadRepository.getImageByPostId(postId)
    }
}