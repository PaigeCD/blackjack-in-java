// This work is mine unless otherwise stated- Paige Downey
public class BlackjackHand extends Hand {
      // Made to return the value of a hand
     public int getHandValue() {
         int value;
         boolean hasAce;
         int cardCount;
         value = 0;
         hasAce = false;
         cardCount = getCardCount();
         // Adds up the value of the hand by iterating through the cards
         for ( int i = 0;  i < cardCount;  i++ ) {
             Card card;
             int cardValue;
             card = getCard(i);
             cardValue = card.getValue();
             // Jack, Queen, and King were labeled 11, 12, 13 but are counted as 10 in Blackjack
             if (cardValue > 10) {
                 cardValue = 10;
             }
             // Checks if the hand contains an ace
             if (cardValue == 1) {
                 hasAce = true;
             }
             value += cardValue;
          }
          // Aces can be counted as 1 or 11,
          // if the value is less than 21, add 10 because the ace has already been counted as 1
          if ( hasAce == true  &&  value + 10 <= 21 )
              value += 10;
          return value;
     }  // end getHandValue()

} // end class BlackjackHand
