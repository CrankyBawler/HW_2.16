package org.example;

import java.util.Arrays;
import java.util.Objects;

public class IntegerListImpl implements IntegerList {
    private Integer[] items;
    private int size;

    public IntegerListImpl(int i) {
        this.items = new Integer[10];
        this.size = 0;
    }

    @Override

    public Integer add(int item) {
        if (size == items.length) {
            items = Arrays.copyOf(items, items.length * 2);
        }
        items[size] = item;
        size++;
        return item;
    }

    @Override
    public Integer add(int index, int item) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Такого индекса массива не существует " + index);
        }
        if (size == items.length) {
            items = Arrays.copyOf(items, items.length * 2);
        }
        System.arraycopy(items, index, items, index + 1, size - index);
        items[index] = item;
        size++;
        return item;
    }

    @Override
    public Integer set(int index, int item) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Такого индекса массива не существует " + index);
        }
        items[index] = item;
        return item;
    }

    @Override
    public Integer remove(Integer item) {
        int index = -1;
        for (int i = 0; i < size; i++) {
            if (items[i].equals(item)) {
                index = i;
                break;
            }
        }
        if (index == -1) {
            throw new IllegalArgumentException("Item не найден " + item);
        }
        int removerItem = items[index];
        System.arraycopy(items, index + 1, items, index, size - index - 1);
        items[--size] = null;
        return removerItem;
    }

    @Override
    public Integer remove(int index) {
        {
            if (index < 0 || index > size) {


                throw new IllegalArgumentException("Такого индекса массива не существует");
            }
            Integer removerItem = items[index];
            System.arraycopy(items, index + 1, items, index, size - index - 1);
            items[--size] = null;


            return removerItem;
        }
    }

    @Override
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

    @Override


    public boolean contains(int[] arr, int element) {
        int min = 0;
        int max = arr.length - 1;

        while (min <= max) {
            int mid = (min + max) / 2;

            if (element == arr[mid]) {
                return true;
            }

            if (element < arr[mid]) {
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }
        return false;
    }

    @Override
    public int indexOf(int item) {
        for (int i = 0; i < size; i++) {
            if (items[i].equals(item)) {
                return i;
            }

        }
        return -1;
    }

    @Override
    public int lastIndexOf(int item) {
        for (int i = 0; i < size; i++) {
            if (items[i].equals(item)) {
                return i;
            }

        }
        return -1;
    }

    @Override
    public Integer get(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Такого индекса не существует");
        }
        return items[index];
    }

    @Override
    public boolean equals(IntegerList otherList) {
        return Arrays.equals(this.toArray(), otherList.toArray());
    }


    @Override
    public int size() {

        return size;
    }

    @Override
    public boolean isEmpty() {

        return size == 0;
    }

    @Override
    public void clear() {
        size = 0;

    }

    @Override
    public Integer[] toArray() {
        Integer[] result = new Integer[size];
        System.arraycopy(items, 0, result, 0, size);
        return result;
    }

    public Integer[] getItems() {
        return Arrays.copyOf(items, size);
    }

    public int getSize() {
        return size;
    }


    @Override
    public int hashCode() {
        int result = Objects.hash(size);
        result = 31 * result + Arrays.hashCode(items);
        return result;
    }

    private static void swapElements(Integer[] arr, int indexA, int indexB) {
        int tmp = arr[indexA];
        arr[indexA] = arr[indexB];
        arr[indexB] = tmp;
    }


}


