package com.ws.lru;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @program: lru
 * @description: 对LinkedHashMap的构造方法进行改进
 * @author: WangYx
 * @create: 2018/08/30
 */
public class LRUCache2<K,V> extends LinkedHashMap<K,V> {

    private static int MAX_CACHE_SIZE = 0;

    public LRUCache2(int cacheSize) {
        super((int) Math.ceil(cacheSize/0.75) + 1,0.75f,true);
        MAX_CACHE_SIZE = cacheSize;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return size() > MAX_CACHE_SIZE;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<K, V> entry : entrySet()) {
            sb.append(String.format("s%:s%",entry.getKey(),entry.getValue()));
        }
        return sb.toString();
    }
}