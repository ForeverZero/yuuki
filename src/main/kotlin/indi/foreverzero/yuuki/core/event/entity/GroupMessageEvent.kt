package indi.foreverzero.yuuki.core.event.entity

import java.time.LocalDateTime

class GroupMessageEvent(
        selfId: String,
        time: LocalDateTime,
        sender: Sender,
        message: String,
        rawMessage: String,
        subType: MessageSubType,
        messageId: Int,
        val groupId: Int
) : MessageEvent(
        selfId,
        time,
        sender,
        message,
        rawMessage,
        subType,
        messageId
) {
    var anonymous: Anonymous? = null
}