package indi.foreverzero.yuuki.core.event

/**
 * 事件消息处理器接口
 */
interface EventMessageHandler {
    /**
     * 将接到的消息字符串转化为本服务定义的消息对象
     */
    fun handle(eventBody: String) : BaseEvent
}