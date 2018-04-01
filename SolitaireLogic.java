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
public class SolitaireLogic {
    
    public SolitaireLogic() {
        
    }
    
    /**
     * fromStack is t and toStack is f
     * @param t
     * @param f 
     */
    public void legalMove(StackOfCards t, StackOfCards f) {
        Card temp = t.peek();
        
        /**
         * CHECKS if work stack is empty. If it is, only allow a King to go in.
         */
        if(f.isEmpty()) {
            //CARD is a King, Put it in.
            if(temp.getValue(1) == 14) {
                f.push(t.pop());
            }
        }
        else {
            /**
         * IF the toStack has a Red Card on Top, make sure temp is Black,
         * then check if the value of temp is one less than f's top card
         * ELSE make sure temp is Red and then same procedure is the same
         * as above. This is Solitaire in the temporary stacks!
         */
            if(f.peek().isRedCard()) {
                if(!temp.isRedCard()){
                    if((f.peek().getValue(1) - temp.getValue(1)) == 1) {
                        f.push(t.pop());
                    }
                }
            }
            else {
                if(temp.isRedCard()) {
                    if((f.peek().getValue(1) - temp.getValue(1)) == 1) {
                        f.push(t.pop());
                    }
                }
            }
        }
    }
    
    /**
     * Checks if card can go in the final stack. If not, nothing happens.
     * @param t
     * @param f 
     */
    public void finalStackLegalMove(StackOfCards t, StackOfCards f) {
        Card temp = t.peek();
        //IF FINAL STACK IS EMPTY
        if(f.isEmpty()){
            if(temp.getValue(1) == 2){
                f.push(t.pop());
            }
        }
        //ELSE, MAKE SURE THAT THE CARD IS IN THE SAME SUIT AND IS ONE VALUE HIGHER
        else {
            //THE SUITS EQUAL
            if(f.peek().getSuit().equals(temp.getSuit())) {
                //IF CARD IS A VALUE HIGHER THAN THE CURRENT CARD IN FINAL STACK
                if((f.peek().getValue(1) - temp.getValue(1)) == -1) {
                    f.push(t.pop());
                }
            }
        }
    }
}
