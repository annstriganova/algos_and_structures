package methods;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * Longest Increasing Subsequence
 * https://stepik.org/lesson/13257/step/5?unit=3442
 * https://stepik.org/lesson/13257/step/6?unit=3442
 */
public class LISBottomUp {

    // O(n^2)
    public static int greatestSequencefoldSubsequence(int[] arr) {
        int[] D = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            D[i] = 1;
            for (int j = 0; j < i; j++) {
                if (arr[i] % arr[j] == 0 && D[j] + 1 > D[i]) {
                    D[i] = D[j] + 1;
                }
            }
        }
        return IntStream.of(D).max().orElse(0);
    }

    /**
     * Longest non-increasing subsequence
     * O(nlogn)
     */
    public static int[] lds(int[] arr) {
        if (arr.length == 1) return arr;
        int[] opt = new int[arr.length + 1];
        Arrays.fill(opt, Integer.MIN_VALUE);
        opt[0] = Integer.MAX_VALUE;
        int[] d = new int[arr.length];
        int maxIndD = -1;
        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            int j = firstIndexOfLess(opt, arr[i]);
            opt[j] = arr[i];
            d[i] = j;
            if (max <= j) {
                maxIndD = i;
                max = j;
            }
        }
        int[] res = new int[max];
        for (int i = maxIndD; i > -1; i--) {
            if (d[i] == max) {
                res[--max] = i + 1;
            }
        }
        return res;
    }

    // binary search
    public static int firstIndexOfLess(int[] opt, int key) {
        int l = 0;
        int r = opt.length;
        while (l < r) {
            int m = l + (r - l) / 2;
            int middle = opt[m];
            if (key > middle) {
                r = m;
            } else {
                l = m + 1;
            }
        }
        return l;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = s.nextInt();
        }
        int[] res = lds(arr);
        System.out.println(res.length);
        for (int re : res) {
            System.out.print(re);
            System.out.print(" ");
        }
    }
}
