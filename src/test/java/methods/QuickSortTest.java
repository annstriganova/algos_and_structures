package methods;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

class QuickSortTest {

    @Test
    void sortSorted() {
        int[] arr = new int[]{1, 2, 3, 4};
        int[] result = new QuickSort(arr).sort();
        assertEquals("[1, 2, 3, 4]", Arrays.toString(result));
    }

    @Test
    void sortRevertedOrder() {
        int[] arr = new int[]{4, 3, 2, 1};
        int[] result = new QuickSort(arr).sort();
        assertEquals("[1, 2, 3, 4]", Arrays.toString(result));
    }

    @Test
    void sortRandomOrder() {
        int[] arr = new int[]{5, 2, 3, 8, 10, 9};
        int[] result = new QuickSort(arr).sort();
        assertEquals("[2, 3, 5, 8, 9, 10]", Arrays.toString(result));
    }

    @Test
    void sortRandomOrderDuplicates() {
        int[] arr = new int[]{5, 2, 3, 8, 8, 10, 9};
        int[] result = new QuickSort(arr).sort();
        assertEquals("[2, 3, 5, 8, 8, 9, 10]", Arrays.toString(result));
    }
}