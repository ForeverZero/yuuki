package indi.foreverzero.yuuki.core.event.exception

open class EventMessageHandleException: Exception {
    constructor(): super()
    constructor(message: String?): super(message)
    constructor(message: String?, e: Throwable): super(message, e)
}