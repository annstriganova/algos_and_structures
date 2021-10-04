package methods;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CutsAndPointsTest {
    /**
     * 6 6
     * 0 3
     * 1 3
     * 2 3
     * 3 4
     * 3 5
     * 3 6
     * 1 2 3 4 5 6
     * Ответ 2 3 6 3 2 1
     */

    @Test
    void lastIndexOfLessOrEqual() {
        int[] leftEnds = {0, 7};
        assertEquals(0, CutsAndPoints.lastIndexOfLessOrEqual(leftEnds, 1));
        assertEquals(0, CutsAndPoints.lastIndexOfLessOrEqual(leftEnds, 6));
        assertEquals(1, CutsAndPoints.lastIndexOfLessOrEqual(leftEnds, 11));
        leftEnds = new int[]{0, 1, 2, 3, 3, 3};
        assertEquals(1, CutsAndPoints.lastIndexOfLessOrEqual(leftEnds, 1));
        assertEquals(2, CutsAndPoints.lastIndexOfLessOrEqual(leftEnds, 2));
        assertEquals(5, CutsAndPoints.lastIndexOfLessOrEqual(leftEnds, 3));
        assertEquals(5, CutsAndPoints.lastIndexOfLessOrEqual(leftEnds, 4));
        assertEquals(5, CutsAndPoints.lastIndexOfLessOrEqual(leftEnds, 5));
        assertEquals(5, CutsAndPoints.lastIndexOfLessOrEqual(leftEnds, 6));
    }

    @Test
    void lastIndexOfLess() {
        int[] rightEnds = {5, 10};
        assertEquals(-1, CutsAndPoints.lastIndexOfLess(rightEnds, 1));
        assertEquals(0, CutsAndPoints.lastIndexOfLess(rightEnds, 6));
        assertEquals(1, CutsAndPoints.lastIndexOfLess(rightEnds, 11));
        rightEnds = new int[]{3, 3, 3, 4, 5, 6};
        assertEquals(-1, CutsAndPoints.lastIndexOfLess(rightEnds, 1));
        assertEquals(-1, CutsAndPoints.lastIndexOfLess(rightEnds, 2));
        assertEquals(-1, CutsAndPoints.lastIndexOfLess(rightEnds, 3));
        assertEquals(2, CutsAndPoints.lastIndexOfLess(rightEnds, 4));
        assertEquals(3, CutsAndPoints.lastIndexOfLess(rightEnds, 5));
        assertEquals(4, CutsAndPoints.lastIndexOfLess(rightEnds, 6));
    }
}