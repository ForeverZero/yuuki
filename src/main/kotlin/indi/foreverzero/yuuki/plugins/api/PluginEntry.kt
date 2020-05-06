package indi.foreverzero.yuuki.plugins.api

/**
 * 插件入口
 */
abstract class PluginEntry {
    /**
     * 插件ID，每个插件都应该定义一个唯一ID
     */
    abstract val id: String

    /**
     * 插件名称
     */
    abstract val name: String

    /**
     * 插件版本
     */
    abstract val version: String
}