package indi.foreverzero.yuuki.core.im.entity

import com.fasterxml.jackson.annotation.JsonProperty

data class PrivateMessageBody(
        @JsonProperty("user_id")
        val userId: Int?,
        val message: String,
        @JsonProperty("auto_escape")
        val autoEscape: Boolean = false
)