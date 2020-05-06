package indi.foreverzero.yuuki.plugins.api

/**
 * 系统加载完插件后首先调用此接口初始化
 */
interface PluginInitialize {
    /**
     * 初始化接口
     */
    fun init()
}