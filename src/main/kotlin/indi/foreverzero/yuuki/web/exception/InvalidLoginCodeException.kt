package indi.foreverzero.yuuki.web.exception

class InvalidLoginCodeException(code: String) : YuukiWebException(code) {
    override val ERROR_CODE = 1000
    override val ERROR_MSG = "无效的登录代码: $code"
}