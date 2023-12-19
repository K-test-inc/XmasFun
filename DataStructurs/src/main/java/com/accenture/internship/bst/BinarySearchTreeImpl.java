package com.accenture.internship.bst;

import java.util.*;

public class BinarySearchTreeImpl<K extends Comparable<K>, V> implements BinarySearchTree<K, V> {

    private Node<K, V> root;

    public Node<K, V> getRoot() {
        return root;
    }

    public void setRoot(Node<K, V> root) {
        this.root = root;
    }

    public BinarySearchTreeImpl(Node<K, V> root) {
        this.root = root;
    }

    public BinarySearchTreeImpl() {

    }

    @Override
    public void insert(K k, V v) {

        if (root == null) {
            root = new Node<>(k, v);
            return;
        }
        Node<K, V> current = root;
        while (true) {
            if (k.compareTo(current.getKey()) < 0) {
                if (current.getLeft() == null) {
                    current.setLeft(new Node<>(k, v));
                    return;
                }
                current = current.getLeft();
            } else {
                if (k.compareTo(current.getKey()) > 0) {
                    if (current.getRight() == null) {
                        current.setRight(new Node<>(k, v));
                        return;
                    }
                    current = current.getRight();
                } else {
                    current.setValue(v);
                    return;
                }
            }

        }
    }

    @Override
    public V find(K k) {
        if (root == null)
            return null;
        Node<K, V> current = root;
        while (true) {
            if(current.getValue().equals(k))
                return current.getValue();
            if (k.compareTo(current.getKey()) <= 0) {
                if (current.getLeft() == null) {
                    return current.getValue();
                } else {
                    current = current.getLeft();
                }
            } else {
                if (k.compareTo(current.getKey()) >= 0) {
                    if (current.getRight() == null) {
                        return current.getValue();
                    } else {
                        current = current.getRight();
                    }
                } else{
                    return current.getValue();
                }
            }
        }
    }

    @Override
    public V delete(K k) {
        return null;
    }

    @Override
    public void inOrderTraverse(Node<K, V> node) {

    }

    @Override
    public void preOrderTraverse(Node<K, V> node) {

    }

    @Override
    public void postOrderTraverse(Node<K, V> node) {

    }

    @Override
    public V getTopElement() {
        if (root == null)
            return null;
        else return (V) root.getValue();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BinarySearchTreeImpl<?, ?> that = (BinarySearchTreeImpl<?, ?>) o;
        return Objects.equals(root, that.root);
    }

    @Override
    public int hashCode() {
        return Objects.hash(root);
    }
}
