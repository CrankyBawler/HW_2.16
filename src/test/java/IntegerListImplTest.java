import org.example.IntegerListImpl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class IntegerListImplTest {
    private IntegerListImpl integerListImpl;
    private IntegerListImpl integerListImpl1;

    @BeforeEach
    public void setUp() {
        integerListImpl = new IntegerListImpl(5);
        integerListImpl1 = new IntegerListImpl(5);
    }

    @Test
    public void add() {

        int item1 = 1;
        int item2 = 2;
        int item3 = 3;

        integerListImpl.add(item1);
        integerListImpl.add(item2);
        int result = integerListImpl.add(item3);

        // Проверяем, что возвращенный элемент равен добавленному
        assertEquals(item3, result);

        //Проверяем, что все элементы действительно добавлены в массив
        Integer[] items = integerListImpl.getItems();

        assertEquals(3, items.length);
        assertEquals(item1, items[0]);
        assertEquals(item2, items[1]);
        assertEquals(item3, items[2]);
    }

    @Test
    public void addForIndex() {

        integerListImpl.add(0, 1);
        integerListImpl.add(1, 2);
        int item = 15;
        int result = integerListImpl.add(1, item);

        assertEquals(item, result);

        Integer[] items = integerListImpl.getItems();
        assertEquals(3, items.length);
        assertEquals(1, items[0]);
        assertEquals(item, items[1]);
        assertEquals(2, items[2]);
        assertThrows(IndexOutOfBoundsException.class, () -> {
            integerListImpl.add(15, 5);
        });

    }

    @Test
    public void set() {
        integerListImpl.add(0, 1);
        integerListImpl.add(1, 2);
        int item = 15;
        int result = integerListImpl.set(0, item);
        assertEquals(item, result);

        Integer[] items = integerListImpl.getItems();
        assertEquals(2, items.length);
        assertEquals(item, items[0]);
        assertEquals(2, items[1]);
        assertThrows(IndexOutOfBoundsException.class, () -> {
            integerListImpl.set(2, 15);
        });
    }

    @Test
    public void remove() {
        integerListImpl.add(0, 1);
        integerListImpl.add(1, 2);
        integerListImpl.add(2, 3);

        int result = integerListImpl.remove(2);
        assertEquals(3, result);

        Integer[] items = integerListImpl.getItems();
        assertEquals(1, items[0]);
        assertEquals(2, items[1]);

        assertThrows(IllegalArgumentException.class, () -> {
            integerListImpl.remove(4);
        });
    }

    @Test
    public void removeForIndex() {
        integerListImpl.add(0, 1);
        integerListImpl.add(1, 2);
        integerListImpl.add(2, 3);

        int result = integerListImpl.remove(1);
        assertEquals(2, result);

        Integer[] items = integerListImpl.getItems();
        assertEquals(1, items[0]);
        assertEquals(3, items[1]);

        assertThrows(IllegalArgumentException.class, () -> {
            integerListImpl.remove(3);
        });
    }


    @Test
    public void contains() {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        assertTrue(integerListImpl.contains(arr, 5));

        assertFalse(integerListImpl.contains(arr, 25));

        int[] arr1 = {};

        assertFalse(integerListImpl.contains(arr1, 25));


    }


    @Test
    public void indexOf() {
        integerListImpl.add(0, 1);
        integerListImpl.add(1, 2);
        integerListImpl.add(2, 3);

        assertEquals(0, integerListImpl.indexOf(1));
        assertEquals(1, integerListImpl.indexOf(2));
        assertEquals(2, integerListImpl.indexOf(3));
        assertEquals(-1, integerListImpl.indexOf(4));
    }

    @Test
    public void lastIndexOf() {
        integerListImpl.add(0, 1);
        integerListImpl.add(1, 2);
        integerListImpl.add(2, 3);

        assertEquals(2, integerListImpl.lastIndexOf(3));
        assertEquals(1, integerListImpl.lastIndexOf(2));
        assertEquals(0, integerListImpl.lastIndexOf(1));
        assertEquals(-1, integerListImpl.lastIndexOf(4));

    }

    @Test
    public void get() {
        integerListImpl.add(0, 1);
        integerListImpl.add(1, 2);
        integerListImpl.add(2, 3);

        assertEquals(1, integerListImpl.get(0));
        assertEquals(2, integerListImpl.get(1));
        assertEquals(3, integerListImpl.get(2));
        assertThrows(IllegalArgumentException.class, () -> {
            integerListImpl.get(-1);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            integerListImpl.get(-3);

        });
    }

    @Test
    public void equals() {
        integerListImpl.add(0, 1);
        integerListImpl.add(1, 2);
        integerListImpl.add(2, 3);

        integerListImpl1.add(0, 1);
        integerListImpl1.add(1, 2);
        integerListImpl1.add(2, 3);

        assertTrue(integerListImpl.equals(integerListImpl1));
        assertTrue(integerListImpl1.equals(integerListImpl));

    }

    @Test

    public void size() {
        assertEquals(0, integerListImpl.size());

        integerListImpl.add(0, 1);
        integerListImpl.add(1, 2);
        integerListImpl.add(2, 3);

        assertEquals(3, integerListImpl.size());

    }

    @Test
    public void isEmpty() {
        assertTrue(integerListImpl.isEmpty());

        integerListImpl.add(0, 1);
        assertFalse(integerListImpl.isEmpty());

    }

    @Test
    public void clear() {
        integerListImpl.add(0, 1);
        integerListImpl.add(1, 2);
        integerListImpl.add(2, 3);

        integerListImpl.clear();

        assertEquals(0, integerListImpl.size());
    }

    @Test
    public void toArray() {
        assertEquals(0, integerListImpl.size());
        integerListImpl.add(1);
        assertArrayEquals(new Integer[]{1}, integerListImpl.toArray());
        integerListImpl.add(2);
        assertArrayEquals(new Integer[]{1, 2}, integerListImpl.toArray());
        integerListImpl.add(3);
        assertArrayEquals(new Integer[]{1, 2, 3}, integerListImpl.toArray());

    }
}