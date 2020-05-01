package indi.foreverzero.yuuki.core.event.entity

enum class Sex {
    MALE,
    FEMALE,
    UNKNOWN;

    companion object {
        fun parse(string: String): Sex {
            return when (string) {
                "male" -> MALE
                "female" -> FEMALE
                else -> UNKNOWN
            }
        }
    }
}