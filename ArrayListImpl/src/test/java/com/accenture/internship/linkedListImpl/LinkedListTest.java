package com.accenture.internship.linkedListImpl;

import junit.framework.TestCase;


import static org.junit.jupiter.api.Assertions.*;

public class LinkedListTest extends TestCase {

    public void testAddFirst_emptyList() {

        LinkedList<String> list = new LinkedList<>();
        list.addFirst("test1");

        assertEquals(1, list.size());
        assertEquals("test1", list.getFirst().getValue());
        assertEquals("test1", list.getLast().getValue());

    }

    public void testAddFirst_notEmptyList() {

        LinkedList<String> list = new LinkedList<>();
        list.addFirst("test1");
        list.addFirst("test2");
        list.addFirst("test3");

        assertEquals(3, list.size());
        assertEquals("test3", list.getFirst().getValue());
        assertEquals("test1", list.getLast().getValue());
    }

    public void testAddLast_emptyList() {

        LinkedList<String> list = new LinkedList<>();
        list.addLast("test1");

        assertEquals(1, list.size());
        assertEquals("test1", list.getFirst().getValue());
        assertEquals("test1", list.getLast().getValue());
    }

    public void testAddLast_notEmptyList() {

        LinkedList<String> list = new LinkedList<>();
        list.addLast("test1");
        list.addLast("test2");
        list.addLast("test3");

        assertEquals(3, list.size());
        assertEquals("test1", list.getFirst().getValue());
        assertEquals("test3", list.getLast().getValue());
    }

    public void testAdd_emptyList() {

        LinkedList<String> list = new LinkedList<>();
        list.add("test1");

        assertEquals(1, list.size());
        assertEquals("test1", list.getFirst().getValue());
        assertEquals("test1", list.getLast().getValue());
    }

    public void testAdd_notEmptyList() {

        LinkedList<String> list = new LinkedList<>();
        list.add("test1");
        list.add("test2");
        list.add("test3");
        list.add("test4");

        assertEquals(4, list.size());
        assertEquals("test1", list.getFirst().getValue());
        assertEquals("test4", list.getLast().getValue());

        assertEquals("test2",list.getFirst().getNext().getValue());
        assertEquals("test3",list.getFirst().getNext().getNext().getValue());
        assertEquals("test4",list.getFirst().getNext().getNext().getNext().getValue());

        assertEquals("test3",list.getLast().getPrevious().getValue());
        assertEquals("test2",list.getLast().getPrevious().getPrevious().getValue());
        assertEquals("test1",list.getLast().getPrevious().getPrevious().getPrevious().getValue());
    }

    public void testAddByIndex_negativeIndex(){

        LinkedList<String> list = new LinkedList<>();

        assertThrows(IndexOutOfBoundsException.class, () -> list.add("test", -1));
        assertEquals(0, list.size());
    }

    public void testAddByIndex_wrongIndexEmptyList(){

        LinkedList<String> list = new LinkedList<>();

        assertThrows(IndexOutOfBoundsException.class, () -> list.add("test", 10));
        assertEquals(0, list.size());
    }

    public void testAddByIndex_wrongIndexNotEmptyList(){

        LinkedList<String> list = new LinkedList<>();
        list.add("test1");

        assertThrows(IndexOutOfBoundsException.class, () -> list.add("test2", 10));
        assertEquals(1, list.size());
        assertEquals("test1", list.getFirst().getValue());
        assertEquals("test1", list.getLast().getValue());
    }

    public void testAddByIndex_firstElementInList(){

        LinkedList<String> list = new LinkedList<>();
        list.add("test1", 0);

        assertEquals(1, list.size());
        assertEquals("test1", list.getFirst().getValue());
        assertEquals("test1", list.getLast().getValue());
    }


    public void testAddByIndex_addingToEndWhenListNotEmpty(){

        LinkedList<String> list = new LinkedList<>();
        list.add("test1");
        list.add("test2");
        list.add("test3");

        list.add("test4", 2);

        assertEquals(4, list.size());
        assertEquals("test1", list.getFirst().getValue());
        assertEquals("test4", list.getLast().getValue());
    }

    public void testAddByIndex_addingToSecondPositionWhenListNotEmpty(){

        LinkedList<String> list = new LinkedList<>();
        list.add("test1");
        list.add("test2");
        list.add("test3");

        list.add("test4", 1);

        assertEquals(4, list.size());
        assertEquals("test1", list.getFirst().getValue());
        assertEquals("test3", list.getLast().getValue());

        assertEquals("test1", list.get(0));
        assertEquals("test4", list.get(1));
        assertEquals("test2", list.get(2));
        assertEquals("test3", list.get(3));
    }

    public void testAddByIndex_addingToFourthPositionWhenListNotEmpty(){

        LinkedList<String> list = new LinkedList<>();
        list.add("test1");
        list.add("test2");
        list.add("test3");
        list.add("test4");
        list.add("test5");
        list.add("test6");
        list.add("test7");
        list.add("test8");
        list.add("test9");

        list.add("test10", 3);

        assertEquals(10, list.size());
        assertEquals("test1", list.getFirst().getValue());
        assertEquals("test9", list.getLast().getValue());

        assertEquals("test10", list.getFirst().getNext().getNext().getNext().getValue());
        assertEquals("test3",list.getFirst().getNext().getNext().getNext().getPrevious().getValue());
        assertEquals("test4", list.getFirst().getNext().getNext().getNext().getNext().getValue());
        assertEquals("test10", list.getFirst().getNext().getNext().getNext().getNext().getPrevious().getValue());

        assertEquals("test1", list.get(0));
        assertEquals("test2", list.get(1));
        assertEquals("test3", list.get(2));
        assertEquals("test10", list.get(3));
        assertEquals("test4", list.get(4));
        assertEquals("test5", list.get(5));
    }

    public void testGetElementByIndex(){

        LinkedList<String> list = new LinkedList<>();
        list.add("test1");
        list.add("test2");
        list.add("test3");
        list.add("test4");
        list.add("test5");
        list.add("test6");
        list.add("test7");
        list.add("test8");
        list.add("test9");
        String node = list.get(4);
        assertEquals("test5", node);
        assertEquals(9, list.size());

    }

    public void testGetElementByIndex_getFirst(){

        LinkedList<String> list = new LinkedList<>();
        list.add("test1");
        list.add("test2");
        list.add("test3");
        list.add("test4");
        list.add("test5");
        list.add("test6");
        list.add("test7");
        list.add("test8");
        list.add("test9");
        String node = list.get(0);
        assertEquals("test1", node);
        assertEquals(9, list.size());

    }

    public void testGetElementByIndex_getLast(){

        LinkedList<String> list = new LinkedList<>();
        list.add("test1");
        list.add("test2");
        list.add("test3");
        list.add("test4");
        list.add("test5");
        list.add("test6");
        list.add("test7");
        list.add("test8");
        list.add("test9");
        String node = list.get(8);
        assertEquals("test9", node);
        assertEquals(9, list.size());

    }

    public void testGetElementByIndex_negativeIndex(){

        LinkedList<String> list = new LinkedList<>();
        list.add("test1");
        list.add("test2");
        list.add("test3");
        list.add("test4");
        list.add("test5");
        list.add("test6");
        list.add("test7");
        list.add("test8");
        list.add("test9");
        assertThrows(IndexOutOfBoundsException.class, () -> list.get(-1));
        assertEquals(9, list.size());

    }

    public void testGetElementByIndex_wrongIndex(){

        LinkedList<String> list = new LinkedList<>();
        list.add("test1");
        list.add("test2");
        list.add("test3");
        list.add("test4");
        list.add("test5");
        list.add("test6");
        list.add("test7");
        list.add("test8");
        list.add("test9");
        assertThrows(IndexOutOfBoundsException.class, () -> list.get(9));
        assertEquals(9, list.size());

    }

    public void testHasNext(){
        LinkedList<String> list = new LinkedList<>();
        list.add("test1");
        list.add("test2");
        list.add("test3");

        assertTrue(list.hasNext("test1"));
        assertTrue(list.hasNext("test2"));
        assertFalse(list.hasNext("test3"));
    }

    public void testHasNext_noElement(){
        LinkedList<String> list = new LinkedList<>();
        list.add("test1");
        list.add("test2");
        list.add("test3");

        assertFalse(list.hasNext("test4"));

    }

    public void testHasNext_emptyList(){
        LinkedList<String> list = new LinkedList<>();

        assertFalse(list.hasNext("test4"));

    }

    public void testHasNext_oneElement(){
        LinkedList<String> list = new LinkedList<>();
        list.add("test1");

        assertFalse(list.hasNext("test1"));
        assertFalse(list.hasNext("test4"));

    }

    public void testNext(){
        LinkedList<String> list = new LinkedList<>();
        list.add("test1");
        list.add("test2");
        list.add("test3");

      assertEquals("test3", list.next("test2"));
    }

    public void testNext_noElement(){
        LinkedList<String> list = new LinkedList<>();
        list.add("test1");
        list.add("test2");
        list.add("test3");

        assertNull(list.next("test3"));
    }

    public void testNext_emptyList(){
        LinkedList<String> list = new LinkedList<>();

        assertNull(list.next("test3"));

    }

    public void testIndexOf(){
        LinkedList<String> list = new LinkedList<>();
        list.add("test1");
        list.add("test2");
        list.add("test3");
        list.add("test4");
        list.add("test5");

        assertEquals(0, list.indexOf("test1"));
        assertEquals(3, list.indexOf("test4"));
        assertEquals(4, list.indexOf("test5"));
        assertEquals(-1, list.indexOf("test10"));
    }

    public void testIndexOf_emptyList(){
        LinkedList<String> list = new LinkedList<>();

        assertEquals(-1, list.indexOf("test10"));
    }

    public void testRemoveByIndex(){
        LinkedList<String> list = new LinkedList<>();
        list.add("test1");
        list.add("test2");
        list.add("test3");
        list.add("test4");
        list.add("test5");
        assertEquals(5, list.size());

        list.remove(2);
        assertEquals(0, list.indexOf("test1"));
        assertEquals(1, list.indexOf("test2"));
        assertEquals(2, list.indexOf("test4"));
        assertEquals(3, list.indexOf("test5"));
        assertEquals(4, list.size());



    }

}