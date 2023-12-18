package com.accenture.internship.bst;

import lombok.*;

import java.util.*;

@Data

@NoArgsConstructor
public class Node<K, V> {

    private K key;
    private V value;
    private Node<K, V> left;
    private Node<K, V> right;


    public Node(K key, V value) {
        this.key = key;
        this.value = value;
        this.left = null;
        this.right = null;

    }

    public Node(K key, V value, Node<K, V> left, Node<K, V> right) {
        this.key = key;
        this.value = value;
        this.left = left;
        this.right = right;

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node<?, ?> node = (Node<?, ?>) o;
        return Objects.equals(key, node.key) && Objects.equals(value, node.value) && Objects.equals(left, node.left) && Objects.equals(right, node.right);
    }

    @Override
    public int hashCode() {
        return Objects.hash(key, value, left, right);
    }
}


