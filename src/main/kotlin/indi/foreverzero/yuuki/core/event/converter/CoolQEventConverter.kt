package indi.foreverzero.yuuki.core.event.converter

import com.alibaba.fastjson.JSONObject
import indi.foreverzero.yuuki.common.CommonUtils
import indi.foreverzero.yuuki.core.event.entity.*
import indi.foreverzero.yuuki.core.event.exception.EventMessageHandleException
import indi.foreverzero.yuuki.core.event.exception.UnknownMessageTypeException
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component

@Component
class CoolQEventConverter : EventMessageConverter {

    val log: Logger = LoggerFactory.getLogger(this.javaClass)

    override fun convert(eventBody: String): Event {
        val jsonData: JSONObject
        try {
            jsonData = JSONObject.parseObject(eventBody)
        } catch (e: Exception) {
            log.error("事件消息无法转为JSON对象", e)
            throw EventMessageHandleException(e.message, e)
        }

        return when (val postType = jsonData.getString("post_type")) {
            "message" -> convertMessage(jsonData)
            else -> throw EventMessageHandleException("无法识别的post_type: $postType")
        }
    }

    /**
     * 转化Message对象
     */
    fun convertMessage(jsonData: JSONObject): MessageEvent {
        return when (val messageType = jsonData.getString("message_type")) {
            "private" -> convertPrivateMessage(jsonData)
            "group" -> convertGroupMessage(jsonData)
            else -> throw UnknownMessageTypeException("无法识别的message_type: $messageType")
        }
    }

    /**
     * 转化私聊消息
     */
    fun convertPrivateMessage(jsonData: JSONObject): PrivateMessageEvent {
        return PrivateMessageEvent(
                selfId = jsonData.getString("self_id"),
                time = CommonUtils.convertToLocalDateTime(jsonData.getLong("time") * 1000),
                sender = convertSender(jsonData.getJSONObject("sender")),
                message = jsonData.getString("message"),
                rawMessage = jsonData.getString("raw_message"),
                subType = MessageSubType.parse(jsonData.getString("sub_type")),
                messageId = jsonData.getIntValue("message_id")
        )
    }

    /**
     * 转化群聊消息对象
     */
    fun convertGroupMessage(jsonData: JSONObject): GroupMessageEvent {
        val groupMessageEvent = GroupMessageEvent(
                selfId = jsonData.getString("self_id"),
                time = CommonUtils.convertToLocalDateTime(jsonData.getLong("time") * 1000),
                sender = convertSender(jsonData.getJSONObject("sender")),
                message = jsonData.getString("message"),
                rawMessage = jsonData.getString("raw_message"),
                subType = MessageSubType.parse(jsonData.getString("sub_type")),
                messageId = jsonData.getIntValue("message_id"),
                groupId = jsonData.getIntValue("group_id")
        )

        // 非匿名聊天该对象为空
        val anonymousJson = jsonData.getJSONObject("anonymous")
        if (anonymousJson != null) {
            groupMessageEvent.anonymous = convertAnonymous(anonymousJson)
        }
        return groupMessageEvent
    }

    /**
     * 转化发送者对象
     */
    fun convertSender(senderJson: JSONObject): Sender {
        return Sender(
                userId = senderJson.getIntValue("user_id"),
                nickName = senderJson.getString("nickname"),
                sex = Sex.parse(senderJson.getString("sex")),
                age = senderJson.getIntValue("age"),
                card = senderJson.getString("card"),
                area = senderJson.getString("area"),
                level = senderJson.getString("level"),
                role = senderJson.getString("role"),
                title = senderJson.getString("title")
        )
    }

    /**
     * 转化匿名用户对象
     */
    fun convertAnonymous(jsonData: JSONObject): Anonymous {
        return Anonymous(
                id = jsonData.getIntValue("id"),
                name = jsonData.getString("name"),
                flag = jsonData.getString("flag")
        )
    }
}