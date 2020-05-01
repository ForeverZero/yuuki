package indi.foreverzero.yuuki.core.sender.entity

import com.fasterxml.jackson.annotation.JsonProperty

data class MessageBody(
        @JsonProperty("user_id")
        val userId: Int?,
        val message: String,
        @JsonProperty("auto_escape")
        val autoEscape: Boolean = false
)