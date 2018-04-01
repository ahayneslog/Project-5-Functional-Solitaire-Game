/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package lewisproject1;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Logarithm
 */
public class DiscardStack extends StackOfCards {
    
    int xLoc, yLoc;
    Graphics2D g2;
    ArrayList<Card> discard;
    
    public DiscardStack(int xLoc, int yLoc){
        this.xLoc = xLoc;
        this.yLoc = yLoc;
    }
    
    public void drawDiscardStack(Graphics g){
        discard = getStack();
        g2 = (Graphics2D) g;
        if(g2 == null)
            System.out.println("This program crashed because the graphics context is null.");
        try {
            for (Card discard1 : discard) {
                g2.drawImage(discard1.getCardImage(), xLoc, yLoc, null);
            }
        } 
        catch(IOException e) {
            System.out.println("What did you do?!.");
        }
    }
}
