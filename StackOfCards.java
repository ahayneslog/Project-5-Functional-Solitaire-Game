package lewisproject1;

import java.util.ArrayList;

/**
 * StackOfCards implements the CardStack interface.
 * Project #3 : Deck and Hands
 * File: StackOfCards.java
 * 
 * @author Andrew C. Haynes
 * Project 3, COP 4331
 */
public class StackOfCards implements CardStack {

    private ArrayList<Card> stack;
    
    /**
     * The default constructor creates an array stack 
     * and sets the stack's count to 0. 
     */
    public StackOfCards() {
        stack = new ArrayList<Card>();
    }
    
    /**
     * Adds one card to the stack. If the card stack has 52 cards, 
     * no more cards can be pushed into the card stack. 
     * @param aCard a card that will be added to the top of the stack.
     */
    public void push(Card aCard){
        this.stack.add(aCard);
    }

    /**
     * Pops all cards from the stack in the parameter and
     * the stack that calls this method pushes them in. 
     * @param s a stack that will be pushed to the stack that calls this method.  
     */
    public void pushMultipleCards(CardStack s) {
        int sizeOfs = s.size();
        for(int i = 0; i < sizeOfs; i++)
            this.stack.add(s.pop());
    }

    /**
     * Removes the top card from the stack and returns it. 
     * @return popped is a card that will be taken from the top of the stack.
     */
    public Card pop() {
        if(this.stack.size() <= 0) {
            System.out.println("There are no cards in this stack to pop.");
            return null; //this is fine for our card game
        }
        else {
            return this.stack.remove(stack.size()-1);
        }
    }

    /**
     * Pops a "count" amount of cards from the stack and puts those 
     * cards into a new stack. 
     * @param count the amount of cards to pop from the stack.
     * @return newStack a new stack that pushed the popped cards. 
     */
    public CardStack popMultipleCards(int count) {
        StackOfCards newStack = new StackOfCards();
        if(count <= this.stack.size()) {
            for(int i = 0; i < count; i++) {
                newStack.stack.add(this.stack.remove(stack.size()-1));
            }
        }
        else {
            System.out.println("The amount you wanted exceeded the card count in this stack.\n" +
                    "You will get an empty stack in return.");
        }
        return newStack;
    }

    /**
     * Returns a reference of the top card of the stack. 
     * @return 
     */
    public Card peek() {
        if(stack.size() > 0)
            return stack.get(stack.size()-1);
        else 
            return null;
    }
    
    /**
     * Returns true if the stack is empty. 
     * @return true if stack is empty
     */
    public boolean isEmpty() {
        if(this.stack.isEmpty())
            return true;
        else 
            return false;
    }
    
    /**
     * Returns the amount of cards currently in the stack. 
     * @return stackCount is the amount of cards in the stack. 
     */
    public int size() {
        return this.stack.size();
    }
    
    /**
     * Returns the description of each card in the stack, 
     * one line at a time. 
     * @return stackDesc is the string that contains the stack information.
     */
    public String toString() {
        String stackDesc = "";
        for(Card a: this.stack)
            stackDesc += a + "\n";
        return stackDesc;
    }
    
    /**
     * Gets the ArrayList reference.
     * @return the ArrayList that holds the cards
     */
    public ArrayList getStack(){
        return stack;
    }
}
