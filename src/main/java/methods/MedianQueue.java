package methods;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

/**
 * EPAM Java Core Course task
 */
public class MedianQueue {

    private final ArrayList<Integer> numbers = new ArrayList<>();
    // helps to reduce amount of sorts
    int medianCache = -1;

    public void offer(Integer num) {
        numbers.add(num);
    }

    public Integer poll() {
        Integer median = numbers.remove(getMedianIndex());
        medianCache = -1;
        return median;
    }

    /**
     * Bad implementation, because time complexity is O(nlog(n)),
     * Try to implement quickSelect O(n), more info
     * https://stepik.org/lesson/13250/step/1?unit=3435
     * https://stepik.org/lesson/13249/step/1?unit=3434
     */
    private int getMedianIndex() {
        if (medianCache != -1) return medianCache;
        Collections.sort(numbers);
        int s = numbers.size();
        medianCache = s % 2 == 0 ? (s >> 1) - 1 : (s >> 1);
        return medianCache;
    }

    public Integer peek() {
        return numbers.get(getMedianIndex());
    }

    public Iterator<Integer> iterator() {
        return numbers.iterator();
    }

    public int size() {
        return numbers.size();
    }
}
