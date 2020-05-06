package indi.foreverzero.yuuki.plugins

import indi.foreverzero.yuuki.plugins.api.PluginEntry

/**
 * 保存插件信息
 */
class PluginHolder {
    companion object {
        /**
         * 生效的插件列表
         */
        val activePluginList = ArrayList<PluginDescription>()

        /**
         * 所有已加载的插件
         */
        val allPluginMap = HashMap<String, PluginDescription>()
    }
}