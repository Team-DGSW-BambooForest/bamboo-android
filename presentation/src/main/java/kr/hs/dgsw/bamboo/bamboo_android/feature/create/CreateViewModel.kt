package kr.hs.dgsw.bamboo.bamboo_android.feature.create

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kr.hs.dgsw.bamboo.domain.param.post.CreatePostParam
import kr.hs.dgsw.bamboo.domain.usecase.CreatePostUseCase
import kr.hs.dgsw.bamboo.domain.usecase.PostImageUseCase
import okhttp3.MultipartBody
import org.orbitmvi.orbit.ContainerHost
import org.orbitmvi.orbit.syntax.simple.intent
import org.orbitmvi.orbit.syntax.simple.postSideEffect
import org.orbitmvi.orbit.syntax.simple.reduce
import org.orbitmvi.orbit.viewmodel.container
import javax.inject.Inject

@HiltViewModel
class CreateViewModel @Inject constructor(
    private val createPostUseCase: CreatePostUseCase,
    private val postImageUseCase: PostImageUseCase,
) : ContainerHost<CreateState, CreateSideEffect>, ViewModel() {

    override val container = container<CreateState, CreateSideEffect>(CreateState())

    fun createPost(
        content: String,
        image: MultipartBody.Part? = null,
    ) = intent {
        createPostUseCase(CreatePostParam(content))
            .onSuccess { postId ->
                postSideEffect(CreateSideEffect.Toast("게시물 등록을 성공했습니다!"))
                postSideEffect(CreateSideEffect.NavigateToHome)

                image?.let { image ->
                    postImage(postId, image)
                }
            }
            .onFailure {
                reduce {
                    state.copy(
                        exception = it
                    )
                }
            }
    }

    private fun postImage(
        postId: Long,
        image: MultipartBody.Part,
    ) = intent {
        postImageUseCase(postId, image)
            .onSuccess {
                reduce {
                    state.copy(
                        contentImage = image
                    )
                }
            }
            .onFailure {
                postSideEffect(CreateSideEffect.Toast("이미지 등록을 실패했습니다."))
                reduce {
                    state.copy(
                        exception = it
                    )
                }
            }
    }
}
