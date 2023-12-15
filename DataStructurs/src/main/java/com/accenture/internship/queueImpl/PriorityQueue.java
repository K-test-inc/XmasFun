package com.accenture.internship.queueImpl;

import java.util.*;

public class PriorityQueue<T> implements Queue<T>, Comparable<PriorityQueue> {

    private char c;
    private Object[] array;
    private static final int DEFAULT_CAPACITY = 10;
    private int size;
    private int head;
    private int tail;


    public PriorityQueue() {
        this.array = new Object[DEFAULT_CAPACITY];
        this.size = 0;
        this.head = -1;
        this.tail = -1;
    }

    public PriorityQueue(Object[] array, int size, int head, int tail) {
        this.array = array;
        this.size = size;
        this.head = head;
        this.tail = tail;
    }

    public Object[] getArray() {
        return array;
    }

    public int getSize() {
        return size;
    }

    public int getHead() {
        return head;
    }

    public int getTail() {
        return tail;
    }

    public void setArray(Object[] array) {
        this.array = array;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void setHead(int head) {
        this.head = head;
    }

    public void setTail(int tail) {
        this.tail = tail;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean isFull() {
        return DEFAULT_CAPACITY == size;
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
        if (tail != head) {
            int currentIndex = tail;
            int previousIndex;
            if (currentIndex == 0)
                previousIndex = 9;
            else
                previousIndex = currentIndex - 1;
            char current = array[currentIndex].toString().toCharArray()[0];
            char previous = array[previousIndex].toString().toCharArray()[0];
            while (current < previous && currentIndex != head) {
                T temp = (T) array[previousIndex];
                array[previousIndex] = array[currentIndex];
                array[currentIndex] = temp;
                previousIndex--;
                currentIndex--;
                if (currentIndex >= 0)
                    current = array[currentIndex].toString().toCharArray()[0];
                else
                    currentIndex = 9;
                if (previousIndex >= 0)
                    try {
                        previous = array[previousIndex].toString().toCharArray()[0];
                    } catch (Exception e){
                        break;
                    }
                else
                    previousIndex = 9;
            }
        }
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
        head++;
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
        PriorityQueue<?> that = (PriorityQueue<?>) o;
        return size == that.size && head == that.head && tail == that.tail && Arrays.equals(array, that.array);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(size, head, tail);
        result = 31 * result + Arrays.hashCode(array);
        return result;
    }

    @Override
    public String toString() {
        return "PriorityQueue{" +
                "array=" + Arrays.toString(array) +
                '}';
    }

    @Override
    public int compareTo(PriorityQueue other) {

        return this.c - other.c;
    }
}
