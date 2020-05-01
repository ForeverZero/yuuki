package indi.foreverzero.yuuki.core.event.entity

data class Sender(
        val userId: Int,
        val nickName: String?,
        val sex: SexEnum?,
        val age: Int?
)