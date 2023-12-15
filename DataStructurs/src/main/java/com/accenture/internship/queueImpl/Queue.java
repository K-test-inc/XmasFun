package com.accenture.internship.queueImpl;

public interface Queue<T> {

    boolean isEmpty();
    boolean isFull();
    boolean add(T t);
    T peek();
    T poll();
    void queueDisplay();
}
