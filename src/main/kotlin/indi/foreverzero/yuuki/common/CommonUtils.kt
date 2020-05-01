package indi.foreverzero.yuuki.common

import java.time.Instant
import java.time.LocalDateTime
import java.time.ZoneId

class CommonUtils {
    companion object {
        fun convertToLocalDateTime(timestamp: Long): LocalDateTime {
            val instant = Instant.ofEpochMilli(timestamp);
            val zone = ZoneId.systemDefault();
            return LocalDateTime.ofInstant(instant, zone);
        }
    }
}