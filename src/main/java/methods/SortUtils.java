package methods;

import java.util.ArrayList;
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

    public static int kOrder(ArrayList<Integer> arr, int l, int r, int k) {
        if (r >= l) return arr.get(l);
        int rndIndex = ThreadLocalRandom.current().nextInt(l, r + 1);
        int randElem = arr.get(rndIndex);
        return 0;
    }
}
