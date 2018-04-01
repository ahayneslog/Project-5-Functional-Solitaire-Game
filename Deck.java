/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package lewisproject1;

/**
 *
 * @author Logarithm
 */
public interface Deck {
    
    /**
    * remove one card from deck
    * if the deck is empty, return null
    * @return the card removed from the deck
    */
   Card dealOneCard();

   /**
    * remove one or more cards from deck
    * if the decks contains insufficient cards, return null
    * @param n is the number of cards to be dealt
    * @return a stackOfCards
    */
   CardStack dealMultipleCards(int n);

   /**
    * @return reference to card to be dealt next
    */
   Card peek();

   /**
    * cuts the deck in two portions at a random position
    * swaps the lower portion and upper portion
    * there must be at least one card in each portion
    * if deck has less than two cards, does nothing
    */
   void cutTheDeck();

   /**
    * randomize cards currently in the deck
    */
   void shuffle();

   /**
    * @return the number of cards currently in the deck
    */
   int size();

   /**
    * a typical toString implementation
    * inserts a newline after each card
    * @return the string describing the deck
    */
   String toString();
}
