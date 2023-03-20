package kr.hs.dgsw.bamboo.bamboo_android.feature.comment

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
<<<<<<< HEAD
import dagger.hilt.android.lifecycle.HiltViewModel
=======
>>>>>>> #2_comment_screen
import kr.hs.dgsw.bamboo.domain.usecase.GetCommentUseCase
import org.orbitmvi.orbit.ContainerHost
import org.orbitmvi.orbit.syntax.simple.intent
import org.orbitmvi.orbit.syntax.simple.reduce
import org.orbitmvi.orbit.viewmodel.container
import javax.inject.Inject

<<<<<<< HEAD
@HiltViewModel
=======
>>>>>>> #2_comment_screen
class CommentViewModel @Inject constructor(
    private val getCommentUseCase: GetCommentUseCase,
) : ContainerHost<CommentState, Unit>, ViewModel() {

    override val container = container<CommentState, Unit>(CommentState())

    //Todo("함수를 어떤식으로 호출해야되는 거지? id를 받게 되면 하나의 comment만 들고 오는 것이 아닌가?")
    init {
//        getCommentList(postId = container.stateFlow.value.postId!!.toLong())  //?
    }

    private fun getCommentList(postId: Long) = intent {
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
}