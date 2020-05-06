package indi.foreverzero.yuuki.core.service.impl

import com.alibaba.fastjson.JSONObject
import indi.foreverzero.yuuki.core.event.converter.EventMessageConverter
import indi.foreverzero.yuuki.core.event.entity.PrivateMessageEvent
import indi.foreverzero.yuuki.core.im.ImProxy
import indi.foreverzero.yuuki.core.service.IEventNoticeService
import indi.foreverzero.yuuki.web.service.IYuukiWebService
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component

@Component
class EventNoticeServiceImpl : IEventNoticeService {

    val log: Logger = LoggerFactory.getLogger(this.javaClass)

    @Value("\${yuuki.host}")
    lateinit var selfHost: String

    @Autowired
    lateinit var converter: EventMessageConverter

    @Autowired
    lateinit var imProxy: ImProxy
    @Autowired
    lateinit var webService: IYuukiWebService

    override fun handleEvent(eventBody: String) {
        log.debug("接收到事件消息: {}", eventBody)
        val event = converter.convert(eventBody)
        log.info("事件: {}", JSONObject.toJSONString(event))

        // 处理登录登录
        // TODO 不够优雅
        if (event is PrivateMessageEvent && "登录" == event.message) {
            val code = webService.generateLoginCode(event.sender)
            val msg = "你的登录地址为: ${selfHost}/login?code=$code"
            imProxy.sendPrivateMessage(event.sender.userId, msg)
            return
        }
    }
}