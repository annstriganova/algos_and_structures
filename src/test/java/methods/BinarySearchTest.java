package methods;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BinarySearchTest {

    @Test
    void find() {
        // even length
        int[] sortedArray1 = {1, 2, 3, 4, 5};
        assertEquals(2, BinarySearch.find(sortedArray1, 3));
        assertEquals(0, BinarySearch.find(sortedArray1, 1));
        assertEquals(3, BinarySearch.find(sortedArray1, 4));
        // odd length
        int[] sortedArray2 = {1, 2, 3, 4};
        assertEquals(2, BinarySearch.find(sortedArray2, 3));
        assertEquals(0, BinarySearch.find(sortedArray2, 1));
        assertEquals(3, BinarySearch.find(sortedArray2, 4));
        // no element
        assertEquals(-1, BinarySearch.find(sortedArray2, 5));
        // duplicates, return the most right - TODO
        int[] dupls = {1, 5, 8, 8, 8, 12, 13};
        assertEquals(4, BinarySearch.find(dupls, 8));
    }
}