# cs101s2020-final-project-PaigeCD
## Blackjack in Java
To run my program, cd into the PlayBlackjack folder and type 'java PlayBlackjack'.

## Card.java
  This file creates the Card class, its variables, and its methods.

## Deck.java
  This file creates the Deck class, its variable, and its methods. The Deck class is an array that stores Card objects.
  The constructor of Deck assigns the values and suits to all 52 cards.

## Hand.java
  This file creates the Hand class and its methods. The Hand class is a Vector that represents the hand of either the user of the dealer.

## BlackjackHand.java
  This file creates the BlackjackHand class, its variables, and its method. This class extends Hand. The method in this class, getHandValue, has the ability to add up a hand's total value.

## PlayBlackjack.java
  This file contains the program's main method and the blackjackRound method. The main method uses the user input to set the bet amount and calls the blackjackRound method. The blackjackRound returns a boolean, denoting whether the user won or lost. This method plays one round of blackjack.
