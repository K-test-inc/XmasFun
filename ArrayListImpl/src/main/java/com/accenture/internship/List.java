package com.accenture.internship;

public interface List<T> {
    void add(T element);

    void addFirst(T element);

    void addLast(T element);

    void add(T element, int index);

    int size();

    T get(int index);

    int indexOf(T element);

    boolean hasNext(T element);

    T next(T element);

    void remove(int index);

    void remove(T element);

    void removeFirst();

    void removeLast();
}
