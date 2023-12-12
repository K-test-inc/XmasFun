package com.accenture.internship.queueImpl;

public interface Queue<T> {

    boolean add(T t);

    T peek();

    T poll();

    void remove();

    void queueDisplay();
}
