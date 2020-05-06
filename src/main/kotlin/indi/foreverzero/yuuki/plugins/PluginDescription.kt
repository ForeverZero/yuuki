package indi.foreverzero.yuuki.plugins

import indi.foreverzero.yuuki.plugins.api.PluginEntry

/**
 * 插件描述
 */
data class PluginDescription(
        val entry: PluginEntry,
        var active: Boolean,
        var priority: Int
)