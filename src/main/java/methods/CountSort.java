package methods;

import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * https://stepik.org/lesson/13252/step/3?unit=3437
 */
public class CountSort {
    private final int[] arr;
    private static final int M = 10;

    public CountSort(int[] arr) {
        this.arr = arr;
    }

    // TODO: this is unstable
    public int[] sort() {
        int[] counts = new int[M + 1];
        for (int i = 0; i != arr.length; i++) {
            counts[arr[i]] = counts[arr[i]] + 1;
        }
        int[] result = new int[arr.length];
        int j = 0;
        for (int i = 0; i != counts.length; i++) {
            int count = counts[i];
            while (count != 0) {
                result[j] = i;
                j++;
                count--;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = Integer.parseInt(s.nextLine()); // number of elements
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = s.nextInt();
        }
        CountSort cs = new CountSort(arr);
        IntStream.of(cs.sort()).forEach(el -> System.out.print(el + " "));
    }

    public void ewMethod(){}
}
