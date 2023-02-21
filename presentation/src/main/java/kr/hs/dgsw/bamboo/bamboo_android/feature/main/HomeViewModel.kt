package kr.hs.dgsw.bamboo.bamboo_android.feature.main

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kr.hs.dgsw.bamboo.domain.usecase.GetImageUseCase
import kr.hs.dgsw.bamboo.domain.usecase.GetPostListUseCase
import org.orbitmvi.orbit.ContainerHost
import org.orbitmvi.orbit.syntax.simple.intent
import org.orbitmvi.orbit.syntax.simple.reduce
import org.orbitmvi.orbit.viewmodel.container
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getPostListUseCase: GetPostListUseCase,
    private val getImageUseCase: GetImageUseCase
) : ContainerHost<HomeState, Unit>, ViewModel() {

    override val container = container<HomeState, Unit>(HomeState())

    fun getPostList() = intent {
        getPostListUseCase()
            .onSuccess {
                reduce {
                    state.copy(
                        postList = it
                    )
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

    fun getImage(postId: Long) = intent {
        getImageUseCase(postId)
            .onSuccess {
                reduce {
                    state.copy(
                        contentImage = it
                    )
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
}
