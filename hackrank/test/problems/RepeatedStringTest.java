package problems;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class RepeatedStringTest {
    RepeatedString target;

    @Before
    public void setUp() {
        target = new RepeatedString();
    }

    @Test
    public void testRepeatedString() {
        assertEquals(7L, target.repeatedString("aba", 10L));
        assertEquals(1000000000000L, target.repeatedString("a", 1000000000000L));
    }

}
