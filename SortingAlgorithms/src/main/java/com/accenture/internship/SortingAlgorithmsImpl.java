package com.accenture.internship;

public class SortingAlgorithmsImpl<T extends Comparable<T>> implements SortingAlgorithms<T> {
    @Override
    public void bubbleSort(T[] t) {

        if (t == null || t.length <= 1)
            return;
        boolean swapped = true;

        for (int i = t.length - 1; i > 0 && swapped; i--) {
            swapped = false;
            for (int j = 0; j < i; j++) {
                if (t[j].compareTo(t[j + 1]) > 0) {
                    T temp = t[j];
                    t[j] = t[j + 1];
                    t[j + 1] = temp;
                    swapped = true;
                }
            }
        }
    }

    @Override
    public void selectionSort(T[] t) {

        if (t == null || t.length <= 1)
            return;
        for (int i = 0; i < t.length; i++) {
            T min = t[i];
            int minIndex = i;

            for (int j = i; j < t.length; j++) {
                if (t[j].compareTo(min) < 0) {
                    minIndex = j;
                    min = t[j];
                }
            }
            T temp = t[i];
            t[i] = min;
            t[minIndex] = temp;
        }
    }

    @Override
    public void mergeSort(T[] t) {

        if (t == null || t.length <= 1)
            return;
        T[] aux = (T[]) new Comparable[t.length];
        mergeSort(t, aux, 0, t.length - 1);
    }


    private void mergeSort(T[] array, T[] aux, int low, int high) {
        if (low < high) {
            int middle = low + (high - low) / 2;
            mergeSort(array, aux, low, middle);
            mergeSort(array, aux, middle + 1, high);
            merge(array, aux, low, middle, high);
        }
    }

    private void merge(T[] array, T[] aux, int low, int middle, int high) {
        System.arraycopy(array, low, aux, low, high - low + 1);
        int i = low;
        int j = middle + 1;
        for (int k = low; k <= high; k++) {
            if (i > middle) {
                array[k] = aux[j++];
            } else if (j > high) {
                array[k] = aux[i++];
            } else if (aux[j].compareTo(aux[i]) < 0) {
                array[k] = aux[j++];
            } else {
                array[k] = aux[i++];
            }
        }
    }

    @Override
    public void quickSort(T[] t) {

        if (t == null || t.length <= 1) {
            return;
        }

        quickSort(t, 0, t.length - 1);
    }

    private void quickSort(T[] array, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(array, low, high);

            quickSort(array, low, pivotIndex - 1);
            quickSort(array, pivotIndex + 1, high);
        }
    }
    private int partition(T[] array, int low, int high) {
        T pivot = array[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (array[j].compareTo(pivot) <= 0) {
                i++;
                swap(array, i, j);
            }
        }
        swap(array, i + 1, high);
        return i + 1;
    }

    private void swap(T[] array, int i, int j) {
        T temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

}
