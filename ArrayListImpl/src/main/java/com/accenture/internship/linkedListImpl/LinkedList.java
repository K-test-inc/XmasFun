package com.accenture.internship.linkedListImpl;

import com.accenture.internship.*;
import com.accenture.internship.List;
import lombok.*;

import java.util.*;


public class LinkedList<T> implements List<T> {

    private Node<T> node;
    transient Node<T> first;
    transient Node<T> last;
    private int size;

    public LinkedList() {

    }

    public Node<T> getNode() {
        return node;
    }

    public void setNode(Node<T> node) {
        this.node = node;
    }

    public Node<T> getFirst() {
        return first;
    }

    public void setFirst(Node<T> first) {
        this.first = first;
    }

    public Node<T> getLast() {
        return last;
    }

    public void setLast(Node<T> last) {
        this.last = last;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    @Override
    public void add(T element) {

        if (first == null)
            addFirst(element);
        else
            addLast(element);
    }

    @Override
    public void addFirst(T element) {

        Node<T> node = new Node<>(element);
        if (first == null) {
            last = node;
        } else {
            first.setPrevious(node);
            node.setNext(first);
        }
        first = node;
        size++;
    }

    @Override
    public void addLast(T element) {
        Node<T> node = new Node<>(element);
        if (first == null) {
            first = node;
        } else {
            last.setNext(node);
            node.setPrevious(last);
        }
        last = node;
        size++;
    }

    @Override
    public void add(T element, int index) {
        if (index != 0 && first == null) {
            throw new IndexOutOfBoundsException();
        }
        if (index < 0 || index > size + 1) {
            throw new IndexOutOfBoundsException();
        }
        if (index == 0) {
            addFirst(element);
        } else {
            if (index == size - 1) {
                addLast(element);
            } else {
                Node<T> node = new Node<>(element);
                Node<T> currentNode = first;
                Node<T> nextNode = currentNode.getNext();
                for (int i = 1; i < index; i++) {
                    currentNode = nextNode;
                    nextNode = currentNode.getNext();
                }

                currentNode.setNext(node);
                node.setPrevious(currentNode);
                nextNode.setPrevious(node);
                node.setNext(nextNode);
                size++;
            }
        }
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public T get(int index) {

        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException();
        if (index == 0)
            return first.getValue();
        if (index == size - 1)
            return last.getValue();
        Node<T> currentNode = first;
        Node<T> nextNode = currentNode.getNext();
        for (int i = 1; i <= index; i++) {
            currentNode = nextNode;
            nextNode = currentNode.getNext();
        }
        return currentNode.getValue();
    }

    @Override
    public int indexOf(T element) {
        int count = 0;

        Node<T> currentNode = first;
        while (currentNode != null) {
            if (currentNode.getValue().equals(element))
                return count;
            else {
                currentNode = currentNode.getNext();
                count++;
            }
        }
        return -1;
    }

    @Override
    public boolean hasNext(T element) {

        Node<T> currentNode = first;
        while (currentNode != null) {
            if (currentNode.getValue().equals(element))
                return currentNode.getNext() != null;
            else currentNode = currentNode.getNext();
        }
        return false;

    }

    @Override
    public T next(T element) {

        Node<T> currentNode = first;
        while (currentNode != null) {
            if (currentNode.getValue().equals(element))
                return currentNode.getNext() == null ? null : currentNode.getNext().getValue();
            else currentNode = currentNode.getNext();
        }
        return null;
    }

    @Override
    public void remove(int index) {

        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException();
        if (index == 0) {
            first = first.getNext();
            first.setPrevious(null);
        }
        if (index == size - 1) {
            last = last.getPrevious();
            last.setNext(null);
        }
        Node<T> currentNode = first;
        for (int i = 1; i <= index; i++) {
            currentNode = currentNode.getNext();
        }
        currentNode.getPrevious().setNext(currentNode.getNext());
        currentNode.getNext().setPrevious(currentNode.getPrevious());
        currentNode.setNext(null);
        currentNode.setPrevious(null);

    }

    @Override
    public void remove(T element) {

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LinkedList<?> that = (LinkedList<?>) o;
        return size == that.size && Objects.equals(node, that.node) && Objects.equals(first, that.first) && Objects.equals(last, that.last);
    }

    @Override
    public int hashCode() {
        return Objects.hash(node, first, last, size);
    }
}
