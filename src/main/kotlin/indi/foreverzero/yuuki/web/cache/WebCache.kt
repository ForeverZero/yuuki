package indi.foreverzero.yuuki.web.cache

import indi.foreverzero.yuuki.core.event.entity.Sender
import indi.foreverzero.yuuki.web.entity.User

class WebCache {
    companion object {
        /**
         * 记录登录代码和Sender的关系
         */
        val loginCodeCache: LruMap<String, Sender> = LruMap(32)

        /**
         * 记录已登录用户
         */
        val loggedInUserCache: LruMap<String, User> = LruMap(32)
    }
}