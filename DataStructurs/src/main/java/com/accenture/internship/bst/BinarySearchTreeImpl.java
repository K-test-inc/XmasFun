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

        if (k == null) {
            System.out.println("Key cannot be null");
            return;
        }
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
        Node<K, V> current = findNode(k);
        if (current != null)
            return current.getValue();
        else
            return null;
    }

    private Node<K, V> findNode(K k) {
        if (k == null)
            return null;
        if (root == null)
            return null;
        Node<K, V> current = root;
        boolean found = false;
        while (true) {
            if (current.getValue().equals(k)) {
                found = true;
                break;
            }
            if (k.compareTo(current.getKey()) <= 0) {
                if (current.getLeft() == null) {
                    break;
                } else {
                    current = current.getLeft();
                }
            } else {
                if (k.compareTo(current.getKey()) >= 0) {
                    if (current.getRight() == null) {
                        break;
                    } else {
                        current = current.getRight();
                    }
                } else {
                    break;
                }
            }
        }
        if (found) {
            return current;
        } else
            return null;
    }

    @Override
    public V delete(K k) {
        Node<K, V> current = findNode(k);
        if (current == null)
            return null;
        Node<K, V> previous = findPreviousNode(k);
        V value = current.getValue();
        if (current.getLeft() == null && current.getRight() == null) {
            if (previous != null) {
                if (previous.getLeft() != null) {
                    if (previous.getLeft().equals(current))
                        previous.setLeft(null);
                    else previous.setRight(null);
                } else previous.setRight(null);
            } else {
                root = null;
            }
            return value;
        } else {
            if (current.getLeft() != null && current.getRight() == null) {
                if (previous == null) {
                    root = current.getLeft();
                    return value;
                }
                if (previous.getLeft() != null) {
                    if (previous.getLeft().equals(current))
                        previous.setLeft(current.getLeft());
                    else
                        previous.setRight(current.getLeft());
                } else {
                    if (previous.getRight().equals(current))
                        previous.setRight(current.getLeft());
                    else
                        previous.setLeft(current.getLeft());
                }
                current = null;
                return value;
            }
            if (current.getLeft() == null && current.getRight() != null) {
                if (previous == null) {
                    root = current.getRight();
                    return value;
                }

                if (previous.getRight() != null) {
                    if (previous.getRight().equals(current))
                        previous.setRight(current.getRight());
                    else
                        previous.setLeft(current.getRight());
                } else {
                    if (previous.getLeft().equals(current))
                        previous.setLeft(current.getRight());
                    else
                        previous.setRight(current.getRight());
                }
                current = null;
                return value;
            }
            if (current.getLeft() != null && current.getRight() != null) {
                Node<K, V> newBrand = current.getRight();
                while (true) {
                    if (newBrand.getLeft() != null) {
                        newBrand = newBrand.getLeft();
                    } else {
                        break;
                    }
                }
                Node newBrandPrevious = findPreviousNode(newBrand.getKey());
                if (!newBrandPrevious.equals(previous)) {
                    if (!newBrandPrevious.equals(current))
                        if (newBrandPrevious.getLeft().equals(newBrand))
                            newBrandPrevious.setLeft(null);
                        else {
                            if (newBrandPrevious.getRight().equals(newBrand)) {
                                newBrandPrevious.setRight(null);
                            }
                        }
                }
                if (previous == null) {
                    if (root.getLeft() != null)
                        newBrand.setLeft(root.getLeft());
                    if (root.getRight() != null && !root.getRight().equals(newBrand))
                        newBrand.setRight(root.getRight());
                    root = newBrand;
                    return value;
                }
                if (previous.getLeft() != null && previous.getLeft().equals(current))
                    previous.setLeft(newBrand);
                if (previous.getRight() != null && previous.getRight().equals(current))
                    previous.setRight(newBrand);
                if (current.getLeft() != null && !current.getLeft().equals(newBrand))
                    newBrand.setLeft(current.getLeft());
                if (current.getRight() != null && !current.getRight().equals(newBrand))
                    newBrand.setRight(current.getRight());

                current = null;
                return value;
            }
            return null;
        }
    }

    @Override
    public void inOrderTraverse(K k) {
        Node<K, V> node = findNode(k);
        if (node == null) {
            System.out.println("null");
            return;
        }
        if(node.getLeft() != null)
            inOrderTraverse(node.getLeft().getKey());
        System.out.println(node.getValue());
        if(node.getRight() != null)
            inOrderTraverse(node.getRight().getKey());
    }

    @Override
    public void preOrderTraverse(K k) {
        Node<K, V> node = findNode(k);
        if (node == null) {
            System.out.println("null");
            return;
        }
        System.out.println(node.getValue());
        if(node.getLeft() != null)
            preOrderTraverse(node.getLeft().getKey());
        if(node.getRight() != null)
            preOrderTraverse(node.getRight().getKey());
    }

    @Override
    public void postOrderTraverse(K k) {
        Node<K, V> node = findNode(k);
        if (node == null) {
            System.out.println("null");
            return;
        }
        if(node.getLeft() != null)
            postOrderTraverse(node.getLeft().getKey());
        if(node.getRight() != null)
            postOrderTraverse(node.getRight().getKey());
        System.out.println(node.getValue());
    }

    @Override
    public Node<K, V> getTopElement() {
        if (root == null)
            return null;
        else return root;
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

    protected Node<K, V> findPreviousNode(K k) {
        if (root == null)
            return null;
        Node<K, V> current = root;
        boolean found = false;
        while (true) {
            if (current.getLeft() == null && current.getRight() == null) {
                break;
            }
            if (current.getLeft() != null) {
                if (current.getLeft().getValue().equals(k)) {
                    found = true;
                    break;
                }
            }
            if (current.getRight() != null) {
                if (current.getRight().getValue().equals(k)) {
                    found = true;
                    break;
                }
            }
            if (k.compareTo(current.getKey()) == 0)
                return null;

            if (k.compareTo(current.getKey()) < 0) {
                current = current.getLeft();
            } else {
                if (k.compareTo(current.getKey()) > 0) {
                    current = current.getRight();
                } else {
                    break;
                }
            }
        }
        if (found) {
            return current;
        } else
            return null;
    }
}
