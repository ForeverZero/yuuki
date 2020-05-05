package indi.foreverzero.yuuki.web.service.impl

import indi.foreverzero.yuuki.common.CommonUtils
import indi.foreverzero.yuuki.core.event.entity.Sender
import indi.foreverzero.yuuki.web.cache.WebCache
import indi.foreverzero.yuuki.web.entity.User
import indi.foreverzero.yuuki.web.exception.InvalidLoginCodeException
import indi.foreverzero.yuuki.web.service.IYuukiWebService
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component
import java.util.*
import javax.servlet.http.HttpServletRequest

@Component
class YuukiWebServiceImpl : IYuukiWebService {

    val log: Logger = LoggerFactory.getLogger(this.javaClass)

    override fun login(code: String, req: HttpServletRequest) {
        val sender = WebCache.loginCodeCache[code] ?: throw InvalidLoginCodeException(code)
        val user = User(
                userId = sender.userId,
                nickName = sender.nickName,
                sex = sender.sex,
                age = sender.age
        )
        val uuid = UUID.randomUUID().toString()
        req.session.setAttribute("yuuki-uuid", uuid)
        WebCache.loggedInUserCache[uuid] = user
        WebCache.loginCodeCache.remove(code)
        log.info("用户${user}登录了")
    }

    override fun generateLoginCode(sender: Sender): String {
        val code = CommonUtils.generateRandomString(16)
        log.info("QQ号：${sender.userId}, 昵称: ${sender.nickName} 请求登录, Code: $code")
        WebCache.loginCodeCache[code] = sender
        return code
    }
}