package methods;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class PriorityQueueTest {
    private PriorityQueue pq;

    @BeforeEach
    void setUp() {
        pq = new PriorityQueue();
    }

    @Test
    void insert() {
        int[] testSet = new int[]{3, 4, 5, 20, 21, 21, 30};
        for (int i : testSet) pq.insert(i);
        assertEquals("[30, 20, 21, 3, 5, 4, 21]", pq.toString());
    }

    @Test
    void getMax1() {
        pq.insert(200);
        pq.insert(10);
        assertEquals("[200, 10]", pq.toString());
        assertEquals(200, pq.extractMax());
        assertEquals("[10]", pq.toString());
        pq.insert(5);
        pq.insert(500);
        assertEquals("[500, 5, 10]", pq.toString());
        assertEquals(500, pq.extractMax());
        assertEquals("[10, 5]", pq.toString());
    }

    @Test
    void getMax2() {
        pq.insert(200);
        pq.insert(10);
        pq.insert(5);
        pq.insert(500);
        assertEquals(500, pq.extractMax());
        assertEquals(200, pq.extractMax());
        assertEquals(10, pq.extractMax());
        assertEquals(5, pq.extractMax());
    }

    @Test
    void getMax3() {
        pq.insert(2);
        pq.insert(3);
        pq.insert(15);
        pq.insert(18);
        pq.insert(12);
        assertEquals(18, pq.extractMax());
        assertEquals(15, pq.extractMax());
        assertEquals(12, pq.extractMax());
    }
}