package cards;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;

/**
 * @author Geoff Jul 7, 2018
 *
 */
public enum SUITS {
    HEART, SPADE, CLUB, DIAMOND;

    static List<SUITS> suitList = new ArrayList<SUITS>(EnumSet.allOf(SUITS.class));
}
