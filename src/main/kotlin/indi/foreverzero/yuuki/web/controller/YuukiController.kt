package indi.foreverzero.yuuki.web.controller

import indi.foreverzero.yuuki.common.ResultDTO
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController

@RestController
class YuukiController {
    @RequestMapping(value = ["test"], method = [RequestMethod.GET])
    fun test(): Any {

        println("hello")
        println("123")
        return ResultDTO<Any>()
    }
}