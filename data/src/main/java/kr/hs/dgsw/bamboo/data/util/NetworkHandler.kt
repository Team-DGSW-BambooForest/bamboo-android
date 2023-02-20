package kr.hs.dgsw.bamboo.data.util

import com.google.gson.Gson
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import kr.hs.dgsw.bamboo.domain.exception.*
import retrofit2.HttpException
import java.net.SocketTimeoutException
import java.net.UnknownHostException

const val EXPIRED_TOKEN_MESSAGE = "토큰이 입력되지 않았습니다."

suspend inline fun <T> handleNetwork(
    crossinline function: suspend () -> T,
): T {
    return try {
        withContext(Dispatchers.IO) {
            function()
        }
    } catch (e: HttpException) {
        throw when (e.code()) {
            400 -> BadRequestException(e.message())
            401 -> if (e.message == EXPIRED_TOKEN_MESSAGE)
                ExpiredRefreshTokenException()
            else
                UnAuthorizedException(e.message())
            403 -> ForbiddenException(e.message())
            404 -> NotFoundException(e.message(),)
            408 -> TimeOutException(e.message())
            409 -> ConflictException(e.message())
            429 -> TooManyRequestsException(e.message())
            500, 501, 502, 503 -> ServerException(e.message())
            else -> OtherHttpException(e.code(), e.message())
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
