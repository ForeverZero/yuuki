package indi.foreverzero.yuuki.core.event.exception

class EventMessageHandleException: Exception {
    constructor(): super()
    constructor(message: String?): super(message)
    constructor(message: String?, e: Throwable): super(message, e)
}