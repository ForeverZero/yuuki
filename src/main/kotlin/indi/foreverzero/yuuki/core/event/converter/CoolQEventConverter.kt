package indi.foreverzero.yuuki.core.event.converter

import com.alibaba.fastjson.JSONObject
import indi.foreverzero.yuuki.common.CommonUtils
import indi.foreverzero.yuuki.core.event.entity.*
import indi.foreverzero.yuuki.core.event.exception.EventMessageHandleException
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component

@Component
class CoolQEventConverter : EventMessageConverter {

    val log: Logger = LoggerFactory.getLogger(this.javaClass)

    override fun convert(eventBody: String): BaseEvent {
        val jsonData: JSONObject
        try {
            jsonData = JSONObject.parseObject(eventBody)
        } catch (e: Exception) {
            log.error("事件消息无法转为JSON对象", e)
            throw EventMessageHandleException(e.message, e)
        }

        return when (jsonData.getString("post_type")) {
            "message" -> convertMessage(jsonData)
            else -> throw EventMessageHandleException("无法识别的post_type")
        }
    }

    /**
     * 转化Message对象
     */
    fun convertMessage(jsonData: JSONObject): Message {
        return when (jsonData.getString("message_type")) {
            "private" -> convertPrivateChatMessage(jsonData)
            else -> throw EventMessageHandleException("无法识别的message_type")
        }
    }

    /**
     * 转化私聊消息对象
     */
    fun convertPrivateChatMessage(jsonData: JSONObject): PrivateChatMessage {
        val privateChatMessage = PrivateChatMessage(jsonData.getString("self_id"), CommonUtils.convertToLocalDateTime(jsonData.getLong("time") * 1000))
        privateChatMessage.message = jsonData.getString("message")
        privateChatMessage.rawMessage = jsonData.getString("rawMessage")
        privateChatMessage.type = MessageTypeEnum.parse(jsonData.getString("sub_type"))
        privateChatMessage.messageId = jsonData.getIntValue("messageId")
        privateChatMessage.sender = convertSender(jsonData.getJSONObject("sender"))

        return privateChatMessage
    }

    /**
     * 转化发送者对象
     */
    fun convertSender(senderJson: JSONObject): Sender {
        return Sender(
                userId = senderJson.getIntValue("user_id"),
                nickName = senderJson.getString("nickname"),
                sex = SexEnum.parse(senderJson.getString("sex")),
                age = senderJson.getIntValue("age")
        )
    }
}