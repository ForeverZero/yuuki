package indi.foreverzero.yuuki.core.event.entity

import java.time.LocalDateTime

class MessageEvent(selfId: String, time: LocalDateTime): BaseEvent(selfId, time) {
    var message: String? = null
    var rawMessage: String? = null
    var type: MessageTypeEnum? = null
    var messageId: Int? = null
    var sender: Sender? = null
}