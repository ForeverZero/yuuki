package indi.foreverzero.yuuki.web

import indi.foreverzero.yuuki.web.entity.User

class WebUtils {
    companion object {
        /**
         * 获取当前登录的用户
         */
        fun getCurrentUser(): User {
            return ThreadLocal<User>().get()
        }
    }
}