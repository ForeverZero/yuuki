package indi.foreverzero.yuuki.core.sender

interface MessageSender {
    /**
     * 向好友发送私聊，普通字符串
     */
    fun sendPrivateMessage(userId: Int, message: String): Int?
}