package kr.hs.dgsw.bamboo.data.util

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import kr.hs.dgsw.bamboo.domain.exception.BadRequestException
import kr.hs.dgsw.bamboo.domain.exception.ConflictException
import kr.hs.dgsw.bamboo.domain.exception.ExpiredRefreshTokenException
import kr.hs.dgsw.bamboo.domain.exception.ForbiddenException
import kr.hs.dgsw.bamboo.domain.exception.NoConnectivityException
import kr.hs.dgsw.bamboo.domain.exception.NoInternetException
import kr.hs.dgsw.bamboo.domain.exception.NotFoundException
import kr.hs.dgsw.bamboo.domain.exception.OtherHttpException
import kr.hs.dgsw.bamboo.domain.exception.ServerException
import kr.hs.dgsw.bamboo.domain.exception.TimeOutException
import kr.hs.dgsw.bamboo.domain.exception.TooManyRequestsException
import kr.hs.dgsw.bamboo.domain.exception.UnAuthorizedException
import kr.hs.dgsw.bamboo.domain.exception.UnknownException
import retrofit2.HttpException
import java.net.SocketTimeoutException
import java.net.UnknownHostException

const val EXPIRED_TOKEN_MESSAGE = "토큰이 입력되지 않았습니다."
const val UNKNOWN_ERROR_MESSAGE = "알 수 없는 오류가 발생했습니다."

suspend inline fun <T> safeApiCall(
    crossinline apiCall: suspend () -> T,
): T {
    return try {
        withContext(Dispatchers.IO) {
            apiCall.invoke()
        }
    } catch (e: HttpException) {
        val message = e.message()

        throw when (e.code()) {
            400 -> BadRequestException(message)
            401 -> if (message == EXPIRED_TOKEN_MESSAGE)
                ExpiredRefreshTokenException()
            else
                UnAuthorizedException(message)
            403 -> ForbiddenException(message)
            404 -> NotFoundException(message)
            408 -> TimeOutException(message)
            409 -> ConflictException(message)
            429 -> TooManyRequestsException(message)
            500, 501, 502, 503 -> ServerException(message)
            else -> OtherHttpException(e.code(), message)
        }
    } catch (e: UnknownHostException) {
        throw NoInternetException()
    } catch (e: SocketTimeoutException) {
        throw TimeOutException(e.message)
    } catch (e: ExpiredRefreshTokenException) {
        throw e
    } catch (e: NoInternetException) {
        throw NoInternetException()
    } catch (e: NoConnectivityException) {
        throw NoConnectivityException()
    } catch (e: Exception) {
        throw UnknownException(e.message)
    }
}
