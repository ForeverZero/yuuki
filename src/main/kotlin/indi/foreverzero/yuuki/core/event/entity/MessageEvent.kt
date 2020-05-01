package indi.foreverzero.yuuki.core.event.entity

import java.time.LocalDateTime

class MessageEvent(selfId: String, time: LocalDateTime, val sender: Sender): BaseEvent(selfId, time) {
    var message: String? = null
    var rawMessage: String? = null
    var type: MessageTypeEnum? = null
    var messageId: Int? = null
}