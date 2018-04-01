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
public class Move {
    
    
    /**
     * GAME LOGIC CLASS GOES IN HERE!
     * It mainly goes to work in the MouseReleased block.
     */
    
    SolitaireLogic logic;
    static StackOfCards temp; //this holds the stack that was called in MousePressed, deal with it in MouseReleased.
    /**
     * If t is not null, that means Move is being used in MousePressed.
     * If f is not null, that means Move is being used in MouseRelease.
     * @param t
     * @param f 
     */
    public Move(StackOfCards t, StackOfCards f, boolean end) {
        logic = new SolitaireLogic();
        //MousePressed
        if((t != null) && (f == null)) {
            if(!t.isEmpty())
                temp = t;
        }
        //MouseReleased
        else if((t == null) && (f != null)) {
            if(temp != null) {
                //IF card is being released in final stack, do final stack legal move
                if(end) {
                    if(!temp.isEmpty())
                        logic.finalStackLegalMove(temp, f);
                    temp = null;
                }
                //ELSE, the card is being released in the work stacks
                else {
                    if(!temp.isEmpty())
                        logic.legalMove(temp, f);
                    temp = null;
                }
            }    
        }
        //MouseReleased in no stacks, stop using the MousePressed Stack!
        else if((t == null) && (f == null)) {
            temp = null;
        }
    }
}
