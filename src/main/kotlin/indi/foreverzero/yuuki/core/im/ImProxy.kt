package indi.foreverzero.yuuki.core.im

interface ImProxy {
    /**
     * 向好友发送私聊，普通字符串
     */
    fun sendPrivateMessage(userId: Int, message: String): Int?

    /**
     * 向群发送消息，普通字符串
     */
    fun sendGroupMessage(groupId: Int, message: String): Int?

    /**
     * 向讨论组发送消息，普通字符串
     */
    fun sendDiscussMessage(discussId: Int, message: String): Int?
}