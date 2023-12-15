package com.accenture.internship.queueImpl;

import org.junit.jupiter.api.*;

import java.io.*;

import static org.junit.jupiter.api.Assertions.*;

class PriorityQueueTest {


    @Test
    void testIsEmpty_queueEmpty() {

        String[] array = new String[]{null, null, null, null, null, null, null, null, null, null};
        PriorityQueue<String> expectedQueue = new PriorityQueue<>(array, 0, -1, -1);

        PriorityQueue<String> queue = new PriorityQueue<>();

        assertTrue(queue.isEmpty());
        assertEquals(0, queue.getSize());
        assertEquals(-1, queue.getHead());
        assertEquals(-1, queue.getTail());
        assertEquals(expectedQueue, queue);
    }

    @Test
    void testIsEmpty_queueNotEmpty() {

        PriorityQueue<String> queue = new PriorityQueue<>();

        queue.setSize(2);

        assertFalse(queue.isEmpty());
        assertEquals(2, queue.getSize());

    }

    @Test
    void testIsFull_queueIsFull() {

        PriorityQueue<String> queue = new PriorityQueue<>();
        queue.setSize(10);

        assertTrue(queue.isFull());
        assertEquals(10, queue.getSize());

    }

    @Test
    void testIsFull_queueisEmpty() {

        PriorityQueue<String> queue = new PriorityQueue<>();

        assertFalse(queue.isFull());
        assertEquals(0, queue.getSize());

    }

    @Test
    void testIsFull_queueNotFull() {

        PriorityQueue<String> queue = new PriorityQueue<>();
        queue.setSize(5);

        assertFalse(queue.isFull());
        assertEquals(5, queue.getSize());

    }

    @Test
    void testAddNull() {

        String[] array = new String[]{null, null, null, null, null, null, null, null, null, null};
        PriorityQueue<String> expectedQueue = new PriorityQueue<>(array, 0, -1, -1);

        PriorityQueue<String> queue = new PriorityQueue<>();
        assertFalse(queue.add(null));
        assertEquals(0, queue.getSize());
        assertEquals(-1, queue.getHead());
        assertEquals(-1, queue.getTail());
        assertEquals(expectedQueue, queue);
    }

    @Test
    void testAdd_queueIsFull() {

        PriorityQueue<String> queue = new PriorityQueue<>();
        queue.setSize(10);

        assertTrue(queue.isFull());
        assertEquals(10, queue.getSize());
    }

    @Test
    void testAddFirstElement_withoutPriority() {

        String[] array = new String[]{"test1", null, null, null, null, null, null, null, null, null};
        PriorityQueue<String> expectedQueue = new PriorityQueue<>(array, 1, 0, 0);

        PriorityQueue<String> queue = new PriorityQueue<>();

        assertTrue(queue.add("test1"));

        assertEquals(1, queue.getSize());
        assertEquals(expectedQueue, queue);

    }

    @Test
    void testAddFiveElements_withoutPriority() {

        String[] array = new String[]{"test1", "test2", "test3", "test4", "test5", null, null, null, null, null};
        PriorityQueue<String> expectedQueue = new PriorityQueue<>(array, 5, 0, 4);

        PriorityQueue<String> queue = new PriorityQueue<>();

        assertTrue(queue.add("test1"));
        assertTrue(queue.add("test2"));
        assertTrue(queue.add("test3"));
        assertTrue(queue.add("test4"));
        assertTrue(queue.add("test5"));

        assertEquals(5, queue.getSize());
        assertEquals(expectedQueue, queue);

    }

    @Test
    void testPeek_queueEmpty() {

        Queue<String> queue = new PriorityQueue<>();
        assertNull(queue.peek());

    }

    @Test
    void testPeek_queueNotEmpty() {

        PriorityQueue<String> queue = new PriorityQueue<>();
        queue.add("test1");
        queue.add("test2");
        queue.add("test3");

        assertEquals("test1", queue.peek());
        assertEquals("test1", queue.peek());
        assertEquals(3, queue.getSize());
        assertEquals(0, queue.getHead());
        assertEquals(2, queue.getTail());
    }

    @Test
    void TestPool_queueEmpty(){

        PriorityQueue<String> queue = new PriorityQueue<>();

        assertNull(queue.poll());

    }

    @Test
    void TestPool_queueNotEmpty_withoutPriority(){

        String[] array = new String[]{null, null, "test3", "test4", "test5", null, null, null, null, null};
        PriorityQueue<String> expectedQueue = new PriorityQueue<>(array, 3, 2, 4);

        PriorityQueue<String> queue = new PriorityQueue<>();

        queue.add("test1");
        queue.add("test2");
        queue.add("test3");
        queue.add("test4");
        queue.add("test5");

        assertEquals("test1", queue.poll());
        assertEquals("test2", queue.poll());
        assertEquals(3, queue.getSize());
        assertEquals(expectedQueue, queue);

    }

    @Test
    void TestPool_removeLast_withoutPriority(){

        String[] array = new String[]{null, null, null, null, null, null, null, null, null, null};
        PriorityQueue<String> expectedQueue = new PriorityQueue<>(array, 0, -1, -1);

        PriorityQueue<String> queue = new PriorityQueue<>();

        queue.add("test1");
        queue.add("test2");

        assertEquals("test1", queue.poll());
        assertEquals("test2", queue.poll());
        assertEquals(0, queue.getSize());
        assertEquals(expectedQueue, queue);

    }

    @Test
    void testAdd_AfterTwoTimesPoolWhenQueueWillNotEmpty_withoutPriority() {

        String[] array = new String[]{null, null, "test3", "test4", null, null, null, null, null, null};
        PriorityQueue<String> expectedQueue = new PriorityQueue<>(array, 2, 2, 3);

        PriorityQueue<String> queue = new PriorityQueue<>();
        queue.add("test1");
        queue.add("test2");
        queue.add("test3");
        queue.poll();
        queue.poll();
        queue.add("test4");

        assertEquals(2, queue.getSize());
        assertEquals(2, queue.getHead());
        assertEquals(3, queue.getTail());
        assertEquals(expectedQueue, queue);
    }

    @Test
    void testAdd_AfterFourTimesPoolWhenQueueWasFully_withoutPriority() {

        String[] array = new String[]{"test11", "test12", null, null, "test5", "test6", "test7", "test8", "test9", "test10"};
        PriorityQueue<String> expectedQueue = new PriorityQueue<>(array, 8, 4, 1);

        PriorityQueue<String> queue = new PriorityQueue<>();
        queue.add("test1");
        queue.add("test2");
        queue.add("test3");
        queue.add("test4");
        queue.add("test5");
        queue.add("test6");
        queue.add("test7");
        queue.add("test8");
        queue.add("test9");
        queue.add("test10");
        queue.poll();
        queue.poll();
        queue.poll();
        queue.poll();
        queue.add("test11");
        queue.add("test12");

        assertEquals(8, queue.getSize());
        assertEquals(4, queue.getHead());
        assertEquals(1, queue.getTail());
        assertEquals(expectedQueue, queue);
    }

    @Test
    void testAdd_AfterFourTimesPoolWhenQueueWillFully_withoutPriority() {

        String[] array = new String[]{"test11", "test12", "test13", "test14", "test5", "test6", "test7", "test8", "test9", "test10"};
        PriorityQueue<String> expectedQueue = new PriorityQueue<>(array, 10, 4, 3);

        PriorityQueue<String> queue = new PriorityQueue<>();
        queue.add("test1");
        queue.add("test2");
        queue.add("test3");
        queue.add("test4");
        queue.add("test5");
        queue.add("test6");
        queue.add("test7");
        queue.add("test8");
        queue.add("test9");
        queue.add("test10");
        queue.poll();
        queue.poll();
        queue.poll();
        queue.poll();
        queue.add("test11");
        queue.add("test12");
        queue.add("test13");
        queue.add("test14");

        assertFalse(queue.add("test15"));

        assertEquals(10, queue.getSize());
        assertEquals(4, queue.getHead());
        assertEquals(3, queue.getTail());
        assertEquals(expectedQueue, queue);
    }


    @Test
    void testAdd_whenQueueEmpty_withPriority() {

        String[] array = new String[]{"1test", "2test", null, null, null, null, null, null, null, null};
        PriorityQueue<String> expectedQueue = new PriorityQueue<>(array, 2, 0, 1);

        PriorityQueue<String> queue = new PriorityQueue<>();
        queue.add("1test");
        queue.add("2test");

        assertEquals(2, queue.getSize());
        assertEquals(0, queue.getHead());
        assertEquals(1, queue.getTail());
        assertEquals(expectedQueue, queue);
    }

    @Test
    void testAdd_withPriority() {

        String[] array = new String[]{"1test", "2test", "22test", "3test", "4test", "5test", "6test", "7test", "8test", "9test"};
        PriorityQueue<String> expectedQueue = new PriorityQueue<>(array, 10, 0, 9);

        PriorityQueue<String> queue = new PriorityQueue<>();
        queue.add("1test");
        queue.add("2test");
        queue.add("9test");
        queue.add("6test");
        queue.add("3test");
        queue.add("5test");
        queue.add("4test");
        queue.add("7test");
        queue.add("8test");
        queue.add("22test");

        assertEquals(10, queue.getSize());
        assertEquals(0, queue.getHead());
        assertEquals(9, queue.getTail());
        assertEquals(expectedQueue, queue);
    }

    @Test
    void testAddAndPool_withPriority() {

        String[] array = new String[]{null, null, null, null, null, "5test", "6test", "7test", "8test", "9test"};
        PriorityQueue<String> expectedQueue = new PriorityQueue<>(array, 5, 5, 9);

        PriorityQueue<String> queue = new PriorityQueue<>();
        queue.add("1test");
        queue.add("2test");
        queue.add("9test");
        queue.add("6test");
        queue.add("3test");
        queue.add("5test");
        queue.add("4test");
        queue.add("7test");
        queue.add("8test");
        queue.add("22test");
        assertEquals("1test", queue.poll());
        assertEquals("2test", queue.poll());
        assertEquals("22test", queue.poll());
        assertEquals("3test", queue.poll());
        assertEquals("4test", queue.poll());

        assertEquals(5, queue.getSize());
        assertEquals(5, queue.getHead());
        assertEquals(9, queue.getTail());
        assertEquals(expectedQueue, queue);
    }

    @Test
    void testAddFullyQueuePoolAllAndAddNewFourElement_withPriority() {

        String[] array = new String[]{"0test", "2test", "3test", "4test", null, null, null, null, null, null};
        PriorityQueue<String> expectedQueue = new PriorityQueue<>(array, 4, 0, 3);
        PriorityQueue<String> queue = new PriorityQueue<>();
        queue.add("1test");
        queue.add("2test");
        queue.add("9test");
        queue.add("6test");
        queue.add("3test");
        queue.add("5test");
        queue.add("4test");
        queue.add("7test");
        queue.add("8test");
        queue.add("22test");

        assertEquals("1test", queue.poll());
        assertEquals("2test", queue.poll());
        assertEquals("22test", queue.poll());
        assertEquals("3test", queue.poll());
        assertEquals("4test", queue.poll());
        assertEquals("5test", queue.poll());
        assertEquals("6test", queue.poll());
        assertEquals("7test", queue.poll());
        assertEquals("8test", queue.poll());
        assertEquals("9test", queue.poll());

        queue.add("2test");
        queue.add("4test");
        queue.add("3test");
        queue.add("0test");

        assertEquals(4, queue.getSize());
        assertEquals(0, queue.getHead());
        assertEquals(3, queue.getTail());
        assertEquals(expectedQueue, queue);

    }

    @Test
    void testAddFullyQueuePoolSixAndAddNewFourElement_withPriority() {

        String[] array = new String[]{"6test", "7test", "8test", "9test", null, null, "0test", "2test", "3test", "4test"};
        PriorityQueue<String> expectedQueue = new PriorityQueue<>(array, 8, 6, 3);
        PriorityQueue<String> queue = new PriorityQueue<>();
        queue.add("1test");
        queue.add("2test");
        queue.add("9test");
        queue.add("6test");
        queue.add("3test");
        queue.add("5test");
        queue.add("4test");
        queue.add("7test");
        queue.add("8test");
        queue.add("22test");

        assertEquals("1test", queue.poll());
        assertEquals("2test", queue.poll());
        assertEquals("22test", queue.poll());
        assertEquals("3test", queue.poll());
        assertEquals("4test", queue.poll());
        assertEquals("5test", queue.poll());

        queue.add("2test");
        queue.add("4test");
        queue.add("3test");
        queue.add("0test");

        assertEquals(8, queue.getSize());
        assertEquals(6, queue.getHead());
        assertEquals(3, queue.getTail());
        assertEquals(expectedQueue, queue);
    }

    @Test
    void testAddFullyQueuePoolSixAndAddNewFourElementAndPoolSix_withPriority() {

        String[] array = new String[]{null, null, "8test", "9test", null, null, null, null, null, null};
        PriorityQueue<String> expectedQueue = new PriorityQueue<>(array, 2, 2, 3);
        PriorityQueue<String> queue = new PriorityQueue<>();
        queue.add("1test");
        queue.add("2test");
        queue.add("9test");
        queue.add("6test");
        queue.add("3test");
        queue.add("5test");
        queue.add("4test");
        queue.add("7test");
        queue.add("8test");
        queue.add("22test");

        assertEquals("1test", queue.poll());
        assertEquals("2test", queue.poll());
        assertEquals("22test", queue.poll());
        assertEquals("3test", queue.poll());
        assertEquals("4test", queue.poll());
        assertEquals("5test", queue.poll());

        queue.add("2test");
        queue.add("4test");
        queue.add("3test");
        queue.add("0test");

        assertEquals("0test", queue.poll());
        assertEquals("2test", queue.poll());
        assertEquals("3test", queue.poll());
        assertEquals("4test", queue.poll());
        assertEquals("6test", queue.poll());
        assertEquals("7test", queue.poll());

        assertEquals(2, queue.getSize());
        assertEquals(2, queue.getHead());
        assertEquals(3, queue.getTail());
        assertEquals(expectedQueue, queue);
    }

    @Test
    void testAddFullyQueuePoolSixAndAddNewFourElementAndPoolSix_withPriority_Digital() {

        Integer[] array = new Integer[]{null, null, 8, 9, null, null, null, null, null, null};
        PriorityQueue<Integer> expectedQueue = new PriorityQueue<>(array, 2, 2, 3);
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        queue.add(1);
        queue.add(2);
        queue.add(9);
        queue.add(6);
        queue.add(3);
        queue.add(5);
        queue.add(4);
        queue.add(7);
        queue.add(8);
        queue.add(22);

        assertEquals(1, queue.poll());
        assertEquals(2, queue.poll());
        assertEquals(22, queue.poll());
        assertEquals(3, queue.poll());
        assertEquals(4, queue.poll());
        assertEquals(5, queue.poll());

        queue.add(2);
        queue.add(4);
        queue.add(3);
        queue.add(0);

        assertEquals(0, queue.poll());
        assertEquals(2, queue.poll());
        assertEquals(3, queue.poll());
        assertEquals(4, queue.poll());
        assertEquals(6, queue.poll());
        assertEquals(7, queue.poll());

        assertEquals(2, queue.getSize());
        assertEquals(2, queue.getHead());
        assertEquals(3, queue.getTail());
        assertEquals(expectedQueue, queue);
    }

    @Test
    void testPrintArray_ArrayIsEmpty() {

        String expectedOutput = "Queue is empty";

        PriorityQueue<String> queue = new PriorityQueue<>();

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        queue.queueDisplay();
        String actualOutput = outputStream.toString().trim();
        System.setOut(System.out);

        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    void testPrintArrayAfterRemove_ArrayWasFully() {

        StringBuilder builder = new StringBuilder();
        builder.append("8test").append(System.lineSeparator())
                .append("9test");
        String expectedOutput = builder.toString();

        PriorityQueue<String> queue = new PriorityQueue<>();
        queue.add("1test");
        queue.add("2test");
        queue.add("9test");
        queue.add("6test");
        queue.add("3test");
        queue.add("5test");
        queue.add("4test");
        queue.add("7test");
        queue.add("8test");
        queue.add("22test");

        assertEquals("1test", queue.poll());
        assertEquals("2test", queue.poll());
        assertEquals("22test", queue.poll());
        assertEquals("3test", queue.poll());
        assertEquals("4test", queue.poll());
        assertEquals("5test", queue.poll());

        queue.add("2test");
        queue.add("4test");
        queue.add("3test");
        queue.add("0test");

        assertEquals("0test", queue.poll());
        assertEquals("2test", queue.poll());
        assertEquals("3test", queue.poll());
        assertEquals("4test", queue.poll());
        assertEquals("6test", queue.poll());
        assertEquals("7test", queue.poll());

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        queue.queueDisplay();
        String actualOutput = outputStream.toString().trim();
        System.setOut(System.out);

        assertEquals(expectedOutput, actualOutput);


    }

}