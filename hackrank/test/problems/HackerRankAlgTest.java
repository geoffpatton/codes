package problems;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * This Contains Test Cases to Hacker Rank, Leet Code, SPOJ Algorithm type problems
 */
public class HackerRankAlgTest {

    private HackerRankAlg target;

    @Before
    public void setUp() {
        target = new HackerRankAlg();
    }

    @Test
    public void testRomanToInt() {
        assertEquals(3, target.romanToInt("III"));
        assertEquals(4, target.romanToInt("IV"));
        assertEquals(9, target.romanToInt("IX"));
        assertEquals(20, target.romanToInt("XX"));
        assertEquals(58, target.romanToInt("LVIII"));
        assertEquals(1994, target.romanToInt("MCMXCIV"));
    }

    @Test
    public void testIntToRoman() {
        assertEquals("III", target.intToRoman(3));
        assertEquals("IV", target.intToRoman(4));
        assertEquals("IX", target.intToRoman(9));
        assertEquals("XX", target.intToRoman(20));
        assertEquals("LVIII", target.intToRoman(58));
        assertEquals("MCMXCIV", target.intToRoman(1994));
    }
}
