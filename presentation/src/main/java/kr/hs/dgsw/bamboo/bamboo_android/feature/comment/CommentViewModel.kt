package kr.hs.dgsw.bamboo.bamboo_android.feature.comment

import android.util.Log
import android.util.LogPrinter
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import kr.hs.dgsw.bamboo.domain.usecase.GetCommentUseCase
import kr.hs.dgsw.bamboo.domain.usecase.GetPostByIdUseCase
import org.orbitmvi.orbit.ContainerHost
import org.orbitmvi.orbit.syntax.simple.intent
import org.orbitmvi.orbit.syntax.simple.reduce
import org.orbitmvi.orbit.viewmodel.container
import javax.inject.Inject

@HiltViewModel
class CommentViewModel @Inject constructor(
    private val getCommentUseCase: GetCommentUseCase,
    private val getPostByIdUseCase: GetPostByIdUseCase
) : ContainerHost<CommentState, Unit>, ViewModel() {

    override val container = container<CommentState, Unit>(CommentState()) //

    private val _postId = MutableStateFlow(0L)
    private val postId: StateFlow<Long> = _postId.asStateFlow()

    init {
        viewModelScope.launch {
            postId.collectLatest {
                getPostById(it)
            }
        }
    }

    fun setPostId(postId: Long) = viewModelScope.launch {
        _postId.emit(postId)
    }

    fun getCommentList(postId: Long) = intent {
        getCommentUseCase(postId)
            .onSuccess { comment ->
                reduce {
                    state.copy(
                        comments = comment
                    )
                }
            }
            .onFailure {
                Log.d("ERROR", "getCommentList: ${it.message}")
                reduce {
                    state.copy(
                        exception = it
                    )
                }
            }
    }

    fun getPostById(postId: Long) = intent {
        getPostByIdUseCase(postId)
            .onSuccess { post ->
                reduce {
                    state.copy(
                        post = post
                    )
                }
            }
            .onFailure {
                Log.d("ERROR", "getCommentList: ${it.message}")
                reduce {
                    state.copy(
                        exception = it
                    )
                }
            }
    }

}