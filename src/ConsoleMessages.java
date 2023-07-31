public class ConsoleMessages {

    public void printGreeting()
    {
        System.out.println("Welcome to Blackjack!");
    }


    public void playerName() {
        System.out.println("Please enter your name: ");
    }

    public void greetPlayer(Player player) {
        System.out.println("Welcome " + player.getName());
    }

    public void playerCards(Player player) {
        System.out.println("Your current cards are: ");
        System.out.println(player.currentHand());
    }

    public void printCard(Card card)
    {
        System.out.println(card);
    }

    public void dealerCards(Dealer dealer) {
        System.out.println("The dealers current cards are: ");
        System.out.println(dealer.currentTableCards());
    }

    public void playerChoice(Player player) {
        System.out.println("Do you want to stand or hit?");

    }

    public void playerHandValue(Player player) {
        System.out.println("You current hand value is: " + player.handValue());
    }

    public void indicateAce(String ace) {
        System.out.println(ace +  "\t<----- Would you like to change this aces value (y/n)");
    }


    public void playerBust(Player player) {
        System.out.println("Your hand value is " + player.handValue());
        System.out.println("You've gone bust!");
    }

    public void lineBreak()
    {
        System.out.println("**************************************");
    }

    public void playerWins() {
        System.out.println("You win!");
    }

    public void handValues(Player player, Dealer dealer) {
        System.out.println("Your hand value is: " + player.handValue());
        System.out.println("The dealer's hand value is: " + dealer.handValue());
    }

    public void dealerWins() {
        System.out.println("The dealer wins!");
    }

    public void drawRound() {
        System.out.println("Both hand values are equal!");
        System.out.println("This round is a draw.");
    }
}
