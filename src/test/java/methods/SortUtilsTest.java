package methods;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class SortUtilsTest {

    private int[] arr;

    @BeforeEach
    public void setUp() {
        arr = new int[]{10, 1, 4, 3, 8, 5, 2, 7, 6, 9};
    }

    public String listToString() {
        return Arrays.toString(arr);
    }

    @Test
    public void partitionTest1() {
        int actual = SortUtils.partition(arr, 0, 10);
        assertEquals(9, actual);
        assertEquals("[9, 1, 4, 3, 8, 5, 2, 7, 6, 10]", listToString());
    }

    @Test
    public void partitionTest2() {
        int actual = SortUtils.partition(arr, 2, 8);
        assertEquals(4, actual);
        assertEquals("[10, 1, 2, 3, 4, 5, 8, 7, 6, 9]", listToString());
    }

    @Test
    public void partitionTest3() {
        arr = new int[]{3, 2};
        int actual = SortUtils.partition(arr, 0, 1);
        assertEquals(1, actual);
        assertEquals("[2, 3]", listToString());
    }

    @Test
    public void randomSelectTest1() {
        // even length
        arr = new int[]{3, 2, 4, 1, 5};
        assertEquals(1, SortUtils.randomSelect(arr.clone(), 0, arr.length, 1));
        assertEquals(2, SortUtils.randomSelect(arr.clone(), 0, arr.length, 2));
        assertEquals(3, SortUtils.randomSelect(arr.clone(), 0, arr.length, 3));
        assertEquals(4, SortUtils.randomSelect(arr.clone(), 0, arr.length, 4));
        assertEquals(5, SortUtils.randomSelect(arr.clone(), 0, arr.length, 5));
        assertEquals(5, SortUtils.randomSelect(arr.clone(), 0, arr.length, 6));
    }

    @Test
    public void randomSelectTest2() {
        // odd length
        arr = new int[]{3, 2, 4, 1};
        assertEquals(1, SortUtils.randomSelect(arr.clone(), 0, arr.length, 1));
        assertEquals(2, SortUtils.randomSelect(arr.clone(), 0, arr.length, 2));
        assertEquals(3, SortUtils.randomSelect(arr.clone(), 0, arr.length, 3));
        assertEquals(4, SortUtils.randomSelect(arr.clone(), 0, arr.length, 4));
        assertEquals(4, SortUtils.randomSelect(arr.clone(), 0, arr.length, 5));
        assertEquals(4, SortUtils.randomSelect(arr.clone(), 0, arr.length, 6));
    }

    @Test
    public void randomSelectTest3() {
        // sorted
        arr = new int[]{1, 2, 3, 4};
        assertEquals(1, SortUtils.randomSelect(arr.clone(), 0, arr.length, 1));
        assertEquals(2, SortUtils.randomSelect(arr.clone(), 0, arr.length, 2));
        assertEquals(3, SortUtils.randomSelect(arr.clone(), 0, arr.length, 3));
        assertEquals(4, SortUtils.randomSelect(arr.clone(), 0, arr.length, 4));
        assertEquals(4, SortUtils.randomSelect(arr.clone(), 0, arr.length, 5));
        assertEquals(4, SortUtils.randomSelect(arr.clone(), 0, arr.length, 6));
    }

    @Test
    public void randomSelectTest4() {
        // duplicates
        arr = new int[]{1, 2, 3, 3, 4};
        assertEquals(1, SortUtils.randomSelect(arr.clone(), 0, arr.length, 1));
        assertEquals(2, SortUtils.randomSelect(arr.clone(), 0, arr.length, 2));
        assertEquals(3, SortUtils.randomSelect(arr.clone(), 0, arr.length, 3));
        assertEquals(3, SortUtils.randomSelect(arr.clone(), 0, arr.length, 4));
        assertEquals(4, SortUtils.randomSelect(arr.clone(), 0, arr.length, 5));
        assertEquals(4, SortUtils.randomSelect(arr.clone(), 0, arr.length, 6));
    }
}