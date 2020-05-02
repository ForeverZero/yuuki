package indi.foreverzero.yuuki.core.event.entity

import java.time.LocalDateTime

class DiscussMessageEvent(
        selfId: String,
        time: LocalDateTime,
        sender: Sender,
        message: String,
        rawMessage: String,
        subType: MessageSubType,
        messageId: Int,
        val discussId: Int
) : MessageEvent(
        selfId,
        time,
        sender,
        message,
        rawMessage,
        subType,
        messageId
)