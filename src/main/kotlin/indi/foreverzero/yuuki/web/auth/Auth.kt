package indi.foreverzero.yuuki.web.auth

import indi.foreverzero.yuuki.web.entity.Role

/**
 * 接口鉴权注解
 */
@MustBeDocumented
@kotlin.annotation.Retention(AnnotationRetention.RUNTIME)
@Target(AnnotationTarget.FUNCTION)
annotation class Auth {
    companion object {
        var reqRoles = arrayOfNulls<Role>(0)
    }
}