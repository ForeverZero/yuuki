package indi.foreverzero.yuuki.core.event.entity

import java.time.LocalDateTime

class PrivateChatMessage (selfId: String, time: LocalDateTime) : Message(selfId, time)