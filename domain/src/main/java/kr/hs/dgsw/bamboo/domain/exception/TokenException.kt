package kr.hs.dgsw.bamboo.domain.exception

private const val EXPIRED_REFRESH_TOKEN_MESSAGE = "토큰이 만료되어 로그인이 필요해요."
private const val NOT_FOUND_REFRESH_TOKEN_MESSAGE = "토큰이 없어 로그인이 필요해요."

class ExpiredRefreshTokenException : Exception() {
    override val message: String
        get() = EXPIRED_REFRESH_TOKEN_MESSAGE
}

class NotFoundRefreshTokenException : Exception() {
    override val message: String
        get() = NOT_FOUND_REFRESH_TOKEN_MESSAGE
}
