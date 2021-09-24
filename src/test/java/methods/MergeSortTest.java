package methods;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MergeSortTest {

    @Test
    void sortSorted() {
        int[] arr = new int[]{1, 2, 3, 4};
        int[] result = new MergeSort(arr).sort();
        int[] expected = new int[]{1, 2, 3, 4};
        for (int i = 0; i < expected.length; i++) {
            assertEquals(expected[i], result[i]);
        }
    }

    @Test
    void sortRevertedOrder() {
        int[] arr = new int[]{4, 3, 2, 1};
        int[] result = new MergeSort(arr).sort();
        int[] expected = new int[]{1, 2, 3, 4};
        for (int i = 0; i < expected.length; i++) {
            assertEquals(expected[i], result[i]);
        }
    }

    @Test
    void sortRandomOrder() {
        int[] arr = new int[]{5, 2, 3, 8, 10, 9};
        int[] result = new MergeSort(arr).sort();
        int[] expected = new int[]{2, 3, 5, 8, 9, 10};
        for (int i = 0; i < expected.length; i++) {
            assertEquals(expected[i], result[i]);
        }
    }

    @Test
    void sortRandomOrderDuplicates() {
        int[] arr = new int[]{5, 2, 3, 8, 8, 10, 9};
        int[] result = new MergeSort(arr).sort();
        int[] expected = new int[]{2, 3, 5, 8, 8, 9, 10};
        for (int i = 0; i < expected.length; i++) {
            assertEquals(expected[i], result[i]);
        }
    }

    @Test
    void inverseCountSorted() {
        int[] arr = new int[]{1, 2, 3, 4};
        MergeSort ms = new MergeSort(arr);
        ms.sort();
        long result = ms.getInverseCount();
        assertEquals(0, result);
    }

    @Test
    void inverseCountRevertedOrder() {
        int[] arr = new int[]{4, 3, 2, 1};
        MergeSort ms = new MergeSort(arr);
        ms.sort();
        long result = ms.getInverseCount();
        assertEquals(6, result);
    }

    @Test
    void inverseCountRandomOrder() {
        int[] arr = new int[]{5, 2, 3, 8, 10, 9};
        MergeSort ms = new MergeSort(arr);
        ms.sort();
        long result = ms.getInverseCount();
        assertEquals(3, result);
    }

    @Test
    void inverseCountRandomOrderDuplicates() {
        int[] arr = new int[]{5, 2, 3, 8, 8, 10, 9};
        MergeSort ms = new MergeSort(arr);
        ms.sort();
        long result = ms.getInverseCount();
        assertEquals(3, result);
    }
}