package com.accenture.internship;



public class Main {
    public static void main(String[] args) {

    }

    public void arrayListImpl(){

        //Constructs an empty list with an initial capacity of ten.
        List<String> arrayList = new ArrayList<>();

        //Adds a new element to the first position of the list.
        arrayList.addFirst("test0");

        //Adds a new element to the end of the list.
        arrayList.add("test1");
        arrayList.add("test2");
        arrayList.add("test3");
        arrayList.add("test1");
        arrayList.add("test1");

        //Adds a new element to the end of the list.
        arrayList.addLast("test5");

        //Replaces the element at the specified position in this list with the specified element.
        arrayList.add("newElement", 1);

        //Returns the number of elements in this list
        int listSize = arrayList.size();

        //Returns the element at the specified position in this list.
        Object obj = arrayList.get(1);

        //Returns the index of the first occurrence of the specified element in this list,
        // or -1 if this list does not contain the element.
        int index = arrayList.indexOf("test2");

        //Checks whether a given element has a next element in the list.
        // Returns false if the given element is not in the list

        boolean hasNext = arrayList.hasNext("test2");

        //Returns the next element from the list following the given one.
        //Throws NoSuchElementException if there is no next element after the given one or if there is no given element

        Object obj1 = arrayList.next("test2");

        //Removes an element from the list by index.
        //Throws IndexOutOfBoundsException if the index is invalid
        arrayList.remove("1");

        //Removes all elements from a list by content.
        //Throws IndexOutOfBoundsException if the index is invalid
        arrayList.remove("test1");

    }
}