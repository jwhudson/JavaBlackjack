import java.util.ArrayList;

/**
 * The Player class represents a human player at the blackjack table.
 */
public class Player {
    private String playerName;
    private ArrayList<Card> playerHand;

    /**
     * Constructor for Player
     */
    public Player()
    {
        playerName = "Player 1";
        playerHand = new ArrayList<>();
    }

    /**
     * Adds the given card to playerHand
     * @param card, the card to be added to playerHand
     */
    protected void addToHand(Card card)
    {
        playerHand.add(card);
    }

    /**
     * Setter method for playerName instance field
     * @param playerName
     */
    public void setName(String playerName) {
        this.playerName = playerName;
    }

    /**
     * Getter method for playerName instance field
     * @return String, string representing the player name
     */
    public String getName() {
        return playerName;
    }

    /**
     * currentHand returns a string of each card in the players hand followed by a new line
     * @return String, string representation of the players hand.
     */
    public String currentHand()
    {
        String output = "";
        for (Card card : playerHand)
        {
            output += card.toString();
            output += "\n";
        }

        return output;
    }

    /**
     * handValue returns an int of the total value of each card in the players hand.
     * @return int, int representation of player hand value
     */
    public int handValue() {
        int output = 0;
        for(Card card : playerHand)
        {
            output += card.getValue();
        }
        return output;
    }

    /**
     * holdsAce returns a boolean which indicates if the player is currently holding an ace
     * @return boolean, true if an ace is held, false otherwise
     */
    public boolean holdsAce()
    {
        for (Card card : playerHand)
        {
            if(card.isAce())
            {
                return true;
            }
        }
        return false;
    }

    /**
     * Getter method for playerHand
     * @return ArrayList, list of cards in playerHand
     */
    public ArrayList<Card> getPlayerHand() {
        return playerHand;
    }


}
