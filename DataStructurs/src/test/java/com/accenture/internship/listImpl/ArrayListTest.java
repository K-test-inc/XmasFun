package com.accenture.internship.listImpl;


import junit.framework.*;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;


public class ArrayListTest extends TestCase {

    public void testAddingTwoElements() {

        String[] array = new String[]{"test1", "test2", null, null, null, null, null, null, null, null};
        ArrayList<String> expectedList = new ArrayList<>(array, 2);

        ArrayList<String> myList = new ArrayList<>();
        myList.add("test1");
        myList.add("test2");
        assertEquals(2, myList.size());
        assertEquals(expectedList, myList);

    }

    public void testAddingElevenElements() {

        String[] array = new String[]{"test1", "test2", "test3", "test4", "test5", "test6", "test7", "test8", "test9",
                "test10", "test11", null, null, null, null, null, null, null, null, null};
        ArrayList<String> expectedList = new ArrayList<>(array, 11);

        ArrayList<String> myList = new ArrayList<>();
        myList.add("test1");
        myList.add("test2");
        myList.add("test3");
        myList.add("test4");
        myList.add("test5");
        myList.add("test6");
        myList.add("test7");
        myList.add("test8");
        myList.add("test9");
        myList.add("test10");
        myList.add("test11");
        assertEquals(11, myList.size());
        assertEquals(expectedList, myList);

    }

    public void testAddingFirstElement_EmptyArray() {

        String[] array = new String[]{"test1", null, null, null, null, null, null, null, null, null};
        ArrayList<String> expectedList = new ArrayList<>(array, 1);

        ArrayList<String> myList = new ArrayList<>();
        myList.addFirst("test1");

        assertEquals(1, myList.size());
        assertEquals(expectedList, myList);
    }

    public void testAddingFirstElement_NotEmptyArray() {

        String[] array = new String[]{"test2", "test1", null, null, null, null, null, null, null, null};
        ArrayList<String> expectedList = new ArrayList<>(array, 2);

        ArrayList<String> myList = new ArrayList<>();
        myList.addFirst("test1");
        myList.addFirst("test2");

        assertEquals(2, myList.size());
        assertEquals(expectedList, myList);
    }

    public void testAddingFirstElement_NotEmptyLongArray() {

        String[] array = new String[]{"test11", "test1", "test2", "test3", "test4", "test5", "test6", "test7", "test8",
                "test9", "test10", null, null, null, null, null, null, null, null, null};
        ArrayList<String> expectedList = new ArrayList<>(array, 11);

        ArrayList<String> myList = new ArrayList<>();
        myList.add("test1");
        myList.add("test2");
        myList.add("test3");
        myList.add("test4");
        myList.add("test5");
        myList.add("test6");
        myList.add("test7");
        myList.add("test8");
        myList.add("test9");
        myList.add("test10");
        myList.addFirst("test11");
        assertEquals(11, myList.size());
        assertEquals(expectedList, myList);
    }

    public void testAddingLastElement_NotEmptyArray() {

        String[] array = new String[]{"test1", "test2", null, null, null, null, null, null, null, null};
        ArrayList<String> expectedList = new ArrayList<>(array, 2);

        ArrayList<String> myList = new ArrayList<>();
        myList.addFirst("test1");
        myList.addLast("test2");

        assertEquals(2, myList.size());
        assertEquals(expectedList, myList);
    }

    public void testAddingLastElement_EmptyArray() {

        String[] array = new String[]{"test1", null, null, null, null, null, null, null, null, null};
        ArrayList<String> expectedList = new ArrayList<>(array, 1);

        ArrayList<String> myList = new ArrayList<>();
        myList.addLast("test1");

        assertEquals(1, myList.size());
        assertEquals(expectedList, myList);
    }

    public void testAddingLastElement_NotEmptyLongArray() {

        String[] array = new String[]{"test1", "test2", "test3", "test4", "test5", "test6", "test7", "test8", "test9",
                "test10", "test11", null, null, null, null, null, null, null, null, null};
        ArrayList<String> expectedList = new ArrayList<>(array, 11);

        ArrayList<String> myList = new ArrayList<>();
        myList.add("test1");
        myList.add("test2");
        myList.add("test3");
        myList.add("test4");
        myList.add("test5");
        myList.add("test6");
        myList.add("test7");
        myList.add("test8");
        myList.add("test9");
        myList.add("test10");
        myList.addLast("test11");
        assertEquals(11, myList.size());
        assertEquals(expectedList, myList);
    }

    public void testAddingElementToTheArraysMiddle_shortArray() {

        String[] array = new String[]{"new element", "test1", "test2", null, null, null, null, null, null, null};
        ArrayList<String> expectedList = new ArrayList<>(array, 3);

        ArrayList<String> myList = new ArrayList<>();
        myList.add("test1");
        myList.add("test2");
        myList.add("new element", 0);
        assertEquals(3, myList.size());
        assertEquals(expectedList, myList);

    }

    public void testAddingElementToTheArraysMiddle_longArray() {

        String[] array = new String[]{"test1", "test2", "test3", "new element", "test4", "test5", "test6", "test7", "test8", "test9",
                "test10", "test11", null, null, null, null, null, null, null, null};
        ArrayList<String> expectedList = new ArrayList<>(array, 12);

        ArrayList<String> myList = new ArrayList<>();
        myList.add("test1");
        myList.add("test2");
        myList.add("test3");
        myList.add("test4");
        myList.add("test5");
        myList.add("test6");
        myList.add("test7");
        myList.add("test8");
        myList.add("test9");
        myList.add("test10");
        myList.add("test11");
        myList.add("new element", 3);
        assertEquals(12, myList.size());
        assertEquals(expectedList, myList);

    }

    public void testAddingElementToTheArraysEndByIndex_longArray() {

        String[] array = new String[]{"test1", "test2", "test3", "test4", "test5", "test6", "test7", "test8", "test9",
                "test10", "test11", "new element", null, null, null, null, null, null, null, null};
        ArrayList<String> expectedList = new ArrayList<>(array, 12);

        ArrayList<String> myList = new ArrayList<>();
        myList.add("test1");
        myList.add("test2");
        myList.add("test3");
        myList.add("test4");
        myList.add("test5");
        myList.add("test6");
        myList.add("test7");
        myList.add("test8");
        myList.add("test9");
        myList.add("test10");
        myList.add("test11");
        myList.add("new element", 11);
        assertEquals(12, myList.size());
        assertEquals(expectedList, myList);

    }

    public void testAddingElementToTheArraysMiddleWithWrongIndex_shortArray() {

        String[] array = new String[]{"test1", "test2", null, null, null, null, null, null, null, null};
        ArrayList<String> expectedList = new ArrayList<>(array, 2);

        ArrayList<String> myList = new ArrayList<>();
        myList.add("test1");
        myList.add("test2");

        assertThrows(IndexOutOfBoundsException.class, () -> myList.add("new element", 100));
        assertEquals(2, myList.size());
        assertEquals(expectedList, myList);

    }

    public void testObjectByIndex() {

        String[] array = new String[]{"test1", "test2", "test3", "test4", "test5", null, null, null, null, null};
        ArrayList<String> expectedList = new ArrayList<>(array, 5);

        ArrayList<String> myList = new ArrayList<>();
        myList.add("test1");
        myList.add("test2");
        myList.add("test3");
        myList.add("test4");
        myList.add("test5");
        String obj = myList.get(2);

        assertEquals("test3", obj);
        assertEquals(5, myList.size());
        assertEquals(expectedList, myList);

    }

    public void testObjectByIndex_wrongIndex() {

        String[] array = new String[]{"test1", "test2", "test3", "test4", "test5", null, null, null, null, null};
        ArrayList<String> expectedList = new ArrayList<>(array, 5);

        ArrayList<String> myList = new ArrayList<>();
        myList.add("test1");
        myList.add("test2");
        myList.add("test3");
        myList.add("test4");
        myList.add("test5");
        assertThrows(IndexOutOfBoundsException.class, () -> myList.get(100));
        assertEquals(5, myList.size());
        assertEquals(expectedList, myList);

    }

    public void testIndexOf() {

        String[] array = new String[]{"test1", "test2", "test3", "test4", "test5", null, null, null, null, null};
        ArrayList<String> expectedList = new ArrayList<>(array, 5);

        ArrayList<String> myList = new ArrayList<>();
        myList.add("test1");
        myList.add("test2");
        myList.add("test3");
        myList.add("test4");
        myList.add("test5");

        int index = myList.indexOf("test3");
        assertEquals(2, index);
        assertEquals(5, myList.size());
        assertEquals(expectedList, myList);

    }

    public void testIndexOf_nonExistentElement() {

        String[] array = new String[]{"test1", "test2", "test3", "test4", "test5", null, null, null, null, null};
        ArrayList<String> expectedList = new ArrayList<>(array, 5);

        ArrayList<String> myList = new ArrayList<>();
        myList.add("test1");
        myList.add("test2");
        myList.add("test3");
        myList.add("test4");
        myList.add("test5");

        int index = myList.indexOf("nonExistentElement");
        assertEquals(-1, index);
        assertEquals(5, myList.size());
        assertEquals(expectedList, myList);

    }

    public void testHasNext_true() {

        String[] array = new String[]{"test1", "test2", "test3", "test4", "test5", null, null, null, null, null};
        ArrayList<String> expectedList = new ArrayList<>(array, 5);

        ArrayList<String> myList = new ArrayList<>();
        myList.add("test1");
        myList.add("test2");
        myList.add("test3");
        myList.add("test4");
        myList.add("test5");

        assertTrue(myList.hasNext("test1"));
        assertEquals(5, myList.size());
        assertEquals(expectedList, myList);

    }

    public void testHasNext_false() {

        String[] array = new String[]{"test1", "test2", "test3", "test4", "test5", null, null, null, null, null};
        ArrayList<String> expectedList = new ArrayList<>(array, 5);

        ArrayList<String> myList = new ArrayList<>();
        myList.add("test1");
        myList.add("test2");
        myList.add("test3");
        myList.add("test4");
        myList.add("test5");

        assertFalse(myList.hasNext("test5"));
        assertEquals(5, myList.size());
        assertEquals(expectedList, myList);

    }

    public void testHasNext_wrongElement() {

        String[] array = new String[]{"test1", "test2", "test3", "test4", "test5", null, null, null, null, null};
        ArrayList<String> expectedList = new ArrayList<>(array, 5);

        ArrayList<String> myList = new ArrayList<>();
        myList.add("test1");
        myList.add("test2");
        myList.add("test3");
        myList.add("test4");
        myList.add("test5");

        assertFalse(myList.hasNext("wrongElement"));
        assertEquals(5, myList.size());
        assertEquals(expectedList, myList);

    }

    public void testNext() {

        String[] array = new String[]{"test1", "test2", "test3", "test4", "test5", null, null, null, null, null};
        ArrayList<String> expectedList = new ArrayList<>(array, 5);

        ArrayList<String> myList = new ArrayList<>();
        myList.add("test1");
        myList.add("test2");
        myList.add("test3");
        myList.add("test4");
        myList.add("test5");

        assertEquals("test2", myList.next("test1"));
        assertEquals(5, myList.size());
        assertEquals(expectedList, myList);

    }

    public void testNext_noNext() {

        String[] array = new String[]{"test1", "test2", "test3", "test4", "test5", null, null, null, null, null};
        ArrayList<String> expectedList = new ArrayList<>(array, 5);

        ArrayList<String> myList = new ArrayList<>();
        myList.add("test1");
        myList.add("test2");
        myList.add("test3");
        myList.add("test4");
        myList.add("test5");

        assertThrows(NoSuchElementException.class, () -> myList.next("test5"));
        assertEquals(5, myList.size());
        assertEquals(expectedList, myList);

    }

    public void testRemoveByIndex_LastElement() {

        String[] array = new String[]{"test1", "test2", "test3", "test4", null, null, null, null, null, null};
        ArrayList<String> expectedList = new ArrayList<>(array, 4);

        ArrayList<String> myList = new ArrayList<>();
        myList.add("test1");
        myList.add("test2");
        myList.add("test3");
        myList.add("test4");
        myList.add("test5");

        myList.remove(4);
        assertEquals(4, myList.size());
        assertEquals(expectedList, myList);
    }

    public void testRemoveByIndex_FirstElement() {

        String[] array = new String[]{"test2", "test3", "test4", "test5", null, null, null, null, null, null};
        ArrayList<String> expectedList = new ArrayList<>(array, 4);

        ArrayList<String> myList = new ArrayList<>();
        myList.add("test1");
        myList.add("test2");
        myList.add("test3");
        myList.add("test4");
        myList.add("test5");

        myList.remove(0);
        assertEquals(4, myList.size());
        assertEquals(expectedList, myList);
    }

    public void testRemoveByIndex_MiddleElement() {

        String[] array = new String[]{"test1", "test2", "test4", "test5", null, null, null, null, null, null};
        ArrayList<String> expectedList = new ArrayList<>(array, 4);

        ArrayList<String> myList = new ArrayList<>();
        myList.add("test1");
        myList.add("test2");
        myList.add("test3");
        myList.add("test4");
        myList.add("test5");

        myList.remove(2);
        assertEquals(4, myList.size());
        assertEquals(expectedList, myList);

    }

    public void testRemoveByIndex_wrongIndex() {

        String[] array = new String[]{"test1", "test2", "test3", "test4", "test5", null, null, null, null, null};
        ArrayList<String> expectedList = new ArrayList<>(array, 5);

        ArrayList<String> myList = new ArrayList<>();
        myList.add("test1");
        myList.add("test2");
        myList.add("test3");
        myList.add("test4");
        myList.add("test5");

        assertThrows(IndexOutOfBoundsException.class, () -> myList.remove(20));

        assertEquals(5, myList.size());
        assertEquals(expectedList, myList);

    }

    public void testRemoveByIndex_IndexLessThanZero() {

        String[] array = new String[]{"test1", "test2", "test3", "test4", "test5", null, null, null, null, null};
        ArrayList<String> expectedList = new ArrayList<>(array, 5);

        ArrayList<String> myList = new ArrayList<>();
        myList.add("test1");
        myList.add("test2");
        myList.add("test3");
        myList.add("test4");
        myList.add("test5");

        assertThrows(IndexOutOfBoundsException.class, () -> myList.remove(-1));

        assertEquals(5, myList.size());
        assertEquals(expectedList, myList);

    }

    public void testRemoveFirst() {

        String[] array = new String[]{"test2", "test3", "test4", "test5", null, null, null, null, null, null};
        ArrayList<String> expectedList = new ArrayList<>(array, 4);

        ArrayList<String> myList = new ArrayList<>();
        myList.add("test1");
        myList.add("test2");
        myList.add("test3");
        myList.add("test4");
        myList.add("test5");

        myList.removeFirst();
        assertEquals(4, myList.size());
        assertEquals(expectedList, myList);

    }

    public void testRemoveLast() {

        String[] array = new String[]{"test1", "test2", "test3", "test4", null, null, null, null, null, null};
        ArrayList<String> expectedList = new ArrayList<>(array, 4);

        ArrayList<String> myList = new ArrayList<>();
        myList.add("test1");
        myList.add("test2");
        myList.add("test3");
        myList.add("test4");
        myList.add("test5");

        myList.removeLast();
        assertEquals(4, myList.size());
        assertEquals(expectedList, myList);

    }

    public void testRemoveByObject() {

        String[] array = new String[]{"test1", "test2", "test4", "test5", null, null, null, null, null, null};
        ArrayList<String> expectedList = new ArrayList<>(array, 4);

        ArrayList<String> myList = new ArrayList<>();
        myList.add("test1");
        myList.add("test2");
        myList.add("test3");
        myList.add("test4");
        myList.add("test5");

        myList.remove("test3");

        assertEquals(4, myList.size());
        assertEquals(expectedList, myList);

    }

    public void testRemoveByObject_inTheArrayAreSameObjects() {

        String[] array = new String[]{"test1", "test2", "test3", "test5", null, null, null, null, null, null};
        ArrayList<String> expectedList = new ArrayList<>(array, 4);

        String[] arrayBeforeDeleting = new String[]{"test1", "test4", "test2", "test3", "test4", "test5", "test4", null, null, null};
        ArrayList<String> expectedListBeforeDeleting = new ArrayList<>(arrayBeforeDeleting, 7);

        ArrayList<String> myList = new ArrayList<>();
        myList.add("test1");
        myList.add("test4");
        myList.add("test2");
        myList.add("test3");
        myList.add("test4");
        myList.add("test5");
        myList.add("test4");
        assertEquals(7, myList.size());
        assertEquals(expectedListBeforeDeleting, myList);

        myList.remove("test4");

        assertEquals(4, myList.size());
        assertEquals(expectedList, myList);

    }

    public void testRemoveByObject_wrongObject() {

        String[] array = new String[]{"test1", "test2", "test3", "test4", "test5", null, null, null, null, null};
        ArrayList<String> expectedList = new ArrayList<>(array, 5);

        ArrayList<String> myList = new ArrayList<>();
        myList.add("test1");
        myList.add("test2");
        myList.add("test3");
        myList.add("test4");
        myList.add("test5");

        myList.remove("wrongObject");

        assertEquals(5, myList.size());
        assertEquals(expectedList, myList);

    }

}