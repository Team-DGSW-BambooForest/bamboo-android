package kr.hs.dgsw.bamboo.bamboo_android.feature.create

import okhttp3.MultipartBody

data class CreateState(
    val postId: Long? = null,
    val contentImage: MultipartBody.Part? = null,
    val exception: Throwable? = null,
)

sealed class CreateSideEffect {
    object NavigateToHome : CreateSideEffect()
//    object SuccessCreateEvent : CreateSideEffect()
    data class Toast(val text: String) : CreateSideEffect()
}
