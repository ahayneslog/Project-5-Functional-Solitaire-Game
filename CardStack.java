package lewisproject1;

/**
 *
 * @author Logarithm
 */
public interface CardStack {
    int CARDS_PER_STACK = 52;
    int CARDS_PER_SUIT = 13;

    // add one card to the top of the stack
    void push(Card aCard);

    // move all the cards from stack s to this.stack
    void pushMultipleCards(CardStack s);

    // remove one card from the top of the stack
    // return the card
    Card pop();

    // pop "count" cards from this stack and add to a new stack
    // return the new stack
    CardStack popMultipleCards(int count);

    // return a reference to the card currently on top of this stack
    Card peek();
    
    // return true if emtpy
    boolean isEmpty();
    
    // return number of cards currently on the stack
    int size();
    
    // return a multi-line string containing a 
    // description of all the cards on this stack
    // NOTE: one card per line
    String toString();
}
