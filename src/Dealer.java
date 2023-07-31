import java.util.ArrayList;

/**
 * The Dealer class simulates a blackjack dealer, dealing cards to the player and the table.
 * @author James Hudson
 * @version 1.0
 * @since 06/06/2023
 */
public class Dealer {


    private Deck deckofCards;
    private ArrayList<Card> tableCards;
    private boolean showBoth;

    /**
     * Constructor for Dealer class
     */
    public Dealer()
    {
        deckofCards = new Deck();
        tableCards = new ArrayList<Card>();
        showBoth = false;
        dealTable();
    }

    /**
     * dealCards deals a card from deckOfCards to the provided player then shuffles the deck.
     * @param player
     */
    public void dealCard(Player player) {
        player.addToHand(drawCard());
        deckofCards.shuffleDeck();
    }

    /**
     * dealTable deals two cards from deckOfCards and adds them to tableCards
     */
    private void dealTable()
    {

        tableCards.add(drawCard());
        tableCards.add(drawCard());
    }

    /**
     * drawCard is a helper method to dealCard, it removes one card from deckOfCards and returns it
     * @return Card, the first card of deckOfCards
     */
    private Card drawCard()
    {
        return deckofCards.getCards().remove(0);
    }


    /**
     * currentTableCards returns a string of the current cards on the table, if visible to the players.
     * @return String, string representation of the table cards
     */
    public String currentTableCards() {
        String output = "";
        if(showBoth)
        {
            output += tableCards.get(0).toString();
            output += "\n";
            output += tableCards.get(1).toString();
        }
        else
        {
            output += tableCards.get(0).toString();
            output += "\n";
            output += "The second card is face down";
        }
        return output.trim();
    }

    /**
     * Sets showBoth to true, allowing the player to see both dealer cards.
     */
    public void setShowBoth()
    {
        showBoth = true;
    }

    public int handValue()
    {
        int output = 0;
        for(Card card : tableCards)
        {
            if(card.isAce() && output + 11 <= 21)
            {
                output += 11;
            }
            else {
                output += card.getValue();
            }
        }
        return output;
    }
}
