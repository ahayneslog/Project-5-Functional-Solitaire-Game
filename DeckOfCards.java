package lewisproject1;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.Random;
import javax.imageio.ImageIO;

/**
 * DeckOfCards implements the Deck interface.
 * Project #3 : Deck and Hands
 * File: DeckOfCards.java
 * 
 * @author Andrew C. Haynes
 * Project 3, COP 4331
 */

public class DeckOfCards implements Deck{
    
    private StackOfCards deck;
    int xLoc, yLoc;
    
    /**
     * Default Constructor for the DeckOfCards object. 
     * It will create a deck of 52 cards for you. 
     */
    public DeckOfCards(int xLoc, int yLoc){
        deck = new StackOfCards();
        this.xLoc = xLoc;
        this.yLoc = yLoc;
        /**
         * Since there is no option to add cards to the deck, 
         * the deck will become a standard deck of 52 cards 
         * at the construction of the deck object.
         **/
        for(int i = 0; i < 52; i++){
            deck.push(new Card(i));
        }
    }
    /**
    * Remove one card from the deck.
    * If the deck is empty, return null.
    * @return a card removed from the deck
    */
   public Card dealOneCard(){
       if(this.deck.getStack().size() < 0)
           return null;
       else
           return deck.pop();
   }

   /**
    * Remove one or more cards from deck.
    * If the decks contains insufficient cards, return null.
    * @param n is the number of cards to be dealt
    * @return a stackOfCards
    */
   public CardStack dealMultipleCards(int n){
       if(this.deck.getStack().size() < n)
           return null;
       else
           return deck.popMultipleCards(n);
   }

   /**
    * @return reference to card to be dealt next
    */
   public Card peek(){
       return deck.peek();
   }

   /**
    * Cuts the deck in two portions at a random position.
    * It will swap the lower portion and upper portion.
    * There must be at least one card in each portion.
    * If deck has less than two cards, does nothing.
    */
   public void cutTheDeck(){
       if(deck.size() > 2) {
           Random rand = new Random();
           int range = rand.nextInt(deck.size());
           int remainder = (deck.size()) - range;
           CardStack t1 = new StackOfCards();
           CardStack t2 = new StackOfCards();
           t1.pushMultipleCards(deck.popMultipleCards(range));
           t2.pushMultipleCards(deck.popMultipleCards(remainder));
           deck.pushMultipleCards(t1.popMultipleCards(range));
           deck.pushMultipleCards(t2.popMultipleCards(remainder));
       }
   }

   /**
    * Randomize cards currently in the deck.
    */
   public void shuffle(){
       Collections.shuffle(deck.getStack());
   }

   /**
    * @return the number of cards currently in the deck
    */
   public int size(){
       return deck.size();
   }

   /**
    * A toString implementation that 
    * describes the deck by listing every card in it. 
    * @return the string describing the deck
    */
   public String toString(){
      return deck.toString(); 
   }
   
   public boolean isEmpty(){
       if(deck.getStack().isEmpty())
           return true;
       else
           return false;
   }
   
   public void pushMultipleCards(CardStack s) {
        int sizeOfs = s.size();
        for(int i = 0; i < sizeOfs; i++)
            this.deck.getStack().add(s.pop());
    }
   
   
   public void drawDeck(Graphics g){
       Image temp;
       Graphics2D g2;
        try {
            g2 = (Graphics2D) g;
            String idea = System.getProperty("user.dir");
            idea = idea.replace("\\", "/");
            String fileName = idea + "/src/lewisproject1/Cards/52.gif";
            temp = ImageIO.read(new File(fileName));
            //temp.getScaledInstance(73, 97, 1);
            g2.drawImage(temp, xLoc, yLoc, null);
        }
        catch (IOException e) {
            System.out.println(e.getMessage());
            temp = null;
        }
   }
}
