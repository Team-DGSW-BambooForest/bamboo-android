package kr.hs.dgsw.bamboo.bamboo_android.feature.create

data class CreateState(
    val postId: Long? = null,
    val contentImage: String? = null,
    val exception: Throwable? = null,
)

sealed class CreateSideEffect {
    object NavigateToHome : CreateSideEffect()
    data class Toast(val text: String) : CreateSideEffect()
}

