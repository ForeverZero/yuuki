package indi.foreverzero.yuuki.web.service

import indi.foreverzero.yuuki.core.event.entity.Sender
import javax.servlet.http.HttpServletRequest

interface IYuukiWebService {
    /**
     * 用户登录
     */
    fun login(code: String, req: HttpServletRequest)

    /**
     * 生成用户登录代码
     */
    fun generateLoginCode(sender: Sender): String
}