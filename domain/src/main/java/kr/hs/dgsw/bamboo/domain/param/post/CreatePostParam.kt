package kr.hs.dgsw.bamboo.domain.param.post

data class CreatePostParam(
    val content: String,
    val hashTags: List<String>
)
