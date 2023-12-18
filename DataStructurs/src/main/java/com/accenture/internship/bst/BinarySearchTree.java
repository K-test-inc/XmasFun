package com.accenture.internship.bst;

public interface BinarySearchTree<K, V> {

    void insert(K k, V v);
    V find(K k);
    V delete(K k);
    void inOrderTraverse(Node<K, V> node);
    void preOrderTraverse(Node<K, V> node);
    void postOrderTraverse(Node<K, V> node);
    V getTopElement();
}
