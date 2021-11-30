# Blackjack in Java

This program uses Java to simulate the card game Blackjack in the user's terminal. My aim was to make this program easy to use and fun to play. This project was completed as the final project for my CMPSC101 class. This program demonstrated that I could utilize classes in Java and create a program that can communicate across multiple files.

## Running the Program

To run the program, you will first need to clone the repository to your machine. Once the repository is cloned, navigate into it and the PlayBlackjack folder it contains:

```
cd blackjack-in-java/PlayBlackjack
```

Then run the program by entering the following command:

```
java PlayBlackjack
```

The program should begin running, welcoming you and prompting you to enter an amount to bet. Enter a whole number without a '$' to begin playing.

## Files Explained

### Card.java

This file creates the Card class, its variables, and its methods.

### Deck.java

This file creates the Deck class, its variable, and its methods. The Deck class is an array that stores Card objects. The constructor of Deck assigns the values and suits to all 52 cards.

### Hand.java

This file creates the Hand class and its methods. The Hand class is a Vector that represents the hand of either the user of the dealer.

### BlackjackHand.java

This file creates the BlackjackHand class, its variables, and its method. This class extends Hand. The method in this class, getHandValue, has the ability to add up a hand's total value.

### PlayBlackjack.java

This file contains the program's main method and the blackjackRound method. The main method uses the user input to set the bet amount and calls the blackjackRound method. The blackjackRound returns a boolean, denoting whether the user won or lost. This method plays one round of blackjack.
