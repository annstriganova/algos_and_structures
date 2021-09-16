package methods;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MedianQueueTest {
    private final MedianQueue queue = new MedianQueue();

    @BeforeEach
    public void setUp() {
        queue.offer(10);
        queue.offer(1);
        queue.offer(4);
        queue.offer(3);
        queue.offer(8);
        queue.offer(5);
        queue.offer(2);
        queue.offer(7);
        queue.offer(6);
        queue.offer(9);
    }


    @Test
    public void pollTest() {
        assertEquals(5, queue.poll());
        assertEquals(6, queue.poll());
        assertEquals(4, queue.poll());
    }
}