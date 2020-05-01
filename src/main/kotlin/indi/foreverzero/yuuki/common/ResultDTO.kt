package indi.foreverzero.yuuki.common

data class ResultDTO<T>(
        var code: Int = 0,
        var message: String = "OK",
        var data: T? = null
)