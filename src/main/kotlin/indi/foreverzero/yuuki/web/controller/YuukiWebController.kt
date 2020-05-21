package indi.foreverzero.yuuki.web.controller

import indi.foreverzero.yuuki.common.ResultDTO
import indi.foreverzero.yuuki.web.auth.Auth
import indi.foreverzero.yuuki.web.cache.WebCache
import indi.foreverzero.yuuki.web.service.IYuukiWebService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.ResponseBody
import javax.servlet.http.HttpServletRequest

@Controller
class YuukiWebController {

    @Autowired
    lateinit var webService: IYuukiWebService

    @ResponseBody
    @RequestMapping(value = ["login"], method = [RequestMethod.GET])
    fun login(@RequestParam code: String, req: HttpServletRequest): Any {
        webService.login(code, req)
        return ResultDTO<Any>(code)
    }

    @Auth
    @ResponseBody
    @RequestMapping(value = ["login/test"], method = [RequestMethod.GET])
    fun testLogin(req: HttpServletRequest): Any {
        val uuid = req.session.getAttribute("yuuki-uuid")
        val user = WebCache.loggedInUserCache[uuid]
        return if (user == null) {
            ResultDTO<Any>("not logged in")
        } else {
            ResultDTO(user)
        }
    }
}