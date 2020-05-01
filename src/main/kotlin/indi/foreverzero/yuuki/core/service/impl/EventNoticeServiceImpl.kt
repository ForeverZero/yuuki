package indi.foreverzero.yuuki.core.service.impl

import com.alibaba.fastjson.JSONObject
import indi.foreverzero.yuuki.core.event.converter.EventMessageConverter
import indi.foreverzero.yuuki.core.event.entity.MessageEvent
import indi.foreverzero.yuuki.core.event.entity.MessageTypeEnum
import indi.foreverzero.yuuki.core.sender.MessageSender
import indi.foreverzero.yuuki.core.service.IEventNoticeService
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class EventNoticeServiceImpl : IEventNoticeService {

    val log: Logger = LoggerFactory.getLogger(this.javaClass)

    @Autowired
    lateinit var converter: EventMessageConverter
    @Autowired
    lateinit var messageSender: MessageSender

    override fun handleEvent(eventBody: String) {
        log.debug("接收到事件消息: {}", eventBody)
        val event = converter.convert(eventBody)
        log.info("事件: {}", JSONObject.toJSONString(event))

        if (event is MessageEvent && event.type == MessageTypeEnum.FRIEND) {
            val msg = "${event.sender.nickName} 说:\n${event.message}"
            messageSender.sendPrivateMessage(event.sender.userId, msg)
        }
    }
}