package kr.hs.dgsw.bamboo.data.network.url

object BambooUrl {
    const val BASE_URL = "http://13.209.33.18:8080/"

    const val POST = "post"
    const val UPLOAD = "upload"

    object Post {
        const val LIST = "$POST/list"
    }

    object Upload {
        const val POST_ID = "$UPLOAD{postId}"
    }
}
