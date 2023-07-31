public class Card {
    private Suits suit;
    private int value;
    private CardRank rank;

    public Card(Suits suit, int value, CardRank rank)
    {
        this.suit = suit;
        this.value = value;
        this.rank = rank;
    }

    /**
     * Changes the value of a card with the rank of Ace from 1 to 11, or vice versa
     */
    public void changeAceValue()
    {
        if(rank.equals(CardRank.Ace))
        {
            if(value == 1)
            {
                value = 11;
            }
            else
            {
                value = 1;
            }
        }
    }

    @Override
    public String toString()
    {
        String output = rank + " of " + suit;
        return output;
    }

    public int getValue() {
        return value;
    }

    public boolean isAce() {
        return rank.equals(CardRank.Ace);
    }
}
