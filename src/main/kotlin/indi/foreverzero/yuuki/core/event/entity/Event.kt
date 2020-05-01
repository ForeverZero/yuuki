package indi.foreverzero.yuuki.core.event.entity

import java.time.LocalDateTime

/**
 * 事件基类
 */
abstract class Event {

    constructor(selfId: String, time: LocalDateTime) {
        this.selfId = selfId
        this.time = time
    }

    /**
     * 自身QQ号
     */
    val selfId: String

    /**
     * 事件发生的时间
     */
    val time: LocalDateTime
}