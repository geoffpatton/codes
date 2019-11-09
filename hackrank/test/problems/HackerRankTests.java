package problems;

import static org.junit.Assert.assertEquals;

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

}
