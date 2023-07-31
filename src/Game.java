import java.util.Scanner;

public class Game {
    private Player player;
    private Dealer dealer;
    private ConsoleMessages messages;
    private Scanner scanner;
    public Game()
    {
        player = new Player();
        dealer = new Dealer();
        messages = new ConsoleMessages();
        scanner = new Scanner(System.in);
    }

    public void play() {
        gameSetUp();
        playRound();
    }

    /**
     * playRound is responsible for the main gameplay loop
     * The cards are dealt, information displayed and the player is given choice to hit or stand based on the game state
     * The outcome of the round is then displayed.
     */
    private void playRound() {
        boolean roundOver = false;
        messages.dealerCards(dealer);
        do {
            showPlayerHandInformation();
            if(player.holdsAce())
            {
                determineAceValue();
                showPlayerHandInformation();
            }
            messages.playerChoice(player);
            String playerChoice = scanner.nextLine();
            playerHitOrStand(playerChoice);
            roundOver = isRoundOver(playerChoice);
        } while( !roundOver);
        dealer.setShowBoth();
        messages.dealerCards(dealer);

        determineWinner();
    }

    /**
     * Helper method to playRound
     * Determines the winner of the game
     */
    private void determineWinner() {
        messages.handValues(player, dealer);
        if(player.handValue() > 21)
        {
            messages.playerBust(player);
        }
        else if(player.handValue() > dealer.handValue())
        {
            messages.playerWins();
        }
        else if(dealer.handValue() > player.handValue())
        {
            messages.dealerWins();
        }
        else
        {
            messages.drawRound();
        }
    }

    /**
     * Helper method to playRound
     * Prints the current cards in the players hand and the total hand value.
     */
    private void showPlayerHandInformation()
    {
        messages.playerHandValue(player);
        messages.playerCards(player);
        messages.lineBreak();
    }

    /**
     * Helper method to PlayRound
     * Allows the player to determine the value of any aces they are holding.
     */
    private void determineAceValue()
    {
        for (Card card : player.getPlayerHand()) {
            if (card.isAce()) {
                messages.indicateAce(card.toString());
                String userInput = scanner.nextLine();
                if (userInput.equals("y")) {
                    card.changeAceValue();
                    messages.playerHandValue(player);
                }
            } else {
                messages.printCard(card);
            }
        }

    }

    /**
     * Helper method to playRound. Determines if the round is over.
     * A round is over if the player chooses to stand or the players hand value is greater than 21
     * @param playerChoice, A String representing if the player chose to hit or stand
     * @return boolean, True if the player chooses to stand or the players hand value is greater than 21, false otherwise.
     */
    private boolean isRoundOver(String playerChoice) {
        if(player.handValue() > 21 || playerChoice.equals("stand"))
            return true;
        else
        {
            return false;
        }
    }

    /**
     * Helper method to playRound
     * Deals a card to the player if the given string is equal to "hit".
     * @param playerChoice
     */
    private void playerHitOrStand(String playerChoice)
    {
        if(playerChoice.equals("hit"))
        {
            dealer.dealCard(player);
        }
    }

    /**
     * Helper method to playRound.
     * Determines the player's name and deals cards to the player and dealer.
     */
    private void gameSetUp() {
        determinePlayerName();
        dealer.dealCard(player);
        dealer.dealCard(player);

    }

    /**
     * Helper method to playRound.
     * Greets the player, gets and sets the player's name based on input from the player
     */
    private void determinePlayerName()
    {
        messages.printGreeting();
        messages.playerName();
        String playerName = scanner.nextLine();
        player.setName(playerName);
        messages.greetPlayer(player);
    }
}
