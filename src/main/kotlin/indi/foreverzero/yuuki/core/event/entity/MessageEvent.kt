package indi.foreverzero.yuuki.core.event.entity

import java.time.LocalDateTime

abstract class MessageEvent(
        selfId: String,
        time: LocalDateTime,
        val sender: Sender,
        var message: String,
        var rawMessage: String,
        var subType: MessageSubType,
        var messageId: Int
) : Event(selfId, time)