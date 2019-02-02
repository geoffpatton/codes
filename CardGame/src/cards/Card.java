package cards;

/**
 * @author Geoff Jul 7, 2018
 *
 */
public class Card
{
    SUITS suit;
    RANKS rank;
    
    /**
     * Constructor
     * @param suit
     * @param rank
     */
    public Card(SUITS suit, RANKS rank)
    {
        this.suit = suit;
        this.rank = rank;
    }

}
