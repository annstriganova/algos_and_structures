package methods;

import java.util.Scanner;

public class GCD {
    /**
     * Euclid algorithm.
     */
    private static long gcd(long a, long b) {
        while (true) {
            if (a == 0) {
                return b;
            }
            if (b == 0) {
                return a;
            }
            if (a > b) {
                a %= b;
            } else {
                b %= a;
            }
        }
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        long a = Long.parseLong(s.next());
        long b = Long.parseLong(s.next());
        long gcd = GCD.gcd(a, b);
        System.out.println(gcd);
    }
}
