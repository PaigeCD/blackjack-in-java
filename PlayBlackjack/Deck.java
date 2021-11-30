// This work is mine unless otherwise stated- Paige Downey
public class Deck {
    private Card[] deck;
    private int usedCards;
    // Constructor, creates a deck of 52 unique cards in order
    public Deck() {
       deck = new Card[52];
       int cardCount = 0;
       for ( int suit = 0; suit <= 3; suit++ ) {
          for ( int value = 1; value <= 13; value++ ) {
             deck[cardCount] = new Card(value,suit);
             cardCount++;
          }
       }
       usedCards = 0;
    }
    // Rearranges cards into random places
    public void shuffle() {
        for ( int i = 51; i > 0; i-- ) {
            int randomIndex = (int)(Math.random()*(i+1));
            Card temp = deck[i];
            deck[i] = deck[randomIndex];
            deck[randomIndex] = temp;
        }
        usedCards = 0;
    }
    // Deals a card, returns a card from deck
    public Card dealCard() {
      // Shuffles is whole deck is used
        if (usedCards == 52)
           shuffle();
        usedCards++;
        return deck[usedCards - 1];
    }

} // end class Deck
