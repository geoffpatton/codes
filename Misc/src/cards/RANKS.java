package cards;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;

public enum RANKS
{
    TWO(2), THREE(3), FOUR(4), FIVE(5), SIX(6), SEVEN(7), EIGHT(8), NINE(9), TEN(10), JACK(11), QUEEN(12), KING(
            13), ACE(14);

    private int value;

    private RANKS(int value)
    {
        this.value = value;
    }

    static int getValue(RANKS rank)
    {
        return rank.value;
    }

    static List<RANKS> rankList = new ArrayList<RANKS>(EnumSet.allOf(RANKS.class));
}
