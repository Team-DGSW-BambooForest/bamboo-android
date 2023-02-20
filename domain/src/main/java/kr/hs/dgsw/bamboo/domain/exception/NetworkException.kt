package kr.hs.dgsw.bamboo.domain.exception

private const val NETWORK_EXCEPTION_MESSAGE = "네트워크 연결을 확인해 주세요."

class NoInternetException : Exception() {
    override val message: String
        get() = NETWORK_EXCEPTION_MESSAGE
}

class NoConnectivityException : Exception() {
    override val message: String
        get() = NETWORK_EXCEPTION_MESSAGE
}
