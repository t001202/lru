package com.ws.lru;

import com.sun.org.apache.xerces.internal.util.SynchronizedSymbolTable;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/**
 * @program: lru
 * @description: 改造3
 * @author: WangYx
 * @create: 2018/08/30
 */
public class LRUCache3<K,V>{

    private static int MAX_CACHE_SIZE = 0;
    private final static float DEFAULT_LOAD_FACTOR = 0.75f;

    LinkedHashMap<K,V> map;

    public LRUCache3(int cacheSize) {
        MAX_CACHE_SIZE = cacheSize;
        int capacity = (int) Math.ceil(MAX_CACHE_SIZE / DEFAULT_LOAD_FACTOR) + 1;
        map = new LinkedHashMap<>(capacity,DEFAULT_LOAD_FACTOR,true);
    }

    public synchronized void put(K key,V value) {
        map.put(key, value);
    }

    protected boolean removeEldestEntry(Map.Entry<K,V> eldest) {
        return false;
    }

    public synchronized V get(K key) {
        return map.get(key);
    }

    public synchronized void remove(K key) {
        map.remove(key);
    }

    public synchronized Set<Map.Entry<K,V>> getAll() {
        return map.entrySet();
    }

    public synchronized int size() {
        return map.size();
    }
    public synchronized void clear() {
        map.clear();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<K, V> entry : map.entrySet()) {
            sb.append(String.format("s%:s%",entry.getKey(),entry.getValue()));
        }
        return sb.toString();
    }
}