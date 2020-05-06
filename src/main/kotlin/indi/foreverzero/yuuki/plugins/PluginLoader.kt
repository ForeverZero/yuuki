package indi.foreverzero.yuuki.plugins

import indi.foreverzero.yuuki.plugins.api.PluginEntry
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.boot.ApplicationArguments
import org.springframework.boot.ApplicationRunner
import org.springframework.stereotype.Component

/**
 * 插件加载器
 */
@Component
class PluginLoader: ApplicationRunner {

    val log: Logger = LoggerFactory.getLogger(this.javaClass)
    companion object {
        /**
         * 新载入插件的默认优先级
         */
        const val DEFAULT_PLUGIN_PRIORITY = 999
    }

    /**
     * 系统启动后进行插件加载工作
     */
    override fun run(args: ApplicationArguments?) {
        log.info("开始加载插件")
        loadYkPlugin()
        loadExternalPlugin()
        PluginHolder.activePluginList.sortBy { it.priority }
        log.info("加载插件完成")
    }

    /**
     * 加载系统内置插件
     */
    fun loadYkPlugin() {
        //TODO
    }

    /**
     * 加载外部插件Jar包
     */
    fun loadExternalPlugin() {
        //TODO
    }

    /**
     * 加载插件的逻辑
     */
    fun loadPlugin(entry: PluginEntry) {
        val des = PluginDescription(
                entry = entry,
                //TODO 处理下面两项信息
                active = true,
                priority = 0
        )

        log.info("加载插件:${entry.id}, ${entry.name}, ${entry.version}")

        PluginHolder.allPluginMap[entry.id] = des
        if (des.active) {
            PluginHolder.activePluginList.add(des)
        }
    }
}