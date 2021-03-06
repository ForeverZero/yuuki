package indi.foreverzero.yuuki.core.event.entity

enum class MessageSubType {
    FRIEND,
    GROUP,
    DISCUSS,
    NORMAL,
    ANONYMOUS,
    NOTICE,
    OTHER,
    ;

    companion object {
        fun parse(string: String): MessageSubType {
            return when (string) {
                "friend" -> FRIEND
                "group" -> GROUP
                "discuss" -> DISCUSS
                "normal" -> NORMAL
                "anonymous" -> ANONYMOUS
                "notice" -> NOTICE
                else -> OTHER
            }
        }
    }
}