package kr.hs.dgsw.bamboo.data.network.url

object BambooUrl {
<<<<<<< Updated upstream
    const val BASE_URL = "http://3.39.26.147:8081/"
=======
    const val BASE_URL = "http://3.39.26.147:8081"
>>>>>>> Stashed changes

    const val POST = "post"
    const val UPLOAD = "upload"
    const val COMMENT = "comment"

    object Post {
        const val LIST = "$POST/list"
        const val CREATE = "$POST/create"
    }

    object Upload {
        const val POST_ID = "$UPLOAD/{postId}"
    }

    object Comment {
        const val POST_ID = "$COMMENT/{post-id}"
    }
}
