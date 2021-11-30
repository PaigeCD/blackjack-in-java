// This work is mine unless otherwise stated- Paige Downey
import java.util.Scanner;
public class PlayBlackjack {
      public static void main(String[] args) {
         int balance;
         int bet;
         boolean userWins;
         Scanner input = new Scanner(System.in);
         System.out.println("--------------------------------------------------");
         System.out.println("               Welcome to Blackjack!"              );
         System.out.println("--------------------------------------------------");
         balance = 150;
         while (true) {
             System.out.println("You have $" + balance + ".");
             do {
                System.out.println("How much would you like to bet? (Enter 0 to quit playing.)");
                bet = input.nextInt();
                // Makes sure the entered bet is valid
                if (bet < 0 || bet > balance) {
                    System.out.println("Invalid bet!");
                    System.out.println("Your bet must be between 1 and " + balance + ".");
                }
             } while (bet < 0 || bet > balance);
             if (bet == 0)
                break;
              // Calls method to play a round of Blackjack
             userWins = blackjackRound();
             if (userWins)
                balance += bet;
             else
                balance -= bet;
             System.out.println();
             if (balance == 0) {
                System.out.println("You have no money left. Thanks for playing!");
                break;
             }
         } // ends while true that represents game play
         if (balance != 0){
           System.out.println("");
           System.out.println("You're leaving with $" + balance + ". Congrats!");
         }
      } // ends main method
      // Method that play one round of Blackjack, returns true if the user wins
      static boolean blackjackRound() {
         Deck deck;
         BlackjackHand dealerHand;
         BlackjackHand userHand;
         Scanner input = new Scanner(System.in);
         deck = new Deck();
         dealerHand = new BlackjackHand();
         userHand = new BlackjackHand();
         deck.shuffle();
         // In Blackjack, each player starts with two cards
         dealerHand.addCard( deck.dealCard());
         dealerHand.addCard( deck.dealCard());
         userHand.addCard( deck.dealCard());
         userHand.addCard( deck.dealCard());
        // Case where dealer has Blackjack. Users loses in the case of a tie.
         if (dealerHand.getHandValue() == 21) {
              System.out.println("Dealer has the " + dealerHand.getCard(0) + " and the " + dealerHand.getCard(1) + ".");
              System.out.println("You have the " + userHand.getCard(0) + " and the " + userHand.getCard(1) + ".");
              System.out.println();
              System.out.println("Dealer has Blackjack. Dealer wins...");
              System.out.println("--------------------------------------------------");
              return false;
         }
         // Case where user has Blackjack
         if (userHand.getHandValue() == 21) {
              System.out.println("Dealer has the " + dealerHand.getCard(0) + " and the " + dealerHand.getCard(1) + ".");
              System.out.println("You have the " + userHand.getCard(0) + " and the " + userHand.getCard(1) + ".");
              System.out.println();
              System.out.println("You have Blackjack! You win!");
              System.out.println("--------------------------------------------------");
              return true;
         }
         // Case in which neither dealer nor user begin with a Blackjack
         while (true) {
           System.out.println("--------------------------------------------------");
              System.out.println("Your cards are:");
              // Prints all cards in user's hand
              for ( int i = 0; i < userHand.getCardCount(); i++ )
                 System.out.println("\t" + userHand.getCard(i));
              System.out.println("Your hand's total value is " + userHand.getHandValue());
              System.out.println("");
              System.out.println("Dealer is showing the " + dealerHand.getCard(0));
              System.out.println("--------------------------------------------------");
              System.out.println("Would you like to Hit [H] or Stand [S]?");
              char userAction;
              // Validates that user enters H or S
              do {
                 userAction = input.next().toUpperCase().charAt(0);
                 if (userAction != 'H' && userAction != 'S')
                    System.out.println("Please choose to Hit [H] or Stand [S].");
              } while (userAction != 'H' && userAction != 'S');
              // Case in which user Stands
              if ( userAction == 'S' ) {
                  System.out.println("You stand.");
                  break;
              }
              // Case in which the user hits
              else {
                  Card newCard = deck.dealCard();
                  userHand.addCard(newCard);
                  System.out.println("--------------------------------------------------");
                  System.out.println("You hit.");
                  System.out.println("Your card is the " + newCard);
                  System.out.println("Your hand's total value is now " + userHand.getHandValue() + ".");
                  // Case in which user hits and exceeds 21
                  if (userHand.getHandValue() > 21) {
                      System.out.println();
                      System.out.println("You busted by going over 21. You lose...");
                      System.out.println("Dealer's other card was the " + dealerHand.getCard(1));
                      System.out.println("--------------------------------------------------");
                      return false;
                  }
              }
         } // end of while loop for hit or stand
         System.out.println("--------------------------------------------------");
         System.out.println("The dealer's cards are:");
         System.out.println("\t" + dealerHand.getCard(0));
         System.out.println("\t" + dealerHand.getCard(1));
         // Dealer must hit if their hand is 16 or less
         while (dealerHand.getHandValue() <= 16) {
            Card newCard = deck.dealCard();
            System.out.println("Dealer hits and gets the " + newCard);
            dealerHand.addCard(newCard);
            System.out.println("The dealer's hand's total value is now " + dealerHand.getHandValue() + ".");
            System.out.println();
            // Case in which dealer hits and busts
            if (dealerHand.getHandValue() > 21) {
               System.out.println("The dealer busted by going over 21. You win!");
               System.out.println("--------------------------------------------------");
               return true;
            }
         }
         System.out.println("Dealer's total is " + dealerHand.getHandValue());
         System.out.println();
         // Case in which user and dealer tie, dealer wins ties
         if (dealerHand.getHandValue() == userHand.getHandValue()) {
            System.out.println("The dealer wins on a tie. You lose...");
            System.out.println("--------------------------------------------------");
            return false;
         }
         // Case in which dealer's hand value is greater than the user's, dealer wins
         else if (dealerHand.getHandValue() > userHand.getHandValue()) {
            System.out.println("Dealer wins, " + dealerHand.getHandValue() + " points to " + userHand.getHandValue() + "...");
            System.out.println("--------------------------------------------------");
            return false;
         }
         // Case in which user's hand value is greater than the dealer's, user wins
         else {
            System.out.println("You win, " + userHand.getHandValue() + " points to " + dealerHand.getHandValue() + "!");
            System.out.println("--------------------------------------------------");
            return true;
         }
      }  // end blackjackRound()

   } // end class PlayBlackjack
