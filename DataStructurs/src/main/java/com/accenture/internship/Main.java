package com.accenture.internship;


import com.accenture.internship.bst.*;
import com.accenture.internship.bst.Node;
import com.accenture.internship.listImpl.*;
import com.accenture.internship.mapImpl.*;
import com.accenture.internship.queueImpl.*;


public class Main {
    public static void main(String[] args) {

    }

    public void arrayListImpl() {

        //Constructs an empty list with an initial capacity of ten.
        List<Object> arrayList = new ArrayList<>();

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

    public void LinkedListImpl() {

        //Constructs an empty list.
        List<Object> linkedList = new LinkedList<>();

        //Adds a new element to the first position of the list.
        linkedList.addFirst("element");

        //Adds a new element to the last position of the list.
        linkedList.addLast("element");

        //By default, adds a new element to the last position of the list.
        linkedList.add("element");

        //Adds a new element to the specified position of the list.
        //In case of a negative index or if index is greater than list size, an IndexOutOfBoundsException is thrown
        linkedList.add("element", 2);

        //Returns the number of elements in this list
        int listSize = linkedList.size();

        //Returns the element at the specified position in this list.
        Object obj = linkedList.get(1);

        //Returns the index of the first occurrence of the specified element in this list,
        // or -1 if this list does not contain the element.
        int index = linkedList.indexOf("test2");

        //Checks whether a given element has a next element in the list.
        // Returns false if the given element is not in the list
        boolean hasNext = linkedList.hasNext("test2");

        //Returns the next element from the list following the given one.
        //Return null if there is no next element after the given one or if there is no given element
        Object obj1 = linkedList.next("test2");

        //Removes an element from the list by index.
        //Throws IndexOutOfBoundsException if the index is invalid
        linkedList.remove("1");

        //Removes all elements from a list by content.
        //Throws IndexOutOfBoundsException if the index is invalid
        linkedList.remove("test1");

        //Removes first element from a list.
        linkedList.removeFirst();

        //Removes last element from a list.
        linkedList.removeLast();
    }

    public void enqueueImpl() {

        // Constructs an empty queue with an initial capacity of ten.
        Queue<Object> enqueue = new Enqueue<>();

        // Checks if the queue is empty
        boolean empty = enqueue.isEmpty();

        // Checks if there are free cells in queue
        boolean full = enqueue.isFull();

        // Adds an element to the end of queue
        // If the element was added successfully, returns true.
        // If the queue is full, returns false
        // Returns false if null is added
        boolean add = enqueue.add("element");

        // Returns the first element of queue
        // If queue is empty, returns null
        Object obj = enqueue.peek();

        // Returns the first element of queue and remove him
        // If queue is empty, returns null
        obj = enqueue.poll();

        // Prints all queue elements to the console.
        // If queue is empty, prints "Queue is empty"
        enqueue.queueDisplay();
    }

    public void priorityQueueImpl() {

        // Constructs an empty queue with an initial capacity of ten.
        Queue<Object> enqueue = new Enqueue<>();

        // Checks if the queue is empty
        boolean empty = enqueue.isEmpty();

        // Checks if there are free cells in queue
        boolean full = enqueue.isFull();

        // Adds elements depending on priority. Higher priority elements are placed at the beginning of the queue.
        // If the element was added successfully, returns true.
        // If the queue is full, returns false
        // Returns false if null is added
        boolean add = enqueue.add("element");

        // Returns the first element of queue
        // If queue is empty, returns null
        Object obj = enqueue.peek();

        // Returns the first element of queue and remove him
        // If queue is empty, returns null
        obj = enqueue.poll();

        // Prints all queue elements to the console.
        // If queue is empty, prints "Queue is empty"
        enqueue.queueDisplay();
    }

    public void hashMapImpl(){

        // Constructs an empty hashMap
        Map<Object, Object> hashMap = new HashMap();

        // Returns hash values for a key
        int hash = hashMap.hash("key");

        // Adds new element to the hashMap
        // If key matches, changes the value to a new one
        hashMap.put(new Object(), new Object());

        // Returns the value by key
        // If there is no key in the map, it returns null
        Object value = hashMap.get("key");

        // Returns element by key
        // If there is no key in the map, it returns null
        value = hashMap.remove("key");

        //Returns the number of elements in the map
        int size = hashMap.size();

        // Checks if the map is empty
        boolean isEmpty = hashMap.isEmpty();
    }

    public void binarySearchTreeImpl(){

        // Constructs an empty Binary Search Tree
        BinarySearchTree<Object, Object> tree = new BinarySearchTreeImpl();

        //Adds a new element to the tree
        //If the key value is null, prints to the console "Key cannot be null"
        //If the element exists, changes its value to a new one
        tree.insert("Key", "Value");

        //Returns the value of an element by key
        //In case of an empty tree, a non-existent key, or a key equal to null, returns null
        Object  obj = tree.find("Key");

        //takes the key value
        //Returns the value of the removed element
        //In case of an empty tree, a non-existent key, or a key equal to null, returns null
        obj = tree.delete("Key");

        //Prints to the console the value of the elements when traversing the tree in-order
        //Prints null in case of an empty tree, a non-existent key, or if the key value is null
        tree.inOrderTraverse("Key");

        //Prints to the console the value of the elements when traversing the tree pre-order
        //Prints null in case of an empty tree, a non-existent key, or if the key value is null
        tree.preOrderTraverse("Key");

        //Prints to the console the value of the elements when traversing the tree in post-order
        //Prints null in case of an empty tree, a non-existent key, or if the key value is null
        tree.postOrderTraverse("Key");

        // Return root element
        Node<Object, Object> root = tree.getTopElement();
    }
}