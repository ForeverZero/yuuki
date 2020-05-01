package indi.foreverzero.yuuki.core.event

import java.time.LocalDateTime

class PrivateChatMessage (selfId: String, time: LocalDateTime) : BaseEvent(selfId, time) {
    var message: String? = null
}