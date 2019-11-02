package cards;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Geoff Jul 7, 2018
 *
 */
public class Deck {
    List<Card> cardList = new ArrayList<Card>();

    /**
     * Constructor
     */
    public Deck() {
        createDeck();
    }

    private void createDeck() {
        for (SUITS suit : SUITS.suitList) {
            for (RANKS rank : RANKS.rankList) {
                cardList.add(new Card(suit, rank));
            }
        }
    }

    void shuffleDeck() {
        Collections.shuffle(cardList);
    }

}
