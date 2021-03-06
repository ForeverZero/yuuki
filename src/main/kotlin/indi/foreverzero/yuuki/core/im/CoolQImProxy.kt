package indi.foreverzero.yuuki.core.im

import indi.foreverzero.yuuki.core.im.entity.DiscussMessageBody
import indi.foreverzero.yuuki.core.im.entity.GroupMessageBody
import indi.foreverzero.yuuki.core.im.entity.PrivateMessageBody
import indi.foreverzero.yuuki.core.im.entity.SendMessageResponse
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component
import org.springframework.web.client.RestTemplate

@Component
class CoolQImProxy: ImProxy {

    val log: Logger = LoggerFactory.getLogger(this.javaClass)

    @Value("\${coolq.url}")
    lateinit var coolqUrl: String

    companion object PATH {
        const val SEND_PRIVATE_MSG = "/send_private_msg"
        const val SEND_GROUP_MSG = "/send_group_msg"
        const val SEND_DISCUSS_MSG = "/send_discuss_msg"
    }

    @Autowired
    lateinit var restTemplate: RestTemplate

    override fun sendPrivateMessage(userId: Int, message: String): Int? {
        log.info("向好友${userId}发送消息:\n$message")
        val url = coolqUrl + SEND_PRIVATE_MSG
        val msg = PrivateMessageBody(userId = userId, message = message)
        val response = restTemplate.postForObject(url, msg, SendMessageResponse::class.java)
        return response?.messageId
    }

    override fun sendGroupMessage(groupId: Int, message: String): Int? {
        log.info("向群${groupId}发送消息:\n$message")
        val url = coolqUrl + SEND_GROUP_MSG
        val msg = GroupMessageBody(groupId = groupId, message = message)
        val response = restTemplate.postForObject(url, msg, SendMessageResponse::class.java)
        return response?.messageId
    }

    override fun sendDiscussMessage(discussId: Int, message: String): Int? {
        log.info("向讨论组${discussId}发送消息:\n$message")
        val url = coolqUrl + SEND_DISCUSS_MSG
        val msg = DiscussMessageBody(discussId = discussId, message = message)
        val response = restTemplate.postForObject(url, msg, SendMessageResponse::class.java)
        return response?.messageId
    }
}