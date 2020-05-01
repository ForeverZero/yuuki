package indi.foreverzero.yuuki.core.controller

import indi.foreverzero.yuuki.common.ResultDTO
import indi.foreverzero.yuuki.core.service.IEventNoticeService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class EventNoticeController {

    @Autowired
    lateinit var service: IEventNoticeService

    @PostMapping("event")
    fun eventNotice(@RequestBody eventBody: String): Any {
        service.handleEvent(eventBody)
        return ResultDTO<Any>()
    }
}