package com.accenture.internship;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        Integer[] array100 = arrayGeneration(100);
        Integer[] array1000 = arrayGeneration(1000);
        Integer[] array10000 = arrayGeneration(10000);
        Integer[] array100000 = arrayGeneration(100000);

        Integer[] bubbleSortArray100 = array100.clone();
        Integer[] bubbleSortArray1000 = array1000.clone();
        Integer[] bubbleSortArray10000 = array10000.clone();
        Integer[] bubbleSortArray100000 = array100000.clone();

        Integer[] selectionSortArray100 = array100.clone();
        Integer[] selectionSortArray1000 = array1000.clone();
        Integer[] selectionSortArray10000 = array10000.clone();
        Integer[] selectionSortArray100000 = array100000.clone();

        Integer[] mergeSortArray100 = array100.clone();
        Integer[] mergeSortArray1000 = array1000.clone();
        Integer[] mergeSortArray10000 = array10000.clone();
        Integer[] mergeSortArray100000 = array100000.clone();

        Integer[] quickSortArray100 = array100.clone();
        Integer[] quickSortArray1000 = array1000.clone();
        Integer[] quickSortArray10000 = array10000.clone();
        Integer[] quickSortArray100000 = array100000.clone();

        competeBubbleSort(bubbleSortArray100);
        competeSelectionSort(selectionSortArray100);
        competeMergeSort(mergeSortArray100);
        competeQuickSort(quickSortArray100);
        System.out.println("---------------------------------------------");
        competeBubbleSort(bubbleSortArray1000);
        competeSelectionSort(selectionSortArray1000);
        competeMergeSort(mergeSortArray1000);
        competeQuickSort(quickSortArray1000);
        System.out.println("---------------------------------------------");
        competeBubbleSort(bubbleSortArray10000);
        competeSelectionSort(selectionSortArray10000);
        competeMergeSort(mergeSortArray10000);
        competeQuickSort(quickSortArray10000);
        System.out.println("---------------------------------------------");
        competeBubbleSort(bubbleSortArray100000);
        competeSelectionSort(selectionSortArray100000);
        competeMergeSort(mergeSortArray100000);
        competeQuickSort(quickSortArray100000);
        System.out.println("---------------------------------------------");

    }
    
    private static Integer[] arrayGeneration(int arraySize){

        Random random = new Random();
        Integer[] array = new Integer[arraySize];
        for (int i = 0; i < arraySize; i++) {
            array[i] = random.nextInt();
        }
        return array;
    }

    private static void competeBubbleSort(Integer[] array){
        SortingAlgorithmsImpl sortingAlgorithms = new SortingAlgorithmsImpl();
        long startTime = System.nanoTime();
        sortingAlgorithms.bubbleSort(array);
        long endTime = System.nanoTime();long elapsedTime = endTime - startTime;
        double elapsedTimeInMilliseconds = (double) elapsedTime / 1_000_000;
        System.out.println("Execution time bubble sorting for array long " + array.length + ": " + elapsedTimeInMilliseconds + " milliseconds");
    }

    private static void competeSelectionSort(Integer[] array){
        SortingAlgorithmsImpl sortingAlgorithms = new SortingAlgorithmsImpl();
        long startTime = System.nanoTime();
        sortingAlgorithms.selectionSort(array);
        long endTime = System.nanoTime();long elapsedTime = endTime - startTime;
        double elapsedTimeInMilliseconds = (double) elapsedTime / 1_000_000;
        System.out.println("Execution time selection sorting for array long " + array.length + ": " + elapsedTimeInMilliseconds + " milliseconds");
    }

    private static void competeMergeSort(Integer[] array){
        SortingAlgorithmsImpl sortingAlgorithms = new SortingAlgorithmsImpl();
        long startTime = System.nanoTime();
        sortingAlgorithms.mergeSort(array);
        long endTime = System.nanoTime();long elapsedTime = endTime - startTime;
        double elapsedTimeInMilliseconds = (double) elapsedTime / 1_000_000;
        System.out.println("Execution time merge sorting for array long " + array.length + ": " + elapsedTimeInMilliseconds + " milliseconds");
    }

    private static void competeQuickSort(Integer[] array){
        SortingAlgorithmsImpl sortingAlgorithms = new SortingAlgorithmsImpl();
        long startTime = System.nanoTime();
        sortingAlgorithms.quickSort(array);
        long endTime = System.nanoTime();long elapsedTime = endTime - startTime;
        double elapsedTimeInMilliseconds = (double) elapsedTime / 1_000_000;
        System.out.println("Execution time quick sorting for array long " + array.length + ": " + elapsedTimeInMilliseconds + " milliseconds");
    }

}