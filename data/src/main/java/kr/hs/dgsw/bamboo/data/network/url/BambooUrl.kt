package kr.hs.dgsw.bamboo.data.network.url

object BambooUrl {
    const val BASE_URL = "https://server.v1.daesoup.com/"

    const val POST = "post"
    const val UPLOAD = "upload"

    object Post {
        const val LIST = "$POST/list"
        const val CREATE = "$POST/create"
        const val SEARCH = "$POST/search/{word}"
    }

    object Upload {
        const val POST_ID = "$UPLOAD/{postId}"
    }
}
