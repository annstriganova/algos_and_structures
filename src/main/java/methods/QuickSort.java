package methods;

import java.util.concurrent.ThreadLocalRandom;

/**
 * https://stepik.org/lesson/13249/step/1?unit=3434
 */
public class QuickSort {

    private final int[] arr;

    public QuickSort(int[] arr) {
        this.arr = arr;
    }

    public int[] sort() {
        sort(0, arr.length - 1);
        return arr;
    }

    private void sort(int l, int r) {
        while (l < r) {
            int rndIndex = ThreadLocalRandom.current().nextInt(l, r);
            int pivot = arr[rndIndex];
            arr[rndIndex] = arr[l];
            arr[l] = pivot;
            int m = SortUtils.partition(arr, l, r);
            // recursion on the lowest part to ensure space isn't worse that O(log n)
            if (m - l > r - m) {
                // right part is smaller
                sort(m + 1, r);
                // just iteration over the biggest part
                r = m - 1;
            } else {
                // left part is smaller
                sort(l, m - 1);
                // just iteration over the biggest part
                l = m + 1;
            }
        }
    }

}
