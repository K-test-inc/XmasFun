package com.accenture.internship.mapImpl;

import java.util.*;

public class HashMap<K, V> implements Map<K, V> {

    private static final int DEFAULT_CAPACITY = 16;
    private static final float DEFAULT_LOAD_FACTOR = 0.75f;
    private int size;
    private Node<K, V>[] table;
    private int capacity;

    public Node<K, V>[] getTable() {
        return table;
    }

    public HashMap() {
        this.size = 0;
        this.capacity = DEFAULT_CAPACITY;
        this.table = new Node[DEFAULT_CAPACITY];
    }

    public HashMap(int size, int capacity, Node<K, V>[] table) {
        this.size = size;
        this.capacity = capacity;
        this.table = table;
    }

    @Override
    public int hash(K key) {
        if (key == null)
            return 0;
        return (int) key.toString().charAt(0);
    }

    @Override
    public void put(K key, V value) {

        Node<K, V> node = new Node<>(key, value, null);
        boolean arrayIncreasing = false;
        int newCapacity = capacity;
        while (hash(key) >= newCapacity * DEFAULT_LOAD_FACTOR) {
            newCapacity *= 2;
            arrayIncreasing = true;
        }
        if (arrayIncreasing) {
            Node<K, V>[] newTable = new Node[newCapacity];
            System.arraycopy(table, 0, newTable, 0, table.length);
            capacity = newCapacity;
            table = newTable;
        }
        Node<K, V> currentNode = table[hash(key)];
        if (currentNode != null) {
            if (currentNode.getKey().equals(node.getKey())) {
                node.setNext(currentNode.getNext());
                table[hash(key)] = node;
            } else {
                while (currentNode.getNext() != null)
                    currentNode = currentNode.getNext();
                currentNode.setNext(node);
                size++;
            }
        } else {
            table[hash(key)] = node;
            size++;
        }

    }

    @Override
    public V get(K key) {
        try {
            Node<K, V> currentNode = table[hash(key)];
            if (currentNode == null)
                return null;
            else {
                if (Objects.equals(currentNode.getKey(), key))
                    return currentNode.getValue();
                else {
                    while (currentNode.getNext() != null) {
                        currentNode = currentNode.getNext();
                        if (currentNode.getKey().equals(key))
                            return currentNode.getValue();
                    }
                }
                return null;
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            return null;
        }
    }

    @Override
    public V remove(K key) {
        try {
            Node<K, V> currentNode = table[hash(key)];
            if (currentNode == null)
                return null;
            else {
                if (Objects.equals(currentNode.getKey(), key)) {
                    if (currentNode.getNext() != null) {
                        table[hash(key)] = currentNode.getNext();
                    } else {
                        table[hash(key)] = null;
                    }
                    size--;
                    return currentNode.getValue();
                } else {
                    while (currentNode.getNext() != null) {
                        Node prevNode = currentNode;
                        currentNode = currentNode.getNext();
                        if (currentNode.getKey().equals(key)) {
                            prevNode.setNext(currentNode.getNext());
                            currentNode.setNext(null);
                            size--;
                            return currentNode.getValue();
                        }
                    }
                }
            }
            return null;
        } catch (ArrayIndexOutOfBoundsException e) {
            return null;
        }

    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HashMap<?, ?> map = (HashMap<?, ?>) o;
        return size == map.size && capacity == map.capacity && Arrays.equals(table, map.table);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(size, capacity);
        result = 31 * result + Arrays.hashCode(table);
        return result;
    }
}
