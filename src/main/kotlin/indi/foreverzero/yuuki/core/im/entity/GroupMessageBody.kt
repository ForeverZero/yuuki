package indi.foreverzero.yuuki.core.im.entity

import com.fasterxml.jackson.annotation.JsonProperty

data class GroupMessageBody(
        @JsonProperty("group_id")
        val groupId: Int?,
        val message: String,
        @JsonProperty("auto_escape")
        val autoEscape: Boolean = false
)