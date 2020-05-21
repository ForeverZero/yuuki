package indi.foreverzero.yuuki.web.exception

class NotLoggedInException() : YuukiWebException("未登录") {
    override val ERROR_CODE = 1001
    override val ERROR_MSG = "未登录"
}