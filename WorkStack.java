/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package lewisproject1;

import java.awt.*;
import java.io.IOException;
import java.util.*;

/**
 *
 * @author Logarithm
 */
public class WorkStack extends StackOfCards {
    
    int xLoc, yLoc;
    Graphics2D g2;
    ArrayList<Card> wahey;
    int CARDY = 97;
    
    public WorkStack(int xLoc, int yLoc){
        this.xLoc = xLoc;
        this.yLoc = yLoc;
    }
    
    /**
     * drawStack will draw the stack and all of the cards in it. 
     * --> Later on, finish implementing this correctly.
     * @param g 
     */
    public void drawStack(Graphics g){
        wahey = getStack();
        g2 = (Graphics2D) g;
        int counter = 0;
        if(g2 == null)
            System.out.println("This program crashed because the graphics context is null.");
        try {
                for (Card wahey1 : wahey) {
                    g2.drawImage(wahey1.getCardImage(), xLoc, yLoc+counter, null);
                    counter += 20;
                }
        } 
        catch(IOException e) {
            System.out.println("What did you do?!.");
        }  
    }
    
    public int getLength() {
        int size = wahey.size();
        int lengthOfStack = (size-1)*CARDY;
        return lengthOfStack;
    }
}
