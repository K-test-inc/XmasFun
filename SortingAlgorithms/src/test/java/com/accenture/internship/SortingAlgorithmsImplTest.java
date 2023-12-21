package com.accenture.internship;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class SortingAlgorithmsImplTest {

    @Test
    void testBubbleSort_emptyArray() {

        SortingAlgorithmsImpl<Integer> sortingAlgorithms = new SortingAlgorithmsImpl<>();
        Integer[] expectedArray = new Integer[]{};

        Integer[] array = new Integer[]{};

        sortingAlgorithms.bubbleSort(array);

        assertArrayEquals(expectedArray, array);
    }

    @Test
    void testBubbleSort_OneElementArray() {

        SortingAlgorithmsImpl<Integer> sortingAlgorithms = new SortingAlgorithmsImpl<>();
        Integer[] expectedArray = new Integer[]{1};

        Integer[] array = new Integer[]{1};

        sortingAlgorithms.bubbleSort(array);

        assertArrayEquals(expectedArray, array);
    }

    @Test
    void testBubbleSort_Integers() {

        SortingAlgorithmsImpl<Integer> sortingAlgorithms = new SortingAlgorithmsImpl<>();
        Integer[] expectedArray = new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 100};

        Integer[] array = new Integer[]{1, 4, 100, 6, 8, 3, 11, 2, 10, 5, 7, 9};

        sortingAlgorithms.bubbleSort(array);

        assertArrayEquals(expectedArray, array);
    }

    @Test
    void testBubbleSort_Strings() {

        SortingAlgorithmsImpl<String> sortingAlgorithms = new SortingAlgorithmsImpl<>();
        String[] expectedArray = new String[]{"test1", "test10", "test100","test11", "test2", "test3", "test4", "test5", "test6", "test7", "test8", "test9"};

        String[] array = new String[]{"test1", "test4", "test100", "test6", "test8", "test3", "test11", "test2", "test10", "test5", "test7", "test9"};

        sortingAlgorithms.bubbleSort(array);

        assertArrayEquals(expectedArray, array);
    }

    @Test
    void testSelectionSort_emptyArray() {

        SortingAlgorithmsImpl<Integer> sortingAlgorithms = new SortingAlgorithmsImpl<>();
        Integer[] expectedArray = new Integer[]{};

        Integer[] array = new Integer[]{};

        sortingAlgorithms.selectionSort(array);

        assertArrayEquals(expectedArray, array);
    }

    @Test
    void testSelectionSort_OneElementArray() {

        SortingAlgorithmsImpl<Integer> sortingAlgorithms = new SortingAlgorithmsImpl<>();
        Integer[] expectedArray = new Integer[]{1};

        Integer[] array = new Integer[]{1};

        sortingAlgorithms.selectionSort(array);

        assertArrayEquals(expectedArray, array);
    }

    @Test
    void testSelectionSort_Integers() {

        SortingAlgorithmsImpl<Integer> sortingAlgorithms = new SortingAlgorithmsImpl<>();
        Integer[] expectedArray = new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 100};

        Integer[] array = new Integer[]{1, 4, 100, 6, 8, 3, 11, 2, 10, 5, 7, 9};

        sortingAlgorithms.selectionSort(array);

        assertArrayEquals(expectedArray, array);
    }

    @Test
    void testSelectionSort_Strings() {

        SortingAlgorithmsImpl<String> sortingAlgorithms = new SortingAlgorithmsImpl<>();
        String[] expectedArray = new String[]{"test1", "test10", "test100","test11", "test2", "test3", "test4", "test5", "test6", "test7", "test8", "test9"};

        String[] array = new String[]{"test1", "test4", "test100", "test6", "test8", "test3", "test11", "test2", "test10", "test5", "test7", "test9"};

        sortingAlgorithms.selectionSort(array);

        assertArrayEquals(expectedArray, array);
    }

    @Test
    void testMergeSort_emptyArray() {

        SortingAlgorithmsImpl<Integer> sortingAlgorithms = new SortingAlgorithmsImpl<>();
        Integer[] expectedArray = new Integer[]{};

        Integer[] array = new Integer[]{};

        sortingAlgorithms.mergeSort(array);

        assertArrayEquals(expectedArray, array);
    }

    @Test
    void testMergeSort_OneElementArray() {

        SortingAlgorithmsImpl<Integer> sortingAlgorithms = new SortingAlgorithmsImpl<>();
        Integer[] expectedArray = new Integer[]{1};

        Integer[] array = new Integer[]{1};

        sortingAlgorithms.mergeSort(array);

        assertArrayEquals(expectedArray, array);
    }

    @Test
    void testMergeSort_Integers() {

        SortingAlgorithmsImpl<Integer> sortingAlgorithms = new SortingAlgorithmsImpl<>();
        Integer[] expectedArray = new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 100};

        Integer[] array = new Integer[]{1, 4, 100, 6, 8, 3, 11, 2, 10, 5, 7, 9};

        sortingAlgorithms.mergeSort(array);

        assertArrayEquals(expectedArray, array);
    }

    @Test
    void testMergeSort_Strings() {

        SortingAlgorithmsImpl<String> sortingAlgorithms = new SortingAlgorithmsImpl<>();
        String[] expectedArray = new String[]{"test1", "test10", "test100","test11", "test2", "test3", "test4", "test5", "test6", "test7", "test8", "test9"};

        String[] array = new String[]{"test1", "test4", "test100", "test6", "test8", "test3", "test11", "test2", "test10", "test5", "test7", "test9"};

        sortingAlgorithms.mergeSort(array);

        assertArrayEquals(expectedArray, array);
    }

    @Test
    void testQuickSort_emptyArray() {

        SortingAlgorithmsImpl<Integer> sortingAlgorithms = new SortingAlgorithmsImpl<>();
        Integer[] expectedArray = new Integer[]{};

        Integer[] array = new Integer[]{};

        sortingAlgorithms.quickSort(array);

        assertArrayEquals(expectedArray, array);
    }

    @Test
    void testQuickSort_OneElementArray() {

        SortingAlgorithmsImpl<Integer> sortingAlgorithms = new SortingAlgorithmsImpl<>();
        Integer[] expectedArray = new Integer[]{1};

        Integer[] array = new Integer[]{1};

        sortingAlgorithms.quickSort(array);

        assertArrayEquals(expectedArray, array);
    }

    @Test
    void testQuickSort_Integers() {

        SortingAlgorithmsImpl<Integer> sortingAlgorithms = new SortingAlgorithmsImpl<>();
        Integer[] expectedArray = new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 100};

        Integer[] array = new Integer[]{1, 4, 100, 6, 8, 3, 11, 2, 10, 5, 7, 9};

        sortingAlgorithms.quickSort(array);

        assertArrayEquals(expectedArray, array);
    }

    @Test
    void testQuickSort_Strings() {

        SortingAlgorithmsImpl<String> sortingAlgorithms = new SortingAlgorithmsImpl<>();
        String[] expectedArray = new String[]{"test1", "test10", "test100","test11", "test2", "test3", "test4", "test5", "test6", "test7", "test8", "test9"};

        String[] array = new String[]{"test1", "test4", "test100", "test6", "test8", "test3", "test11", "test2", "test10", "test5", "test7", "test9"};

        sortingAlgorithms.quickSort(array);

        assertArrayEquals(expectedArray, array);
    }
}