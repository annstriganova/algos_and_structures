package methods;

import java.util.Scanner;
import java.util.stream.IntStream;

public class BinarySearch {

    public static int find(int[] array, int key) {
        int l = 0;
        int r = array.length - 1;
        while (l <= r) {
            int m = (l + r) / 2;
            int mEl = array[m];
            if (key == mEl) return m;
            if (mEl < key) {
                l = m + 1;
            }
            if (key < mEl) {
                r = m;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String[] firstLine = s.nextLine().split(" ");
        int[] srcArray = IntStream.range(1, Integer.parseInt(firstLine[0]) + 1)
                .map(i -> Integer.parseInt(firstLine[i]))
                .toArray();
        String[] secondLine = s.nextLine().split(" ");
        int n = Integer.parseInt(secondLine[0]);
        int[] keys = IntStream.range(1, n + 1)
                .map(i -> Integer.parseInt(secondLine[i]))
                .toArray();
        String[] results = new String[n];
        for (int i = 0; i < n; i++) {
            int k = keys[i];
            int res = BinarySearch.find(srcArray, k);
            results[i] = Integer.toString(res == -1 ? res : res + 1);
        }
        System.out.println(String.join(" ", results));

    }
}
