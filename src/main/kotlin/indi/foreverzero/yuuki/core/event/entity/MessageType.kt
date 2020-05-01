package indi.foreverzero.yuuki.core.event.entity

enum class MessageType {
    PRIVATE,
    GROUP,
    OTHER
    ;

    companion object {
        fun parse(string: String): MessageType {
            return when (string) {
                "private" -> PRIVATE
                "group" -> GROUP
                else -> OTHER
            }
        }
    }
}