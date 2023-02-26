package kr.hs.dgsw.bamboo.bamboo_android.feature.create

import android.util.Log
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kr.hs.dgsw.bamboo.domain.exception.ExpiredRefreshTokenException
import kr.hs.dgsw.bamboo.domain.param.post.CreatePostParam
import kr.hs.dgsw.bamboo.domain.usecase.CreatePostUseCase
import org.orbitmvi.orbit.Container
import org.orbitmvi.orbit.ContainerHost
import org.orbitmvi.orbit.syntax.simple.intent
import org.orbitmvi.orbit.syntax.simple.postSideEffect
import org.orbitmvi.orbit.syntax.simple.reduce
import org.orbitmvi.orbit.viewmodel.container
import javax.inject.Inject

@HiltViewModel
class CreateViewModel @Inject constructor(
    private val createPostUseCase: CreatePostUseCase
) : ContainerHost<CreateState, CreateSideEffect>, ViewModel() {

    override val container = container<CreateState, CreateSideEffect>(CreateState())

    fun createPost(
        content: String,
        hashTags: List<String> = emptyList()
    ) = intent {
        createPostUseCase(
            CreatePostParam(
                content = content,
                hashTags = hashTags
            )
        )
            .onSuccess {
                postSideEffect(CreateSideEffect.Toast("게시물 등록을 성공했습니다!"))

                reduce {
                    state.copy(
                        postId = it
                    )
                }
            }
            .onFailure {
                reduce {
                    Log.d("ERROR", "createPost: ${it.message}")
                    state.copy(
                        exception = it
                    )
                }
            }
    }
}