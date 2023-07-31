import java.util.ArrayList;
import java.util.Collections;
public class Deck {

    private ArrayList<Card> cards;

    public Deck()
    {
        cards = new ArrayList<>();
        createDeck();
        shuffleDeck();
    }

    /**
     * Getter method for cards
     * @return ArrayList<Card> cards
     */
    public ArrayList<Card> getCards()
    {
        return cards;
    }
    public void shuffleDeck()
    {
        Collections.shuffle(cards);
    }

    private void createDeck() {
        ArrayList<CardRank> ranks = new ArrayList<CardRank>();
        for (CardRank rank : CardRank.values())
        {
            ranks.add(rank);
        }
        for(Suits suit : Suits.values())
        {
            for(int value = 1; value < 11; value++)
            {
                int cardValue = value;
                if(value > 10)
                {
                    cardValue = 10;
                }

                Card card = new Card(suit, cardValue, ranks.get(value - 1));
                cards.add(card);
            }
        }
    }

    public void printDeck()
    {
        for(Card card : cards)
        {
            System.out.println(card);
        }
    }
}
