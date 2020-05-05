package indi.foreverzero.yuuki.web.cache

import java.util.*

/**
 * LRU缓存
 */
class LruMap<K, V>(initialCapacity: Int, loadFactor: Float, accessOrder: Boolean, private val maxSize: Int) : LinkedHashMap<K, V>(initialCapacity, loadFactor, accessOrder) {

    constructor(maxSize: Int) : this(16, 0.75f, true, maxSize) {}
    constructor(tableSize: Int, maxSize: Int) : this(tableSize, 0.75f, true, maxSize) {}

    override fun removeEldestEntry(eldest: Map.Entry<K, V>): Boolean {
        val flag = size > maxSize
        if (flag) {
            println("移除头节点, key:" + eldest.key + ", value:" + eldest.value)
        }
        return flag
    }
}