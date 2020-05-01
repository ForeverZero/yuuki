package indi.foreverzero.yuuki.core.event.entity

enum class SexEnum {
    MALE,
    FEMALE,
    UNKNOWN;

    companion object {
        fun parse(string: String): SexEnum {
            return when (string) {
                "male" -> MALE
                "female" -> FEMALE
                else -> UNKNOWN
            }
        }
    }
}