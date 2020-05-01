package indi.foreverzero.yuuki.core.event.entity

enum class MessageTypeEnum {
    FRIEND,
    GROUP,
    DISCUSS,
    OTHER;

    companion object {
        fun parse(string: String): MessageTypeEnum {
            return when (string) {
                "friend" -> FRIEND
                "group" -> GROUP
                "discuss" -> DISCUSS
                else -> OTHER
            }
        }
    }
}