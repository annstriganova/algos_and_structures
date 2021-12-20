package methods;

import java.util.Arrays;
import java.util.Scanner;

/**
 * https://stepik.org/lesson/13259/step/5?unit=3444
 */
public class KnapsackDynamic {

    public static int knapsackWithoutRepsBU(int W, int[] weights) {
        int[][] D = new int[weights.length + 1][W + 1];
        Arrays.stream(D).forEach(a -> Arrays.fill(a, 0));
        for (int i = 1; i <= weights.length; i++) {
            for (int w = 1; w <= W; w++) {
                D[i][w] = D[i - 1][w];
                if (weights[i - 1] <= w) {
                    D[i][w] = Math.max(D[i][w], D[i - 1][w - weights[i - 1]] + weights[i - 1]);
                }
            }
        }
        return D[weights.length][W];
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int W = s.nextInt();
        int n = s.nextInt();
        int[] weights = new int[n];
        for (int i = 0; i < n; i++) {
            weights[i] = s.nextInt();
        }
        int maxCost = knapsackWithoutRepsBU(W, weights);
        System.out.println(maxCost);
    }
}
