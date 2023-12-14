package com.accenture.internship.mapImpl;

public interface Map<K, V>{

    int hash(K key);
    void put(K key, V value);
    V get(K key);
    V remove(K key);
    int size();
    boolean isEmpty();
}
