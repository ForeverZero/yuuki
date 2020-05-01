package indi.foreverzero.yuuki.core.event

import com.alibaba.fastjson.JSONObject
import indi.foreverzero.yuuki.common.CommonUtils
import indi.foreverzero.yuuki.core.event.exception.EventMessageHandleException
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component

@Component
class CoolQEventHandler : EventMessageHandler {

    val log: Logger = LoggerFactory.getLogger(this.javaClass)

    override fun handle(eventBody: String): BaseEvent {
        val jsonData: JSONObject
        try {
            jsonData = JSONObject.parseObject(eventBody)
        } catch (e: Exception) {
            log.error("事件消息无法转为JSON对象", e)
            throw EventMessageHandleException(e.message, e)
        }

        val privateChatMessage = PrivateChatMessage(jsonData.getString("self_id"), CommonUtils.convertToLocalDateTime(jsonData.getLong("time") * 1000))
        privateChatMessage.message = "Hello World"
        return privateChatMessage
    }
}