package indi.foreverzero.yuuki.core.event.entity

import java.time.LocalDateTime

/**
 * 事件基类
 */
abstract class BaseEvent {

    constructor(selfId: String, time: LocalDateTime) {
        this.selfId = selfId
        this.time = time
    }

    /**
     * 自身ID，一般为QQ号
     */
    val selfId: String

    /**
     * 时间发生的时间
     */
    val time: LocalDateTime
}