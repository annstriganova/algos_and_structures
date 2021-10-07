package methods;

import java.util.concurrent.ThreadLocalRandom;

public class SortUtils {

    /**
     * Modifies arr so that element that was at <code>l</code>, i.e. <code>arr[l]</code>,
     * gets new index and:
     * - elements before new index are <= arr[l]
     * - after are > arr[l]
     * Returns new index.
     * 2-partition
     */
    public static int partition(int[] arr, int l, int r) {
        int pivot = arr[l];
        int j = l;
        for (int i = l + 1; i <= r && i < arr.length; i++) {
            int curr = arr[i];
            if (curr <= pivot) {
                j++;
                arr[i] = arr[j];
                arr[j] = curr;
            }
        }
        int target = arr[j];
        arr[j] = pivot;
        arr[l] = target;
        return j;
    }

    /**
     * https://stepik.org/lesson/13250/step/2?unit=3435
     */
    public static int randomSelect(int[] unsortedArr, int l, int r, int k) {
        if (l == r) return unsortedArr[l == unsortedArr.length ? l - 1 : l];
        int rndIndex = ThreadLocalRandom.current().nextInt(l, r);
        int pivot = unsortedArr[rndIndex];
        unsortedArr[rndIndex] = unsortedArr[l];
        unsortedArr[l] = pivot;
        int m = partition(unsortedArr, l, r);
        if (m == (k - 1)) {
            return unsortedArr[m];
        }
        if ((k - 1) < m) {
            return randomSelect(unsortedArr, l, m - 1, k);
        } else {
            return randomSelect(unsortedArr, m + 1, r, k);
        }
    }
}
