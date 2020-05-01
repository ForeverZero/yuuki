package indi.foreverzero.yuuki.core.event.entity

data class Sender(
        val userId: Int,
        val nickName: String?,
        val sex: Sex?,
        val age: Int?,
        val card: String?,
        val area: String?,
        val level: String?,
        val role: String?,
        val title: String?
)