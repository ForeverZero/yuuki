package indi.foreverzero.yuuki.core.controller

import com.alibaba.fastjson.JSONObject
import indi.foreverzero.yuuki.common.ResultDTO
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class EventNoticeController {

    val log: Logger = LoggerFactory.getLogger(this.javaClass)

    @PostMapping("yuuki/event")
    fun eventNotice(@RequestBody eventBody: String): Any {
        log.debug(eventBody)
        try {
            val jsonData = JSONObject.parse(eventBody)
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return ResultDTO<Any>()
    }
}