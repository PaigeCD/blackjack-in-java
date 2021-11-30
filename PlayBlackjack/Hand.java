// This work is mine unless otherwise stated- Paige Downey
import java.util.Vector;
public class Hand {
   private Vector hand;
   public Hand() {
     // Constructor
      hand = new Vector();
   }
   // Adds card to hand
   public void addCard(Card card) {
      if (card != null)
         hand.addElement(card);
   }
   // Returns the amount of cards
   public int getCardCount() {
      return hand.size();
   }
   // Returns card at specified index
   public Card getCard(int position) {
      if (position >= 0 && position < hand.size())
         return (Card)hand.elementAt(position);
      else
         return null;
   }
}
