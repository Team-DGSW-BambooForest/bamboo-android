package kr.hs.dgsw.bamboo.bamboo_android.feature.home

import android.util.Log
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kr.hs.dgsw.bamboo.bamboo_android.base.BaseViewModel
import kr.hs.dgsw.bamboo.domain.entity.post.PostList
import kr.hs.dgsw.bamboo.domain.usecase.GetImageUseCase
import kr.hs.dgsw.bamboo.domain.usecase.GetPostListUseCase
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getPostListUseCase: GetPostListUseCase,
    private val getImageUseCase: GetImageUseCase
) : BaseViewModel() {

    init {
        getPostList()
    }

    data class State(
        val postList: PostList? = null,
        val contentImage: String? = null,
    )

    private val _state: MutableStateFlow<State> = MutableStateFlow(State())
    val state: StateFlow<State> = _state.asStateFlow()

    private fun getPostList() = viewModelScope.launch {
        _loading.value = true

        getPostListUseCase()
            .onSuccess { postList ->
                _loading.value = false
                _state.update { state ->
                    state.copy(postList = postList)
                }
            }
            .onFailure {
                _loading.value = false
                _error.value = it.message ?: "게시물을 불러오지 못하였습니다."
            }
    }

    fun getImage(postId: Long) = viewModelScope.launch {
        _loading.value = true

        getImageUseCase(postId)
            .onSuccess { imageUrl ->
                _loading.value = false
                _state.update { state ->
                    state.copy(contentImage = imageUrl)
                }
            }
            .onFailure {
                _loading.value = false
                _error.value = it.message ?: "이미지를 불러오지 못하였습니다."
            }
    }
}