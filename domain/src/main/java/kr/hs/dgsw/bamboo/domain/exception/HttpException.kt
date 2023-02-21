package kr.hs.dgsw.bamboo.domain.exception

class BadRequestException(
    override val message: String?,
) : Exception()

class UnAuthorizedException(
    override val message: String?,
) : Exception()

class ForbiddenException(
    override val message: String?
) : Exception()

class NotFoundException(
    override val message: String?,
) : Exception()

class TimeOutException(
    override val message: String?
) : Exception()

class ConflictException(
    override val message: String?
) : Exception()

class TooManyRequestsException(
    override val message: String?
) : Exception()

class ServerException(
    override val message: String?
) : Exception()

class UnknownException(
    override val message: String?,
) : Exception()

class OtherHttpException(
    val code: Int,
    override val message: String?,
) : Exception()
