package indi.foreverzero.yuuki.common

import java.time.Instant
import java.time.LocalDateTime
import java.time.ZoneId
import java.util.*

class CommonUtils {
    companion object {
        /**
         * 将时间戳转为LocalDateTime对象
         */
        fun convertToLocalDateTime(timestamp: Long): LocalDateTime {
            val instant = Instant.ofEpochMilli(timestamp);
            val zone = ZoneId.systemDefault();
            return LocalDateTime.ofInstant(instant, zone);
        }

        /**
         * 生成指定长度随机字符串
         */
        fun generateRandomString(length: Int): String {
            val str = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789"
            val random = Random()
            val sb = StringBuffer()
            for (i in 0 until length) {
                val number: Int = random.nextInt(62)
                sb.append(str[number])
            }
            return sb.toString()
        }
    }
}