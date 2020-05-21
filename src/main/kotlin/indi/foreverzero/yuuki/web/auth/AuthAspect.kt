package indi.foreverzero.yuuki.web.auth

import indi.foreverzero.yuuki.web.cache.WebCache
import indi.foreverzero.yuuki.web.entity.User
import indi.foreverzero.yuuki.web.exception.NotLoggedInException
import org.aspectj.lang.ProceedingJoinPoint
import org.aspectj.lang.annotation.Around
import org.aspectj.lang.annotation.Aspect
import org.aspectj.lang.annotation.Pointcut
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component
import java.lang.Exception
import javax.servlet.http.HttpServletRequest

@Aspect
@Component
class AuthAspect {

    val log: Logger = LoggerFactory.getLogger(this.javaClass)

    @Pointcut("@annotation(indi.foreverzero.yuuki.web.auth.Auth)")
    fun auth() {}

    @Around("auth()")
    fun execute(pjp: ProceedingJoinPoint): Any {
        // 找出Req对象
        var req: HttpServletRequest? = null
        pjp.args.forEach {
            if (it is HttpServletRequest) {
                req = it
            }
        }

        // 没有Req
        if (req == null) {
            throw Exception("没有鉴权注解没有Req对象")
        }

        //检查UUID有效
        val uuid = req!!.session.getAttribute("yuuki-uuid")
                ?: throw NotLoggedInException()
        val user: User = WebCache.loggedInUserCache[uuid]
                ?: throw NotLoggedInException()

        // 有效
        val threadLocal = ThreadLocal<User>()
        threadLocal.set(user)
        return pjp.proceed()
    }
}