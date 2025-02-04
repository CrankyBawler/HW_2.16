package org.example;

import java.util.Random;

public class ArrayGeneratedAndSort {
    public Integer[] array;

    public ArrayGeneratedAndSort(int size) {
        this.array = generateArray(size);

    }

    public static Integer[] generateArray(int size) {
        Integer[] array = new Integer[size];
        Random random = new Random();

        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt();

        }
        return array;
    }

    public Integer[] getArray() {
        return array;
    }

    private static void swapElements(Integer[] arr, int indexA, int indexB) {
        int tmp = arr[indexA];
        arr[indexA] = arr[indexB];
        arr[indexB] = tmp;
    }


    public void sortBubble(Integer[] array) {
        boolean swapped;
        for (int i = 0; i < array.length - 1; i++) {
            swapped = false;
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    swapped = true;
                }

            }
            if (!swapped) {
                break;
            }
        }

    }


    public void timerSortBubble() {

        long start = System.currentTimeMillis();
        sortBubble(array);
        System.out.println(System.currentTimeMillis() - start);
    }

    public void sortSelection(Integer[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            int minElementIndex = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[minElementIndex]) {
                    minElementIndex = j;
                }
            }
            swapElements(array, i, minElementIndex);
        }
    }
    public void timerSortSelection() {

        long start = System.currentTimeMillis();
        sortSelection(array);
        System.out.println(System.currentTimeMillis() - start);
    }

    public void sortInsertion(Integer[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i];
            int j = i;
            while (j > 0 && arr[j - 1] >= temp) {
                arr[j] = arr[j - 1];
                j--;
            }
            arr[j] = temp;
        }
    }

    public void timersortInsertion() {

        long start = System.currentTimeMillis();
        sortInsertion(array);
        System.out.println(System.currentTimeMillis() - start);
    }



}


