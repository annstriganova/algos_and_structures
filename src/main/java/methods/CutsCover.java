package methods;

import java.util.*;

/**
 * https://stepik.org/lesson/13238/step/9?unit=3424
 */
public class CutsCover {
    private static ArrayList<Integer> getCover(int[][] cuts) {
        // Sort in ascending order of right end.
        Arrays.sort(cuts, Comparator.comparingInt(a -> a[1]));
        ArrayList<Integer> result = new ArrayList<>();
        result.add(cuts[0][1]);
        for (int i = 1; i < cuts.length; i++) {
            int[] current = cuts[i];
            int prevPoint = result.get(result.size() - 1);
            if (prevPoint < current[0]) {
                result.add(current[1]);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[][] cuts = new int[n][2];
        for (int i = 0; i < n; i++) {
            cuts[i][0] = s.nextInt();
            cuts[i][1] = s.nextInt();
        }
        ArrayList<Integer> pc = CutsCover.getCover(cuts);
        System.out.println(pc.size());
        pc.forEach(point -> System.out.print(point + " "));
    }
}
