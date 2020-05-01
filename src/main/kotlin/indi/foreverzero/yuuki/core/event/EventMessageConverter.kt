package indi.foreverzero.yuuki.core.event

import indi.foreverzero.yuuki.core.event.entity.BaseEvent

/**
 * 事件消息字符串转化接口
 */
interface EventMessageConverter {
    /**
     * 将接到的消息字符串转化为本服务定义的消息对象
     */
    fun convert(eventBody: String) : BaseEvent
}