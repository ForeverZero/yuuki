package indi.foreverzero.yuuki.plugins.api

import indi.foreverzero.yuuki.core.event.entity.Event

/**
 * 事件通知接口
 */
interface EventNotice {
    /**
     * 事件处理接口
     */
    fun handleEvent(event: Event)
}