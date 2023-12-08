package com.accenture.internship;

public interface List {
    void add(Object element);

    void add(Object element, int index);

    int size();

    Object get(int index);

    int indexOf(Object element);

    boolean hasNext(Object element);

    Object next(Object element);

    void remove(int index);

    void remove(Object element);
}
