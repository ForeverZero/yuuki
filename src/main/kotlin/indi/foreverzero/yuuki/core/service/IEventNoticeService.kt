package indi.foreverzero.yuuki.core.service

interface IEventNoticeService {
    /**
     * 处理事件
     */
    fun handleEvent(eventBody: String)
}