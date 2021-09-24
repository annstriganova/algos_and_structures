package methods;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Fibonacci {

    private static int calculateArray(int n) {
        int[] fi = new int[n + 1];
        fi[0] = 0;
        fi[1] = 1;
        for (int i = 2; i <= n; i++) {
            fi[i] = fi[i - 1] + fi[i - 2];
        }
        return fi[n];
    }

    private static int calculate(int n) {
        if (n <= 1) {
            return n;
        }
        int grandP = 0;
        int p = 1;
        int res = 0;
        for (int i = 2; i <= n; i++) {
            res = p + grandP;
            grandP = p;
            p = res;
        }
        return res;
    }

    private static int lastDigit(int n) {
        if (n <= 1) {
            return n;
        }
        int grandP = 0;
        int p = 1;
        int res = 0;
        for (int i = 2; i <= n; i++) {
            res = (p + grandP) % 10;
            grandP = p % 10;
            p = res;
        }
        return res;
    }

    /**
     * https://ru.wikipedia.org/wiki/%D0%9F%D0%B5%D1%80%D0%B8%D0%BE%D0%B4_%D0%9F%D0%B8%D0%B7%D0%B0%D0%BD%D0%BE
     */
    private static long nModM(long n, long m) {
        if (n <= 1) {
            return n;
        }
        List<Long> reminders = new ArrayList<Long>();
        reminders.add(0L);
        reminders.add(1L);
        long grandP = 0;
        long p = 1;
        // Search period.
        long last = 6 * m;
        for (int i = 2; i < last; i++) {
            long res = (p + grandP) % m;
            grandP = p;
            p = res;
            // Period starts from [0, 1, ... ].
            if (i > 2 && p == 1 && grandP == 0) {
                // Last reminder is extra 0.
                return reminders.get((int) (n % (reminders.size() - 1)));
            }
            reminders.add(p);
        }
        return n % m;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        long n = Long.parseLong(s.next());
        long m = Long.parseLong(s.next());
        long nModM = Fibonacci.nModM(n, m);
        System.out.println(nModM);
    }
}
