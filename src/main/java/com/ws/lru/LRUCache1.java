package com.ws.lru;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: lru
 * @description: 链表时间map
 * @author: WangYx
 * @create: 2018/08/30
 */
public class LRUCache1<K,V> {
    private static int MAX_CACHE_SIZE = 0;
    private Map.Entry first;
    private Map.Entry last;
    private HashMap<K, Map.Entry<K,V>> hashMap;

    public LRUCache1(int cacheSize) {
        MAX_CACHE_SIZE = cacheSize;
        hashMap = new HashMap<K, Map.Entry<K,V>>();
    }
    public void put(K key,V value) {
        Map.Entry entry = getEntry(key);
        if (entry != null) {
            if (hashMap.size() >= MAX_CACHE_SIZE) {
                hashMap.remove(last.getKey());
                removeLast();
            }
        }
    }

    private Map.Entry<K,V> getEntry(K key) {
        return hashMap.get(key);
    }

    private void removeLast() {
        if (last != null) {
            last = last;
        }
    }
}