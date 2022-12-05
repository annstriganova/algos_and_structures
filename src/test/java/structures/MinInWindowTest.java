package structures;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MinInWindowTest {

    @Test
    public void calcTest() {
        Integer[] testNums = new Integer[]{2, 4, 5, 6, 7, 8, 9, 3};
        assertEquals("245673", new MinInWindow().calc(testNums, 3));
        testNums = new Integer[]{2, 4, 5};
//        assertEquals("245", new MinInWindow().calc(testNums, 1));
        assertEquals("24", new MinInWindow().calc(testNums, 2));
        assertEquals("2", new MinInWindow().calc(testNums, 3));
    }
}
