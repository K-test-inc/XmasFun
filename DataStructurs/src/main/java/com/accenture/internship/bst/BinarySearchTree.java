package com.accenture.internship.bst;

public interface BinarySearchTree<K, V> {

    void insert(K k, V v);
    V find(K k);
    V delete(K k);
    void inOrderTraverse(K k);
    void preOrderTraverse(K k);
    void postOrderTraverse(K k);
    V getTopElement();
}
