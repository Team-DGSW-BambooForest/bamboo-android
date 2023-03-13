package kr.hs.dgsw.bamboo.data.network.url

object BambooUrl {
    const val BASE_URL = "http://3.39.26.147:8081/"

    const val POST = "post"
    const val UPLOAD = "upload"

    object Post {
        const val LIST = "$POST/list"
        const val CREATE = "$POST/create"
    }

    object Upload {
        const val POST_ID = "$UPLOAD/{postId}"
    }
}
