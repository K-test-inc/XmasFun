package com.accenture.internship;

import junit.framework.TestCase;
import org.junit.jupiter.api.*;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;


public class ArrayListTest extends TestCase {

    @Test
    public void testAddingTwoElements() {

        String[] array = new String[]{"test1", "test2", null, null, null, null, null, null, null, null};
        ArrayList expectedList = new ArrayList(array, 2);

        ArrayList myList = new ArrayList();
        myList.add(new String("test1"));
        myList.add(new String("test2"));
        assertEquals(2, myList.size());
        assertEquals(expectedList, myList);

    }

    @Test
    public void testAddingElevenElements() {

        String[] array = new String[]{"test1", "test2", "test3", "test4", "test5", "test6", "test7", "test8", "test9",
                "test10", "test11", null, null, null, null, null, null, null, null, null};
        ArrayList expectedList = new ArrayList(array, 11);

        ArrayList myList = new ArrayList();
        myList.add(new String("test1"));
        myList.add(new String("test2"));
        myList.add(new String("test3"));
        myList.add(new String("test4"));
        myList.add(new String("test5"));
        myList.add(new String("test6"));
        myList.add(new String("test7"));
        myList.add(new String("test8"));
        myList.add(new String("test9"));
        myList.add(new String("test10"));
        myList.add(new String("test11"));
        assertEquals(11, myList.size());
        assertEquals(expectedList, myList);

    }

    @Test
    public void testAddingElementToTheArraysMiddle_shortArray() {

        String[] array = new String[]{"new element", "test1", "test2", null, null, null, null, null, null, null};
        ArrayList expectedList = new ArrayList(array, 3);

        ArrayList myList = new ArrayList();
        myList.add(new String("test1"));
        myList.add(new String("test2"));
        myList.add(new String("new element"), 0);
        assertEquals(3, myList.size());
        assertEquals(expectedList, myList);

    }

    @Test
    public void testAddingElementToTheArraysMiddle_longArray() {

        String[] array = new String[]{"test1", "test2", "test3", "new element", "test4", "test5", "test6", "test7", "test8", "test9",
                "test10", "test11", null, null, null, null, null, null, null, null};
        ArrayList expectedList = new ArrayList(array, 12);

        ArrayList myList = new ArrayList();
        myList.add(new String("test1"));
        myList.add(new String("test2"));
        myList.add(new String("test3"));
        myList.add(new String("test4"));
        myList.add(new String("test5"));
        myList.add(new String("test6"));
        myList.add(new String("test7"));
        myList.add(new String("test8"));
        myList.add(new String("test9"));
        myList.add(new String("test10"));
        myList.add(new String("test11"));
        myList.add(new String("new element"), 3);
        assertEquals(12, myList.size());
        assertEquals(expectedList, myList);

    }

    @Test
    public void testAddingElementToTheArraysEndByIndex_longArray() {

        String[] array = new String[]{"test1", "test2", "test3", "test4", "test5", "test6", "test7", "test8", "test9",
                "test10", "test11", "new element", null, null, null, null, null, null, null, null};
        ArrayList expectedList = new ArrayList(array, 12);

        ArrayList myList = new ArrayList();
        myList.add(new String("test1"));
        myList.add(new String("test2"));
        myList.add(new String("test3"));
        myList.add(new String("test4"));
        myList.add(new String("test5"));
        myList.add(new String("test6"));
        myList.add(new String("test7"));
        myList.add(new String("test8"));
        myList.add(new String("test9"));
        myList.add(new String("test10"));
        myList.add(new String("test11"));
        myList.add(new String("new element"), 11);
        assertEquals(12, myList.size());
        assertEquals(expectedList, myList);

    }

    @Test
    public void testAddingElementToTheArraysMiddleWithWrongIndex_shortArray() {

        String[] array = new String[]{"test1", "test2", null, null, null, null, null, null, null, null};
        ArrayList expectedList = new ArrayList(array, 2);

        ArrayList myList = new ArrayList();
        myList.add(new String("test1"));
        myList.add(new String("test2"));

        assertThrows(IndexOutOfBoundsException.class, () -> myList.add(new String("new element"), 100));
        assertEquals(2, myList.size());
        assertEquals(expectedList, myList);

    }

    @Test
    public void testObjectByIndex() {

        String[] array = new String[]{"test1", "test2", "test3", "test4", "test5", null, null, null, null, null};
        ArrayList expectedList = new ArrayList(array, 5);

        ArrayList myList = new ArrayList();
        myList.add(new String("test1"));
        myList.add(new String("test2"));
        myList.add(new String("test3"));
        myList.add(new String("test4"));
        myList.add(new String("test5"));
        String obj = (String) myList.get(2);

        assertEquals("test3", obj);
        assertEquals(5, myList.size());
        assertEquals(expectedList, myList);

    }

    @Test
    public void testObjectByIndex_wrongIndex() {

        String[] array = new String[]{"test1", "test2", "test3", "test4", "test5", null, null, null, null, null};
        ArrayList expectedList = new ArrayList(array, 5);

        ArrayList myList = new ArrayList();
        myList.add(new String("test1"));
        myList.add(new String("test2"));
        myList.add(new String("test3"));
        myList.add(new String("test4"));
        myList.add(new String("test5"));
        assertThrows(IndexOutOfBoundsException.class, () -> myList.get(100));
        assertEquals(5, myList.size());
        assertEquals(expectedList, myList);

    }

    @Test
    public void testIndexOf() {

        String[] array = new String[]{"test1", "test2", "test3", "test4", "test5", null, null, null, null, null};
        ArrayList expectedList = new ArrayList(array, 5);

        ArrayList myList = new ArrayList();
        myList.add(new String("test1"));
        myList.add(new String("test2"));
        myList.add(new String("test3"));
        myList.add(new String("test4"));
        myList.add(new String("test5"));

        int index = myList.indexOf("test3");
        assertEquals(2, index);
        assertEquals(5, myList.size());
        assertEquals(expectedList, myList);

    }

    @Test
    public void testIndexOf_nonExistentElement() {

        String[] array = new String[]{"test1", "test2", "test3", "test4", "test5", null, null, null, null, null};
        ArrayList expectedList = new ArrayList(array, 5);

        ArrayList myList = new ArrayList();
        myList.add(new String("test1"));
        myList.add(new String("test2"));
        myList.add(new String("test3"));
        myList.add(new String("test4"));
        myList.add(new String("test5"));

        int index = myList.indexOf("nonExistentElement");
        assertEquals(-1, index);
        assertEquals(5, myList.size());
        assertEquals(expectedList, myList);

    }

    @Test
    public void testHasNext_true() {

        String[] array = new String[]{"test1", "test2", "test3", "test4", "test5", null, null, null, null, null};
        ArrayList expectedList = new ArrayList(array, 5);

        ArrayList myList = new ArrayList();
        myList.add(new String("test1"));
        myList.add(new String("test2"));
        myList.add(new String("test3"));
        myList.add(new String("test4"));
        myList.add(new String("test5"));

        assertTrue(myList.hasNext("test1"));
        assertEquals(5, myList.size());
        assertEquals(expectedList, myList);

    }

    @Test
    public void testHasNext_false() {

        String[] array = new String[]{"test1", "test2", "test3", "test4", "test5", null, null, null, null, null};
        ArrayList expectedList = new ArrayList(array, 5);

        ArrayList myList = new ArrayList();
        myList.add(new String("test1"));
        myList.add(new String("test2"));
        myList.add(new String("test3"));
        myList.add(new String("test4"));
        myList.add(new String("test5"));

        assertFalse(myList.hasNext("test5"));
        assertEquals(5, myList.size());
        assertEquals(expectedList, myList);

    }

    @Test
    public void testHasNext_wrongElement() {

        String[] array = new String[]{"test1", "test2", "test3", "test4", "test5", null, null, null, null, null};
        ArrayList expectedList = new ArrayList(array, 5);

        ArrayList myList = new ArrayList();
        myList.add(new String("test1"));
        myList.add(new String("test2"));
        myList.add(new String("test3"));
        myList.add(new String("test4"));
        myList.add(new String("test5"));

        assertFalse(myList.hasNext("wrongElement"));
        assertEquals(5, myList.size());
        assertEquals(expectedList, myList);

    }

    @Test
    public void testNext() {

        String[] array = new String[]{"test1", "test2", "test3", "test4", "test5", null, null, null, null, null};
        ArrayList expectedList = new ArrayList(array, 5);

        ArrayList myList = new ArrayList();
        myList.add(new String("test1"));
        myList.add(new String("test2"));
        myList.add(new String("test3"));
        myList.add(new String("test4"));
        myList.add(new String("test5"));

        assertEquals("test2", myList.next("test1"));
        assertEquals(5, myList.size());
        assertEquals(expectedList, myList);

    }

    @Test
    public void testNext_noNext() {

        String[] array = new String[]{"test1", "test2", "test3", "test4", "test5", null, null, null, null, null};
        ArrayList expectedList = new ArrayList(array, 5);

        ArrayList myList = new ArrayList();
        myList.add(new String("test1"));
        myList.add(new String("test2"));
        myList.add(new String("test3"));
        myList.add(new String("test4"));
        myList.add(new String("test5"));

        assertThrows(NoSuchElementException.class, () -> myList.next("test5"));
        assertEquals(5, myList.size());
        assertEquals(expectedList, myList);


    }


    @Test
    public void testRemoveByIndex_LastElement() {

        String[] array = new String[]{"test1", "test2", "test3", "test4", null, null, null, null, null, null};
        ArrayList expectedList = new ArrayList(array, 4);

        ArrayList myList = new ArrayList();
        myList.add(new String("test1"));
        myList.add(new String("test2"));
        myList.add(new String("test3"));
        myList.add(new String("test4"));
        myList.add(new String("test5"));

        myList.remove(4);
        assertEquals(4, myList.size());
        assertEquals(expectedList, myList);


    }

    @Test
    public void testRemoveByIndex_MiddleElement() {

        String[] array = new String[]{"test1", "test2", "test4", "test5", null, null, null, null, null, null};
        ArrayList expectedList = new ArrayList(array, 4);

        ArrayList myList = new ArrayList();
        myList.add(new String("test1"));
        myList.add(new String("test2"));
        myList.add(new String("test3"));
        myList.add(new String("test4"));
        myList.add(new String("test5"));

        myList.remove(2);
        assertEquals(4, myList.size());
        assertEquals(expectedList, myList);

    }

    @Test
    public void testRemoveByIndex_wrongIndex() {

        String[] array = new String[]{"test1", "test2", "test3", "test4", "test5", null, null, null, null, null};
        ArrayList expectedList = new ArrayList(array, 5);

        ArrayList myList = new ArrayList();
        myList.add(new String("test1"));
        myList.add(new String("test2"));
        myList.add(new String("test3"));
        myList.add(new String("test4"));
        myList.add(new String("test5"));

        assertThrows(IndexOutOfBoundsException.class, () -> myList.remove(20));

        assertEquals(5, myList.size());
        assertEquals(expectedList, myList);

    }


    @Test
    public void testRemoveByObject() {

        String[] array = new String[]{"test1", "test2", "test4", "test5", null, null, null, null, null, null};
        ArrayList expectedList = new ArrayList(array, 4);

        ArrayList myList = new ArrayList();
        myList.add(new String("test1"));
        myList.add(new String("test2"));
        myList.add(new String("test3"));
        myList.add(new String("test4"));
        myList.add(new String("test5"));

        myList.remove("test3");

        assertEquals(4, myList.size());
        assertEquals(expectedList, myList);

    }

    @Test
    public void testRemoveByObject_inTheArrayAreSameObjects() {

        String[] array = new String[]{"test1", "test2", "test3", "test5", null, null, null, null, null, null};
        ArrayList expectedList = new ArrayList(array, 4);

        String[] arrayBeforeDeleting = new String[]{"test1", "test4", "test2","test3", "test4", "test5", "test4", null, null, null};
        ArrayList expectedListBeforeDeleting = new ArrayList(arrayBeforeDeleting, 7);

        ArrayList myList = new ArrayList();
        myList.add(new String("test1"));
        myList.add(new String("test4"));
        myList.add(new String("test2"));
        myList.add(new String("test3"));
        myList.add(new String("test4"));
        myList.add(new String("test5"));
        myList.add(new String("test4"));
        assertEquals(7, myList.size());
        assertEquals(expectedListBeforeDeleting, myList);

        myList.remove("test4");

        assertEquals(4, myList.size());
        assertEquals(expectedList, myList);

    }

    @Test
    public void testRemoveByObject_wrongObject() {

        String[] array = new String[]{"test1", "test2", "test3", "test4", "test5", null, null, null, null, null};
        ArrayList expectedList = new ArrayList(array, 5);

        ArrayList myList = new ArrayList();
        myList.add(new String("test1"));
        myList.add(new String("test2"));
        myList.add(new String("test3"));
        myList.add(new String("test4"));
        myList.add(new String("test5"));

        myList.remove("wrongObject");

        assertEquals(5, myList.size());
        assertEquals(expectedList, myList);

    }

}