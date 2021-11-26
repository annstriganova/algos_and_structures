package methods;

import java.util.Scanner;

/**
 * Bottom up
 * https://stepik.org/lesson/13258/step/8?unit=3443
 */
public class EditingDistance {

    public static int getDistance(String a, String b) {
        int[][] D = new int[a.length() + 1][b.length() + 1];
        for (int i = 0; i < a.length() + 1; i++) {
            D[i][0] = i;
        }
        for (int j = 0; j < b.length() + 1; j++) {
            D[0][j] = j;
        }
        for (int i = 1; i < a.length() + 1; i++) {
            for (int j = 1; j < b.length() + 1; j++) {
                D[i][j] = minOf(D[i - 1][j] + 1, D[i][j - 1] + 1,
                        D[i - 1][j - 1] + diff(a.charAt(i - 1), b.charAt(j - 1)));
            }
        }
        return D[a.length()][b.length()];
    }

    private static int diff(char ai, char bj) {
        if (ai == bj) {
            return 0;
        }
        return 1;
    }

    private static int minOf(int i_1, int j_1, int j_1i_1) {
        return Math.min(Math.min(i_1, j_1), j_1i_1);
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String a = s.nextLine();
        String b = s.nextLine();
        int res = getDistance(a, b);
        System.out.println(res);
    }
}
