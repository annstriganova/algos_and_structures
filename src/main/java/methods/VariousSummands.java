package methods;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * https://stepik.org/lesson/13238/step/11?unit=3424
 */
public class VariousSummands {

    private static ArrayList<Integer> getSummands(final int n) {
        int target = n;
        ArrayList<Integer> result = new ArrayList<>();
        if (target < 3) {
            result.add(target);
        } else {
            // There is an optimal solution, containing the least possible number.
            // Less or equal: use n = 6 for test
            for (int i = 1; i <= target; i++) {
                int diff = target - i;
                // Less or equal: use n = 9 for test
                if (diff <= i) {
                    result.add(target);
                    break;
                }
                target = diff;
                result.add(i);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        List<Integer> summands = VariousSummands.getSummands(n);
        System.out.println(summands.size());
        summands.forEach(point -> System.out.print(point + " "));
    }
}
