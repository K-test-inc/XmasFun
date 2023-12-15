package com.accenture.internship.queueImpl;

import java.util.*;

public class Enqueue<T> implements Queue<T> {

    private Object[] array;
    private static final int DEFAULT_CAPACITY = 10;
    private int size;
    private int head;
    private int tail;

    public Object[] getArray() {
        return array;
    }

    public void setArray(Object[] array) {
        this.array = array;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getHead() {
        return head;
    }

    public void setHead(int head) {
        this.head = head;
    }

    public int getTail() {
        return tail;
    }

    public void setTail(int tail) {
        this.tail = tail;
    }

    public Enqueue() {
        this.array = new Object[DEFAULT_CAPACITY];
        this.size = 0;
        this.head = -1;
        this.tail = -1;
    }

    public Enqueue(Object[] array, int size, int head, int tail) {
        this.array = array;
        this.size = size;
        this.head = head;
        this.tail = tail;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean isFull() {
        return size == DEFAULT_CAPACITY;
    }


    @Override
    public boolean add(T t) {
        if (t == null)
            return false;
        if (isFull())
            return false;
        if (isEmpty()) {
            head = 0;
            tail = 0;
        } else {
            if (tail != DEFAULT_CAPACITY - 1)
                tail++;
            else tail = 0;
        }
        array[tail] = t;
        size++;
        return true;
    }


    @Override
    public T peek() {
        if (isEmpty())
            return null;
        else return (T) array[head];
    }

    @Override
    public T poll() {
        if (isEmpty())
            return null;
        if(head == 10)
            head = 0;
        T t = (T) array[head];
        array[head] = null;
        head += 1;
        size--;
        if (size == 0) {
            head = -1;
            tail = -1;
        }
        return t;
    }


    @Override
    public void queueDisplay() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
        } else {
            int i = head;
            while (array[i] != null) {
                System.out.println(array[i]);
                i++;
                if(i > DEFAULT_CAPACITY - 1)
                    i = 0;
            }
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Enqueue<?> enqueue = (Enqueue<?>) o;
        return size == enqueue.size && head == enqueue.head && tail == enqueue.tail && Arrays.equals(array, enqueue.array);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(size, head, tail);
        result = 31 * result + Arrays.hashCode(array);
        return result;
    }
}
