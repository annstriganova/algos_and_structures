package methods;

import java.util.Scanner;

/**
 * https://stepik.org/lesson/13248/step/5?unit=3433
 */
public class MergeSort {

    private final int[] arr;
    private long inverseCount = 0;

    public MergeSort(int[] arr) {
        this.arr = arr;
    }

    public int[] sort() {
        return sort(0, arr.length - 1);
    }

    private int[] sort(int l, int r) {
        if (l == r) {
            return new int[]{arr[l]};
        }
        int m = (l + r) / 2;
        return merge(sort(l, m), sort(m + 1, r));
    }

    private int[] merge(int[] first, int[] second) {
        int[] result = new int[first.length + second.length];
        int indexMinFirst = 0;
        int indexMinSecond = 0;
        int i = 0;
        while (true) {
            // just copy remaining items from the biggest array
            if (indexMinFirst == first.length && indexMinSecond != second.length) {
                int j = indexMinSecond;
                while (j < second.length) {
                    result[i++] = second[j++];
                }
                return result;
            }
            if (indexMinSecond == second.length && indexMinFirst != first.length) {
                int j = indexMinFirst;
                while (j < first.length) {
                    result[i++] = first[j++];
                }
                return result;
            }
            if (first[indexMinFirst] <= second[indexMinSecond]) {
                result[i++] = first[indexMinFirst++];
            } else {
                inverseCount += (first.length - indexMinFirst);
                result[i++] = second[indexMinSecond++];
            }
        }
    }

    public long getInverseCount() {
        return inverseCount;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = Integer.parseInt(s.nextLine()); // number of elements
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = s.nextInt();
        }
        MergeSort ms = new MergeSort(arr);
        ms.sort();
        long result = ms.getInverseCount();
        System.out.println(result);
    }
}
