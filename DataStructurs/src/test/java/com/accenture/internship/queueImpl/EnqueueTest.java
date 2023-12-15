package com.accenture.internship.queueImpl;

import org.junit.jupiter.api.*;

import java.io.*;

import static org.junit.jupiter.api.Assertions.*;

class EnqueueTest {

    @Test
    void testIsEmpty_arrayEmpty() {

        String[] array = new String[]{null, null, null, null, null, null, null, null, null, null};
        Enqueue<String> expectedEnqueue = new Enqueue<>(array, 0, -1, -1);

        Enqueue<String> enqueue = new Enqueue<>();
        assertTrue(enqueue.isEmpty());
        assertEquals(0, enqueue.getSize());
        assertEquals(-1, enqueue.getHead());
        assertEquals(-1, enqueue.getTail());
        assertEquals(expectedEnqueue, enqueue);
    }

    @Test
    void testIsEmpty_arrayNotEmpty() {

        String[] array = new String[]{"test1", null, null, null, null, null, null, null, null, null};
        Enqueue<String> expectedEnqueue = new Enqueue<>(array, 1, 0, 0);

        Enqueue<String> enqueue = new Enqueue<>();
        enqueue.add("test1");
        assertFalse(enqueue.isEmpty());
        assertEquals(1, enqueue.getSize());
        assertEquals(0, enqueue.getHead());
        assertEquals(0, enqueue.getTail());
        assertEquals(expectedEnqueue, enqueue);
    }

    @Test
    void testIsFull_arrayFull() {

        String[] array = new String[]{"test1", "test2", "test3", "test4", "test5", "test6", "test7", "test8", "test9", "test10"};
        Enqueue<String> expectedEnqueue = new Enqueue<>(array, 10, 0, 9);

        Enqueue<String> enqueue = new Enqueue<>();
        enqueue.add("test1");
        enqueue.add("test2");
        enqueue.add("test3");
        enqueue.add("test4");
        enqueue.add("test5");
        enqueue.add("test6");
        enqueue.add("test7");
        enqueue.add("test8");
        enqueue.add("test9");
        enqueue.add("test10");
        assertTrue(enqueue.isFull());
        assertEquals(10, enqueue.getSize());
        assertEquals(0, enqueue.getHead());
        assertEquals(9, enqueue.getTail());
        assertEquals(expectedEnqueue, enqueue);
    }

    @Test
    void testIsFull_arrayEmpty() {

        String[] array = new String[]{null, null, null, null, null, null, null, null, null, null};
        Enqueue<String> expectedEnqueue = new Enqueue<>(array, 0, -1, -1);

        Enqueue<String> enqueue = new Enqueue<>();
        assertFalse(enqueue.isFull());
        assertEquals(0, enqueue.getSize());
        assertEquals(-1, enqueue.getHead());
        assertEquals(-1, enqueue.getTail());
        assertEquals(expectedEnqueue, enqueue);
    }

    @Test
    void testIsFull_arrayNotFull() {

        String[] array = new String[]{"test1", "test2", "test3", "test4", "test5", "test6", "test7", "test8", "test9", null};
        Enqueue<String> expectedEnqueue = new Enqueue<>(array, 9, 0, 8);

        Enqueue<String> enqueue = new Enqueue<>();
        enqueue.add("test1");
        enqueue.add("test2");
        enqueue.add("test3");
        enqueue.add("test4");
        enqueue.add("test5");
        enqueue.add("test6");
        enqueue.add("test7");
        enqueue.add("test8");
        enqueue.add("test9");
        assertFalse(enqueue.isFull());
        assertEquals(9, enqueue.getSize());
        assertEquals(0, enqueue.getHead());
        assertEquals(8, enqueue.getTail());
        assertEquals(expectedEnqueue, enqueue);
    }

    @Test
    void testAddNull() {

        String[] array = new String[]{null, null, null, null, null, null, null, null, null, null};
        Enqueue<String> expectedEnqueue = new Enqueue<>(array, 0, -1, -1);

        Enqueue<String> enqueue = new Enqueue<>();
        assertFalse(enqueue.add(null));
        assertEquals(0, enqueue.getSize());
        assertEquals(-1, enqueue.getHead());
        assertEquals(-1, enqueue.getTail());
        assertEquals(expectedEnqueue, enqueue);
    }
    @Test
    void testAdd_arrayEmpty() {

        String[] array = new String[]{"test1", null, null, null, null, null, null, null, null, null};
        Enqueue<String> expectedEnqueue = new Enqueue<>(array, 1, 0, 0);

        Enqueue<String> enqueue = new Enqueue<>();
        assertTrue(enqueue.add("test1"));
        assertEquals(1, enqueue.getSize());
        assertEquals(0, enqueue.getHead());
        assertEquals(0, enqueue.getTail());
        assertEquals(expectedEnqueue, enqueue);
    }

    @Test
    void testAdd_arrayNotEmpty() {

        String[] array = new String[]{"test1", "test2", "test3", null, null, null, null, null, null, null};
        Enqueue<String> expectedEnqueue = new Enqueue<>(array, 3, 0, 2);

        Enqueue<String> enqueue = new Enqueue<>();
        enqueue.add("test1");
        enqueue.add("test2");
        assertTrue(enqueue.add("test3"));
        assertEquals(3, enqueue.getSize());
        assertEquals(0, enqueue.getHead());
        assertEquals(2, enqueue.getTail());
        assertEquals(expectedEnqueue, enqueue);
    }

    @Test
    void testAdd_arrayFull() {

        String[] array = new String[]{"test1", "test2", "test3", "test4", "test5", "test6", "test7", "test8", "test9", "test10"};
        Enqueue<String> expectedEnqueue = new Enqueue<>(array, 10, 0, 9);

        Enqueue<String> enqueue = new Enqueue<>();
        enqueue.add("test1");
        enqueue.add("test2");
        enqueue.add("test3");
        enqueue.add("test4");
        enqueue.add("test5");
        enqueue.add("test6");
        enqueue.add("test7");
        enqueue.add("test8");
        enqueue.add("test9");
        enqueue.add("test10");
        assertFalse(enqueue.add("test11"));
        assertEquals(10, enqueue.getSize());
        assertEquals(0, enqueue.getHead());
        assertEquals(9, enqueue.getTail());
        assertEquals(expectedEnqueue, enqueue);
    }

    @Test
    void testPeek_arrayEmpty() {

        String[] array = new String[]{null, null, null, null, null, null, null, null, null, null};
        Enqueue<String> expectedEnqueue = new Enqueue<>(array, 0, -1, -1);

        Enqueue<String> enqueue = new Enqueue<>();
        assertNull(enqueue.peek());
        assertEquals(0, enqueue.getSize());
        assertEquals(-1, enqueue.getHead());
        assertEquals(-1, enqueue.getTail());
        assertEquals(expectedEnqueue, enqueue);
    }

    @Test
    void testPeek_arrayFull() {

        String[] array = new String[]{"test1", "test2", "test3", "test4", "test5", "test6", "test7", "test8", "test9", "test10"};
        Enqueue<String> expectedEnqueue = new Enqueue<>(array, 10, 0, 9);

        Enqueue<String> enqueue = new Enqueue<>();
        enqueue.add("test1");
        enqueue.add("test2");
        enqueue.add("test3");
        enqueue.add("test4");
        enqueue.add("test5");
        enqueue.add("test6");
        enqueue.add("test7");
        enqueue.add("test8");
        enqueue.add("test9");
        enqueue.add("test10");
        assertEquals("test1", enqueue.peek());
        assertEquals(10, enqueue.getSize());
        assertEquals(0, enqueue.getHead());
        assertEquals(9, enqueue.getTail());
        assertEquals(expectedEnqueue, enqueue);
    }

    @Test
    void testPeek_arrayNotFullBehind() {

        String[] array = new String[]{"test1", "test2", "test3", "test4", null, null, null, null, null, null};
        Enqueue<String> expectedEnqueue = new Enqueue<>(array, 4, 0, 3);

        Enqueue<String> enqueue = new Enqueue<>();
        enqueue.add("test1");
        enqueue.add("test2");
        enqueue.add("test3");
        enqueue.add("test4");

        assertEquals("test1", enqueue.peek());
        assertEquals(4, enqueue.getSize());
        assertEquals(0, enqueue.getHead());
        assertEquals(3, enqueue.getTail());
        assertEquals(expectedEnqueue, enqueue);
    }

    @Test
    void testPool_arrayEmpty() {

        String[] array = new String[]{null, null, null, null, null, null, null, null, null, null};
        Enqueue<String> expectedEnqueue = new Enqueue<>(array, 0, -1, -1);

        Enqueue<String> enqueue = new Enqueue<>();

        assertNull(enqueue.poll());
        assertEquals(0, enqueue.getSize());
        assertEquals(-1, enqueue.getHead());
        assertEquals(-1, enqueue.getTail());
        assertEquals(expectedEnqueue, enqueue);
    }

    @Test
    void testPool_arrayNotEmpty() {

        String[] array = new String[]{null, "test2", "test3", "test4", "test5", null, null, null, null, null};
        Enqueue<String> expectedEnqueue = new Enqueue<>(array, 4, 1, 4);

        Enqueue<String> enqueue = new Enqueue<>();
        enqueue.add("test1");
        enqueue.add("test2");
        enqueue.add("test3");
        enqueue.add("test4");
        enqueue.add("test5");

        assertEquals("test1", enqueue.poll());
        assertEquals(4, enqueue.getSize());
        assertEquals(1, enqueue.getHead());
        assertEquals(4, enqueue.getTail());
        assertEquals(expectedEnqueue, enqueue);
    }

    @Test
    void testPoolTwoTimes_arrayNotEmpty() {

        String[] array = new String[]{null, null, "test3", "test4", "test5", null, null, null, null, null};
        Enqueue<String> expectedEnqueue = new Enqueue<>(array, 3, 2, 4);

        Enqueue<String> enqueue = new Enqueue<>();
        enqueue.add("test1");
        enqueue.add("test2");
        enqueue.add("test3");
        enqueue.add("test4");
        enqueue.add("test5");

        assertEquals("test1", enqueue.poll());
        assertEquals("test2", enqueue.poll());
        assertEquals(3, enqueue.getSize());
        assertEquals(2, enqueue.getHead());
        assertEquals(4, enqueue.getTail());
        assertEquals(expectedEnqueue, enqueue);
    }

    @Test
    void testPoolSixTimes_arrayNotEmpty() {

        String[] array = new String[]{null, null, null, null, null, null, null, null, null, null};
        Enqueue<String> expectedEnqueue = new Enqueue<>(array, 0, -1, -1);

        Enqueue<String> enqueue = new Enqueue<>();
        enqueue.add("test1");
        enqueue.add("test2");
        enqueue.add("test3");
        enqueue.add("test4");
        enqueue.add("test5");

        assertEquals("test1", enqueue.poll());
        assertEquals("test2", enqueue.poll());
        assertEquals("test3", enqueue.poll());
        assertEquals("test4", enqueue.poll());
        assertEquals("test5", enqueue.poll());
        assertNull(enqueue.poll());
        assertEquals(0, enqueue.getSize());
        assertEquals(-1, enqueue.getHead());
        assertEquals(-1, enqueue.getTail());
        assertEquals(expectedEnqueue, enqueue);
    }

    @Test
    void testAdd_AfterPoolWhenArrayWillEmpty() {

        String[] array = new String[]{"test2", null, null, null, null, null, null, null, null, null};
        Enqueue<String> expectedEnqueue = new Enqueue<>(array, 1, 0, 0);

        Enqueue<String> enqueue = new Enqueue<>();
        enqueue.add("test1");
        enqueue.poll();
        enqueue.add("test2");

        assertEquals(1, enqueue.getSize());
        assertEquals(0, enqueue.getHead());
        assertEquals(0, enqueue.getTail());
        assertEquals(expectedEnqueue, enqueue);
    }

    @Test
    void testAdd_AfterPoolWhenArrayWillNotEmpty() {

        String[] array = new String[]{null, "test2", "test3", "test4", null, null, null, null, null, null};
        Enqueue<String> expectedEnqueue = new Enqueue<>(array, 3, 1, 3);

        Enqueue<String> enqueue = new Enqueue<>();
        enqueue.add("test1");
        enqueue.add("test2");
        enqueue.poll();
        enqueue.add("test3");
        enqueue.add("test4");

        assertEquals(3, enqueue.getSize());
        assertEquals(1, enqueue.getHead());
        assertEquals(3, enqueue.getTail());
        assertEquals(expectedEnqueue, enqueue);
    }

    @Test
    void testAdd_AfterTwoTimesPoolWhenArrayWillNotEmpty() {

        String[] array = new String[]{null, null, "test3", "test4", null, null, null, null, null, null};
        Enqueue<String> expectedEnqueue = new Enqueue<>(array, 2, 2, 3);

        Enqueue<String> enqueue = new Enqueue<>();
        enqueue.add("test1");
        enqueue.add("test2");
        enqueue.add("test3");
        enqueue.poll();
        enqueue.poll();
        enqueue.add("test4");

        assertEquals(2, enqueue.getSize());
        assertEquals(2, enqueue.getHead());
        assertEquals(3, enqueue.getTail());
        assertEquals(expectedEnqueue, enqueue);
    }

    @Test
    void testAdd_AfterTwoTimesPoolWhenArrayWasFully() {

        String[] array = new String[]{"test11", null, "test3", "test4", "test5", "test6", "test7", "test8", "test9", "test10"};
        Enqueue<String> expectedEnqueue = new Enqueue<>(array, 9, 2, 0);

        Enqueue<String> enqueue = new Enqueue<>();
        enqueue.add("test1");
        enqueue.add("test2");
        enqueue.add("test3");
        enqueue.add("test4");
        enqueue.add("test5");
        enqueue.add("test6");
        enqueue.add("test7");
        enqueue.add("test8");
        enqueue.add("test9");
        enqueue.add("test10");
        enqueue.poll();
        enqueue.poll();
        enqueue.add("test11");

        assertEquals(9, enqueue.getSize());
        assertEquals(2, enqueue.getHead());
        assertEquals(0, enqueue.getTail());
        assertEquals(expectedEnqueue, enqueue);
    }

    @Test
    void testThreeTimesAdd_AfterTwoTimesPoolWhenArrayWasFully() {

        String[] array = new String[]{"test11", "test12", "test3", "test4", "test5", "test6", "test7", "test8", "test9", "test10"};
        Enqueue<String> expectedEnqueue = new Enqueue<>(array, 10, 2, 1);

        Enqueue<String> enqueue = new Enqueue<>();
        enqueue.add("test1");
        enqueue.add("test2");
        enqueue.add("test3");
        enqueue.add("test4");
        enqueue.add("test5");
        enqueue.add("test6");
        enqueue.add("test7");
        enqueue.add("test8");
        enqueue.add("test9");
        enqueue.add("test10");
        enqueue.poll();
        enqueue.poll();
        enqueue.add("test11");
        enqueue.add("test12");

        assertFalse(enqueue.add("test13"));
        assertEquals(10, enqueue.getSize());
        assertEquals(2, enqueue.getHead());
        assertEquals(1, enqueue.getTail());
        assertEquals(expectedEnqueue, enqueue);
    }

    @Test
    void testAddFullyQueuePoolSixAndAddNewFourElementAndPoolSix_withPriority() {

        String[] array = new String[]{null, null, "test13", "test14", null, null, null, null, null, null};
        Enqueue<String> expectedQueue = new Enqueue<>(array, 2, 2, 3);

        Enqueue<String> enqueue = new Enqueue<>();
        enqueue.add("test1");
        enqueue.add("test2");
        enqueue.add("test3");
        enqueue.add("test4");
        enqueue.add("test5");
        enqueue.add("test6");
        enqueue.add("test7");
        enqueue.add("test8");
        enqueue.add("test9");
        enqueue.add("test10");
        assertEquals("test1", enqueue.poll());
        assertEquals("test2", enqueue.poll());
        assertEquals("test3", enqueue.poll());
        assertEquals("test4", enqueue.poll());
        assertEquals("test5", enqueue.poll());
        assertEquals("test6", enqueue.poll());
        enqueue.add("test11");
        enqueue.add("test12");
        enqueue.add("test13");
        enqueue.add("test14");
        assertEquals("test7", enqueue.poll());
        assertEquals("test8", enqueue.poll());
        assertEquals("test9", enqueue.poll());
        assertEquals("test10", enqueue.poll());
        assertEquals("test11", enqueue.poll());
        assertEquals("test12", enqueue.poll());

    }

    @Test
    void testPrintArray_ArrayIsEmpty() {

        String expectedOutput = "Queue is empty";

        Enqueue<String> enqueue = new Enqueue<>();

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        enqueue.queueDisplay();
        String actualOutput = outputStream.toString().trim();
        System.setOut(System.out);

        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    void testPrintArray_ArrayNotEmpty() {

        StringBuilder builder = new StringBuilder();
        builder.append("test1").append(System.lineSeparator())
                .append("test2").append(System.lineSeparator())
                .append("test3").append(System.lineSeparator())
                .append("test4").append(System.lineSeparator())
                .append("test5");
        String expectedOutput = builder.toString();

        Enqueue<String> enqueue = new Enqueue<>();
        enqueue.add("test1");
        enqueue.add("test2");
        enqueue.add("test3");
        enqueue.add("test4");
        enqueue.add("test5");

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        enqueue.queueDisplay();
        String actualOutput = outputStream.toString().trim();
        System.setOut(System.out);

        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    void testPrintArrayAfterRemove_ArrayNotEmpty() {

        StringBuilder builder = new StringBuilder();
        builder.append("test2").append(System.lineSeparator())
                .append("test3").append(System.lineSeparator())
                .append("test4").append(System.lineSeparator())
                .append("test5");
        String expectedOutput = builder.toString();

        Enqueue<String> enqueue = new Enqueue<>();
        enqueue.add("test1");
        enqueue.add("test2");
        enqueue.add("test3");
        enqueue.add("test4");
        enqueue.add("test5");
        enqueue.poll();

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        enqueue.queueDisplay();
        String actualOutput = outputStream.toString().trim();
        System.setOut(System.out);

        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    void testPrintArrayAfterRemove_ArrayEmpty() {

        String expectedOutput = "Queue is empty";

        Enqueue<String> enqueue = new Enqueue<>();
        enqueue.add("test1");
        enqueue.add("test2");
        enqueue.add("test3");
        enqueue.add("test4");
        enqueue.add("test5");
        enqueue.poll();
        enqueue.poll();
        enqueue.poll();
        enqueue.poll();
        enqueue.poll();

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        enqueue.queueDisplay();
        String actualOutput = outputStream.toString().trim();
        System.setOut(System.out);

        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    void testPrintArrayAfterRemove_ArrayWasFully() {

        StringBuilder builder = new StringBuilder();
        builder.append("test4").append(System.lineSeparator())
                .append("test5").append(System.lineSeparator())
                .append("test6").append(System.lineSeparator())
                .append("test7").append(System.lineSeparator())
                .append("test8").append(System.lineSeparator())
                .append("test9").append(System.lineSeparator())
                .append("test10").append(System.lineSeparator())
                .append("test11").append(System.lineSeparator())
                .append("test12");
        String expectedOutput = builder.toString();

        Enqueue<String> enqueue = new Enqueue<>();
        enqueue.add("test1");
        enqueue.add("test2");
        enqueue.add("test3");
        enqueue.add("test4");
        enqueue.add("test5");
        enqueue.add("test6");
        enqueue.add("test7");
        enqueue.add("test8");
        enqueue.add("test9");
        enqueue.add("test10");
        enqueue.poll();
        enqueue.poll();
        enqueue.poll();
        enqueue.add("test11");
        enqueue.add("test12");


        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        enqueue.queueDisplay();
        String actualOutput = outputStream.toString().trim();
        System.setOut(System.out);

        assertEquals(expectedOutput, actualOutput);
    }
}