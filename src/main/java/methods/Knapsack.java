package methods;

import java.util.Arrays;
import java.util.Scanner;

/**
 * https://stepik.org/lesson/13238/step/10?unit=3424
 */
public class Knapsack {

    private static double lay(double w, double[][] facilities) {
        // Sort in descending order of cost/weight.
        Arrays.sort(facilities, (a, b) -> {
            Double div1 = b[0] / b[1];
            Double div2 = a[0] / a[1];
            return div1.compareTo(div2);
        });
        double remaining = w;
        double totalCost = 0;
        for (double[] f : facilities) {
            if (remaining == 0) {
                break;
            }
            double cost = f[0];
            double weight = f[1];
            double part = remaining / weight;
            if (part > 1) {
                remaining -= weight;
                totalCost += cost;
            } else {
                remaining = 0;
                totalCost += part * cost;
            }
        }
        return totalCost;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int w = s.nextInt();
        double[][] facilities = new double[n][2];
        for (int i = 0; i < n; i++) {
            facilities[i][0] = s.nextDouble();
            facilities[i][1] = s.nextDouble();
        }
        double maxCost = Knapsack.lay(w, facilities);
        System.out.printf("%.3f", maxCost);
    }
}
