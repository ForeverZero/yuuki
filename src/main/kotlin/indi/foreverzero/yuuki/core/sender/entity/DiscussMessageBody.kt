package indi.foreverzero.yuuki.core.sender.entity

import com.fasterxml.jackson.annotation.JsonProperty

data class DiscussMessageBody(
        @JsonProperty("discuss_id")
        val discussId: Int?,
        val message: String,
        @JsonProperty("auto_escape")
        val autoEscape: Boolean = false
)