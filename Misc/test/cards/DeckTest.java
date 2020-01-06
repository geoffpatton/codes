package cards;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

class DeckTest {
    Deck target;

    @Before
    void setUp() throws Exception {
        target = new Deck();
    }

    @Test
    void test() {
        assertEquals(52, target.cardList.size());
    }

}
