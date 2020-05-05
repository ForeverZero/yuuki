package indi.foreverzero.yuuki.web.exception

abstract class YuukiWebException(msg: String): Exception(msg) {
    abstract val ERROR_CODE: Int
    abstract val ERROR_MSG: String
}