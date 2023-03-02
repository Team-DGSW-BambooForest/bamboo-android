package kr.hs.dgsw.bamboo.domain.usecase

import kr.hs.dgsw.bamboo.domain.repository.UploadRepository
import okhttp3.MultipartBody
import javax.inject.Inject

class PostImageUseCase @Inject constructor(
    private val uploadRepository: UploadRepository
) {
    suspend operator fun invoke(postId: Long, image: MultipartBody.Part) = kotlin.runCatching {
        uploadRepository.postImage(postId, image)
    }
}