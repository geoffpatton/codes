package problems;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

public class HackerRankTests {
    HackerRankSolutions target;

    @Before
    public void setup() {
        target = new HackerRankSolutions();
    }

    @Test
    public void testJumpingOnTheClouds() {
        int[] case1 = { 0, 1, 0, 0, 0, 1, 0 };
        assertEquals(3, target.jumpingOnClouds(case1));
        int[] case2 = { 0, 0, 1, 0, 0, 1, 0 };
        assertEquals(4, target.jumpingOnClouds(case2));
        int[] case3 = { 0, 0, 0, 0, 1, 0 };
        assertEquals(3, target.jumpingOnClouds(case3));
        int[] case4 = { 0, 0, 0, 1, 0, 0 };
        assertEquals(3, target.jumpingOnClouds(case4));
        int[] case5 = { 0, 0 };
        assertEquals(1, target.jumpingOnClouds(case5));
    }

    @Test
    public void testHourGlassSum() {
        int[][] case1 = { { 1, 1, 1, 0, 0, 0 }, // 1 1 1 0 0 0
            { 0, 1, 0, 0, 0, 0 },  // 0 1 0 0 0 0
            { 1, 1, 1, 0, 0, 0 }, // 1 1 1 0 0 0
            { 0, 0, 2, 4, 4, 0 }, // 0 0 2 4 4 0
            { 0, 0, 0, 2, 0, 0 }, // 0 0 0 2 0 0
            { 0, 0, 1, 2, 4, 0 } }; // 0 0 1 2 4 0
        assertEquals(19, target.hourglassSum(case1));

        int[][] case2 = { { -9, -9, -9, 1, 1, 1 }, // -9 -9 -9 1 1 1
            { 0, -9, 0, 4, 3, 2 },  // 0 -9 0 4 3 2
            { -9, -9, -9, 1, 2, 3 }, // -9 -9 -9 1 2 3
            { 0, 0, 8, 6, 6, 0 }, // 0 0 8 6 6 0
            { 0, 0, 0, -2, 0, 0 }, // 0 0 0 -2 0 0
            { 0, 0, 1, 2, 4, 0 } }; // 0 0 1 2 4 0
        assertEquals(28, target.hourglassSum(case2));

        int[][] case3 = { { 1, 1, 1, 0, 0, 0 }, // 1 1 1 0 0 0
            { 0, 1, 0, 0, 0, 0 },  // 0 1 0 0 0 0
            { 1, 1, 1, 0, 0, 0 }, // 1 1 1 0 0 0
            { 0, 9, 2, -4, -4, 0 }, // 0 9 2 -4 -4 0
            { 0, 0, 0, -2, 0, 0 }, // 0 0 0 -2 0 0
            { 0, 0, -1, -2, -4, 0 } }; // 0 0 -1 -2 -4 0
        assertEquals(13, target.hourglassSum(case3));

        int[][] case4 = { { -1, -1, 0, -9, -2, -2 }, // -1 -1 0 -9 -2 -2
            { -2, -1, -6, -8, -2, -5 },  // -2 -1 -6 -8 -2 -5
            { -1, -1, -1, -2, -3, -4 }, // -1 -1 -1 -2 -3 -4
            { -1, -9, -2, -4, -4, -5 }, // -1 -9 -2 -4 -4 -5
            { -7, -3, -3, -2, -9, -9 }, // -7 -3 -3 -2 -9 -9
            { -1, -3, -1, -2, -4, -5 } }; // -1 -3 -1 -2 -4 -5
        assertEquals(-6, target.hourglassSum(case4));

    }

    @Test
    public void testCountSwaps() {
        int[] case1 = { 0, 1, 2 };
        assertEquals(0, target.countSwaps(case1));
        int[] case2 = { 1, 2, 3 };
        assertEquals(0, target.countSwaps(case2));
        int[] case3 = { 3, 2, 1 };
        assertEquals(3, target.countSwaps(case3));
    }

    @Test
    public void testSubStringCount() {
        assertEquals(7, target.substrCount(5, "asasd"));
        assertEquals(10, target.substrCount(4, "aaaa"));
        assertEquals(12, target.substrCount(8, "mnonopoo"));
        assertEquals(10, target.substrCount(7, "abcbaba"));
    }

    @Test
    public void testRotLeft() {
        int[] case1 = { 1, 2, 3, 4, 5 };
        int[] result1 = { 5, 1, 2, 3, 4 };

        assertTrue(Arrays.equals(result1, target.rotLeft(case1, 4)));

        int[] case2 = { 33, 47, 70, 37, 8, 53, 13, 93, 71, 72, 51, 100, 60, 87, 97 };
        int[] result2 = { 87, 97, 33, 47, 70, 37, 8, 53, 13, 93, 71, 72, 51, 100, 60 };

        target.rotLeft(case2, 13);
        assertTrue(Arrays.equals(result2, target.rotLeft(case2, 13)));
    }

}
