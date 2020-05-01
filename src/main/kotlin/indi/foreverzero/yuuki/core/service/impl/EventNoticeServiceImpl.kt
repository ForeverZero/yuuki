package indi.foreverzero.yuuki.core.service.impl

import com.alibaba.fastjson.JSONObject
import indi.foreverzero.yuuki.core.event.EventMessageHandler
import indi.foreverzero.yuuki.core.service.IEventNoticeService
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class EventNoticeServiceImpl : IEventNoticeService {

    val log: Logger = LoggerFactory.getLogger(this.javaClass)

    @Autowired
    lateinit var handler: EventMessageHandler

    override fun handleEvent(eventBody: String) {
        log.debug("接收到事件消息: {}", eventBody)

        val event = handler.handle(eventBody)
        println(JSONObject.toJSONString(event))
    }
}