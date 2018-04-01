/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package lewisproject1;

import java.awt.*;
import java.util.*;
import java.io.IOException;

/**
 *
 * @author Logarithm
 */
public class FinalStack extends StackOfCards {
    
    int xLoc, yLoc;
    ArrayList<Card> wahey;
    Graphics2D g2;
    
    
    public FinalStack(int xLoc, int yLoc){
        this.xLoc = xLoc;
        this.yLoc = yLoc;
    }
    
    public void drawStack(Graphics g){
        wahey = getStack();
        g2 = (Graphics2D) g;
        if(g2 == null)
            System.out.println("This program crashed because the graphics context is null.");
        try {
                for (Card wahey1 : wahey) {
                    g2.drawImage(wahey1.getCardImage(), xLoc, yLoc, null);
                }
        } 
        catch(IOException e) {
            System.out.println("What did you do?!.");
        }  
    }
}
