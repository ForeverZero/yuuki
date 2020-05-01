package indi.foreverzero.yuuki.core.event.entity

import indi.foreverzero.yuuki.core.event.entity.BaseEvent
import java.time.LocalDateTime

class PrivateChatMessage (selfId: String, time: LocalDateTime) : BaseEvent(selfId, time) {
    var message: String? = null
}