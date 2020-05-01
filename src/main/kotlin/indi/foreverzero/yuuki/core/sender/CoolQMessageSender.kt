package indi.foreverzero.yuuki.core.sender

import indi.foreverzero.yuuki.core.sender.entity.MessageBody
import indi.foreverzero.yuuki.core.sender.entity.SendMessageResponse
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component
import org.springframework.web.client.RestTemplate

@Component
class CoolQMessageSender: MessageSender {

    val log: Logger = LoggerFactory.getLogger(this.javaClass)

    @Value("\${coolq.url}")
    lateinit var coolqUrl: String

    companion object PATH {
        const val SEND_PRIVATE_MSG = "/send_private_msg"
    }

    @Autowired
    lateinit var restTemplate: RestTemplate

    override fun sendPrivateMessage(userId: Int, message: String): Int? {
        log.info("向好友${userId}发送消息:\n$message")
        val url = coolqUrl + SEND_PRIVATE_MSG
        val msg = MessageBody(userId = userId, message = message)
        val response = restTemplate.postForObject(url, msg, SendMessageResponse::class.java)
        return response?.messageId
    }
}