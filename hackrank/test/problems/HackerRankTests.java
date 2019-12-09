package problems;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

import problems.HackerRankSolutions.Checker;
import problems.HackerRankSolutions.Player;

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

    @Test
    public void testMinimumBribes() {
        int[] case1 = { 2, 1, 5, 3, 4 };
        assertEquals(3, target.minimumBribes(case1));
        int[] case2 = { 2, 5, 1, 3, 4 };
        assertEquals(-1, target.minimumBribes(case2));
        int[] case3 = { 1, 2, 5, 3, 4, 7, 8, 6 };
        assertEquals(4, target.minimumBribes(case3));
        int[] case4 = { 1, 2, 5, 3, 7, 8, 6, 4 };
        assertEquals(7, target.minimumBribes(case4));
    }

    @Test
    public void testTwoStrings() {
        assertEquals("YES", target.twoStrings("hello", "world"));
        assertEquals("YES", target.twoStrings("ant", "abby"));
        assertEquals("NO", target.twoStrings("hi", "world"));
        assertEquals("NO", target.twoStrings("beetroot", "sandals"));
    }

    @Test
    public void testWhatFlavors() {
        int[] case1 = { 1, 4, 5, 3, 2 };
        target.whatFlavors(case1, 4); // 1 4
        int[] case2 = { 2, 2, 4, 3 };
        target.whatFlavors(case2, 4); // 1 2
        int[] case3 = { 1, 4, 5, 3, 2 };
        target.whatFlavors(case3, 4); // 1 4
        int[] case4 = { 4, 3, 2, 5, 7 };
        target.whatFlavors(case4, 8); // 2 4
    }

    @Test
    public void testMinimumSwaps() {
        int[] case1 = { 4, 3, 1, 2 };
        assertEquals(3, target.minimumSwaps(case1));
        int[] case2 = { 2, 3, 4, 1, 5 };
        assertEquals(3, target.minimumSwaps(case2));
        int[] case3 = { 1, 3, 5, 2, 4, 6, 7 };
        assertEquals(3, target.minimumSwaps(case3));
    }

    @Test
    public void testAlternatingCharacters() {
        assertEquals(3, target.alternatingCharacters("AAAA"));
        assertEquals(4, target.alternatingCharacters("BBBBB"));
        assertEquals(0, target.alternatingCharacters("ABABABAB"));
        assertEquals(0, target.alternatingCharacters("BABABA"));
        assertEquals(4, target.alternatingCharacters("AAABBB"));
        assertEquals(6, target.alternatingCharacters("AAABBBAABB"));
    }

    @Test
    public void testMaximumToys() {
        int[] case1 = { 1, 12, 5, 111, 200, 1000, 10 };
        assertEquals(4, target.maximumToys(case1, 50));
        int[] case2 = { 1, 2, 3, 4 };
        assertEquals(3, target.maximumToys(case2, 7));
        int[] case3 = { 3, 7, 2, 9, 4 };
        assertEquals(3, target.maximumToys(case3, 15));

    }

    @Test
    public void testChecker() {

        Player amy = new Player("amy", 100);
        Player david = new Player("david", 100);
        Player heraldo = new Player("heraldo", 50);
        Player aakansha = new Player("aakansha", 75);
        Player aleksa = new Player("aleksa", 150);

        Player[] players = { amy, david, heraldo, aakansha, aleksa };
        Checker checker = new Checker();
        Arrays.sort(players, checker);

        for (int i = 0; i < players.length; i++) {
            System.out.println(players[i]);
        }

    }

    @Test
    public void testFlippintBits() {
        long testVal1 = 2147483647;
        long result1 = 2147483648L;
        assertEquals(result1, target.flippingBits(testVal1));
        long testVal2 = 1L;
        long result2 = 4294967294L;
        assertEquals(result2, target.flippingBits(testVal2));
        long testVal3 = 0L;
        long result3 = 4294967295L;
        assertEquals(result3, target.flippingBits(testVal3));
        assertEquals(4294967295L, target.flippingBits(0));
        assertEquals(3492223820L, target.flippingBits(802743475));
        assertEquals(4259365872L, target.flippingBits(35601423));
    }

    @Test
    public void testMinimumAbsoluteDifference() {
        int[] case1 = { -59, -36, -13, 1, -53, -92, -2, -96, -54, 75 };
        assertEquals(1, target.minimumAbsoluteDifference(case1));
        int[] case2 = { 1, -3, 71, 68, 17 };
        assertEquals(3, target.minimumAbsoluteDifference(case2));
        int[] case3 = { 3, -7, 0 };
        assertEquals(3, target.minimumAbsoluteDifference(case3));

    }

    @Test
    public void testIsBalanced() {
        assertEquals("YES", target.isBalanced("{[()]}"));
        assertEquals("NO", target.isBalanced("{[(])}"));
        assertEquals("YES", target.isBalanced("{{[[(())]]}}"));
        assertEquals("YES", target.isBalanced("{{([])}}"));
        assertEquals("NO", target.isBalanced("{{)[](}}"));
        assertEquals("YES", target.isBalanced("{(([])[])[]}"));
        assertEquals("NO", target.isBalanced("{(([])[])[]]}"));
        assertEquals("YES", target.isBalanced("{(([])[])[]}[]"));

        assertEquals("YES", target.isBalanced("[](){()}"));
        assertEquals("YES", target.isBalanced("()"));
        assertEquals("YES", target.isBalanced("({}([][]))[]()"));
        assertEquals("NO", target.isBalanced("{)[](}]}]}))}(())("));
        assertEquals("NO", target.isBalanced("([[)"));

        assertEquals("YES", target.isBalanced("{}"));
        assertEquals("NO", target.isBalanced("}([[{)[]))]{){}["));
        assertEquals("NO", target.isBalanced("{]]{()}{])"));
        assertEquals("YES", target.isBalanced("(){}"));
        assertEquals("YES", target.isBalanced("{}{()}{{}}"));
    }

    @Test
    public void testSockMerchant() {
        assertEquals(3, target.sockMerchant(9, new int[] { 10, 20, 20, 10, 10, 30, 50, 10, 20 }));
        assertEquals(2, target.sockMerchant(7, new int[] { 1, 2, 1, 2, 1, 3, 2 }));
        assertEquals(4, target.sockMerchant(10, new int[] { 1, 1, 3, 1, 2, 1, 3, 3, 3, 3 }));
    }

    @Test
    public void testPairs() {
        assertEquals(3, target.pairs(2, new int[] { 1, 5, 3, 4, 2 }));
        assertEquals(3, target.pairs(1, new int[] { 1, 2, 3, 4 }));
        assertEquals(5, target.pairs(2, new int[] { 1, 3, 5, 8, 6, 4, 2 }));
    }

}
