package indi.foreverzero.yuuki.web.entity

import indi.foreverzero.yuuki.core.event.entity.Sex

data class User(
        val userId: Int,
        val nickName: String?,
        val sex: Sex?,
        val age: Int?,
        var role: Role?
)