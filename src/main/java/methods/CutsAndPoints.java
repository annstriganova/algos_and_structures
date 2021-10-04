package methods;

import java.util.*;

/**
 * https://stepik.org/lesson/13249/step/6?unit=3434
 */
public class CutsAndPoints {

    // binary search
    public static int lastIndexOfLessOrEqual(int[] leftEnds, int key) {
        int l = 0;
        int r = leftEnds.length - 1;
        while (l <= r) {
            int m = l + (r - l) / 2;
            int middle = leftEnds[m];
            if (key == middle) {
                int i = m + 1;
                while (i < leftEnds.length) {
                    int El = leftEnds[i];
                    if (key == El) {
                        i++;
                    } else {
                        break;
                    }
                }
                return i - 1;
            }
            if (key < middle) {
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        return r;
    }

    // binary search
    public static int lastIndexOfLess(int[] rightEnds, int key) {
        int l = 0;
        int r = rightEnds.length - 1;
        while (l <= r) {
            int m = l + (r - l) / 2;
            int middle = rightEnds[m];
            if (key == middle) {
                int i = m - 1;
                while (i >= 0) {
                    int el = rightEnds[i];
                    if (key == el) {
                        i--;
                    } else {
                        break;
                    }
                }
                return i;
            }
            if (key < middle) {
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        return r;
    }

    public static void countCuts(int[] leftEnds, int[] rightEnds, int[] points) {
        // O(nlogn)
        Arrays.sort(leftEnds);
        // O(nlogn)
        Arrays.sort(rightEnds);
        // O(mlogn) + O(mlogn)
        for (int point : points) {
            // O(logn)
            int leftCount = lastIndexOfLessOrEqual(leftEnds, point);
            // O(logn)
            int rightCount = lastIndexOfLess(rightEnds, point);
            System.out.print(Math.abs(leftCount - rightCount));
            System.out.print(" ");
        }
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int m = s.nextInt();
        int[] leftEnds = new int[n];
        int[] rightEnds = new int[n];
        for (int i = 0; i < n; i++) {
            leftEnds[i] = s.nextInt();
            rightEnds[i] = s.nextInt();
        }
        int[] points = new int[m];
        for (int i = 0; i < m; i++) {
            points[i] = s.nextInt();
        }
        CutsAndPoints.countCuts(leftEnds, rightEnds, points);
    }
}
