package problems;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class CountingValleysTest {
    private CountingValleys target;

    @Before
    public void setUp() {
        target = new CountingValleys();
    }

    @Test
    public void testCountingValleys() {
        assertEquals(0, target.countingValleys(1, "U"));
        assertEquals(0, target.countingValleys(10, "UUUUUUUUUU"));
        assertEquals(0, target.countingValleys(10, "DDDDDDDDDD"));
        assertEquals(1, target.countingValleys(8, "UDDDUDUU"));
        assertEquals(2, target.countingValleys(12, "DDUUDDUDUUUD"));
        assertEquals(1, target.countingValleys(9, "DDUUUUDDD"));
        assertEquals(1, target.countingValleys(8, "DDUUUUDD"));
    }

}
