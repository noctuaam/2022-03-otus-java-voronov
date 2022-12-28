package ru.otus.cachehw;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;

public class MyCache<K, V> implements HwCache<K, V> {
//Надо реализовать эти методы

    private final Map<K,V> cache = new WeakHashMap<>();
    private final List<HwListener<K, V>> listenerList = new ArrayList<>();

    @Override
    public void put(K key, V value) {
        cache.put(key, value);
        sendActionMessage(key,value,MyCacheAction.PUT.title);
    }

    @Override
    public void remove(K key) {
        cache.remove(key);
        sendActionMessage(key,null,MyCacheAction.REMOVE.title);
    }

    @Override
    public V get(K key) {
        sendActionMessage(key,null,MyCacheAction.GET.title);
        return cache.get(key);
    }

    @Override
    public void addListener(HwListener<K, V> listener) {
        listenerList.add(listener);
    }

    @Override
    public void removeListener(HwListener<K, V> listener) {
        listenerList.remove(listener);
    }

    private void sendActionMessage(K key, V value, String action) {
        for(var listener : listenerList) {
            try {
                listener.notify(key, value, action);
            } catch (Exception ignored) { }
        }
    }
}
