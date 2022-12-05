package structures;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.List;

/**
 * Sliding Window Minimum
 * https://stepik.org/lesson/41233/step/6?unit=19817
 */
public class MinInWindow {

    private final ArrayDeque<Integer> minStack = new ArrayDeque<>();
    // Queue based on 2 stacks
    private final ArrayDeque<Integer> addToQueue = new ArrayDeque<>();
    private final ArrayDeque<Integer> removeFromQueue = new ArrayDeque<>();

    private final StringBuilder sb = new StringBuilder();

    public String calc(Integer[] numbers, int m) {
        for (Integer n : numbers) {
            if (addToQueue.size() == m) {
                move(m);
            } else {
                minStack.offerLast(getMin(n));
            }
            addToQueue.offerLast(n);
            if (minStack.size() % m == 0) {
                sb.append(minStack.getLast());
            }
            if (addToQueue.size() + removeFromQueue.size() > m) {
                removeFromQueue.removeLast();
            }
        }
        if (numbers.length % m != 0) sb.append(minStack.getLast());
        return sb.toString();
    }

    private Integer getMin(Integer n) {
        Integer lastMin = minStack.peekLast();
        return lastMin == null ? n : Math.min(lastMin, n);
    }

    private void move(int m) {
        boolean startOfNewWindow = true;
        for (int i = 0; i < m - 1; i++) {
            Integer curN = addToQueue.removeLast();
            if (startOfNewWindow) {
                minStack.offerLast(curN);
                startOfNewWindow = false;
            } else {
                minStack.offerLast(getMin(curN));
            }
            removeFromQueue.offerLast(curN);
        }
        Integer curN = addToQueue.removeLast();
        removeFromQueue.offerLast(curN);
    }

    public static void main(String[] args) {
        var sb = new StringBuilder();
        sb.append("red");
        sb.deleteCharAt(0);
        sb.delete(1, 2);
        System.out.println(sb);
    }
}
