package cards;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DeckTest
{
    Deck target;

    @BeforeEach
    void setUp() throws Exception
    {
        target = new Deck();
    }

    @Test
    void test()
    {
        assertEquals(52, target.cardList.size());
    }

}
