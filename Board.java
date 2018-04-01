/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package lewisproject1;

import java.awt.*;
import java.io.IOException;
import javax.swing.*;
import java.awt.event.*;

/**
 *
 * @author Logarithm
 */
public class Board extends JPanel {
    
    //graphics context
    private Graphics2D g2;
    //Global Card Size
    final int CARDX = 73;
    final int CARDY = 97;
    //Global Row Areas
    final int ROW1 = 10; //deck, discard and final stacks are in this row
    final int ROW2 = 130; //temporary stacks are in this row
    /**
     * Stacks for this Solitaire Game
     **/
    DeckOfCards deck;
    DiscardStack discardStack;
    WorkStack w1;
    WorkStack w2;
    WorkStack w3;
    WorkStack w4;
    WorkStack w5;
    WorkStack w6;
    WorkStack w7;
    FinalStack f1;
    FinalStack f2;
    FinalStack f3;
    FinalStack f4;
    Move move;
    /**
     * xBegin, yBegin for Mouse Pressed
     * xDragged, yDragged for Mouse Dragged  [Mouse released is handled locally!]
     */
    int xBegin;
    int yBegin;
    int xDragged;
    int yDragged;
    
    /**
     * These variables determine the boundaries of each stack.
     * These are needed to make the code look cleaner in the control flows
     * of stacks in mouse events. 
     */
    //DEBATE ON IF WE WANT CLEAN CODE OR NOT, FOR NOW, WORK ON MAKING GAME WORKING
    
    /**
     * Default constructor of the game board. 
     * It initializes the JPanel's size, makes sure it is not opaque
     * and that it is visible. 
     */
    public Board(){
        this.setSize(850, 550);
        this.setOpaque(false); //this makes sure paint works correctly
        setVisible(true);
        
        /**
         * This mouse pressed event grabs where the mouse is pressed. 
         * If the mouse is pressed in the deck area, the card goes in the discard stack
         * where the user can decide if they want to use it in the work stacks. 
         */
        this.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                xBegin = e.getX();
                yBegin = e.getY();
                
                //CASE: mouse press in the deck stack
                if(((xBegin > ROW1) && (xBegin < (ROW1+CARDX))) && ((yBegin > 10) && (yBegin < 10+CARDY))){
                    if(!deck.isEmpty()) {
                            discardStack.push(deck.dealOneCard());
                            //set the card's faceDown value to false
                            discardStack.peek().isFaceDown(0);
                    }
                    else {
                        if(!discardStack.isEmpty())
                            deck.pushMultipleCards(discardStack);
                    }
                    repaint();    
                }
                
                //CASE: mouse is pressed in discard stack, user can take card out [CANNOT put it in deck]
                if(((xBegin > 98) && (xBegin < 171)) && ((yBegin > 10) && (yBegin < 10+CARDY))) {
                    if(!discardStack.isEmpty()) {
                        move = new Move(discardStack, null, false);
                    }
                }
                
                else if(((xBegin > 274) && (xBegin < 352)) && ((yBegin > 10) && (yBegin < 10+CARDY))) {
                    if(!f1.isEmpty()) {
                        move = new Move(f1, null, false);
                    }
                }
                
                else if(((xBegin > 362) && (xBegin < 440)) && ((yBegin > 10) && (yBegin < 10+CARDY))) {
                    if(!f2.isEmpty()) {
                        move = new Move(f2, null, false);
                    }
                }
                
                else if(((xBegin > 450) && (xBegin < 528)) && ((yBegin > 10) && (yBegin < 10+CARDY))) {
                    if(!f3.isEmpty()) {
                        move = new Move(f3, null, false);
                    }
                }
                
                else if(((xBegin > 538) && (xBegin < 616)) && ((yBegin > 10) && (yBegin < 10+CARDY))) {
                    if(!f4.isEmpty()) {
                        move = new Move(f4, null, false);
                    }
                }
                
                //CASE: mouse is pressed in work stack one
                else if(((xBegin > 10) && xBegin < 88) && (yBegin > 130) && (yBegin < 130+CARDY)){
                    if(!w1.isEmpty()) {
                        move = new Move(w1, null, false);
                    }
                }
                else if(((xBegin > 98) && (xBegin < 171)) && (yBegin > 130) && (yBegin < 130+CARDY)) {
                    if(!w2.isEmpty()) {
                        move = new Move(w2, null, false);
                    }
                }
                else if(((xBegin > 186) && (xBegin < 259)) && (yBegin > 130) && (yBegin < 130+CARDY)) {
                    if(!w3.isEmpty()) {
                        move = new Move(w3, null, false);
                    }
                }
                else if(((xBegin > 274) && (xBegin < 347)) && (yBegin > 130) && (yBegin < 130+CARDY)) {
                    if(!w4.isEmpty()) {
                        move = new Move(w4, null, false);
                    }
                }
                else if(((xBegin > 362) && (xBegin < 435)) && (yBegin > 130) && (yBegin < 130+CARDY)) {
                    if(!w5.isEmpty()) {    
                        move = new Move(w5, null, false);
                    }
                }
                else if(((xBegin > 450) && (xBegin < 523)) && (yBegin > 130) && (yBegin < 130+CARDY)) {
                    if(!w6.isEmpty()) {
                        move = new Move(w6, null, false);
                    }
                }
                else if(((xBegin > 538) && (xBegin < 611)) && (yBegin > 130) && (yBegin < 130+CARDY)) {
                    if(!w7.isEmpty()) {
                        move = new Move(w7, null, false);
                    }
                }
                else {
                    //do nothing! You didn't press anywhere useful, silly.
                }
            }
        });
        
        this.addMouseListener(new MouseAdapter() {
            public void mouseReleased(MouseEvent e) {
                int x = e.getX();
                int y = e.getY();
                //final stack 1
                if(((x > 274) && (x < 352)) && ((y > 10) && (y < 10+CARDY))) {
                    move = new Move(null, f1, true);
                    repaint();
                }
                //final stack 2
                else if(((x > 362) && (x < 440)) && ((y > 10) && (y < 10+CARDY))) {
                    move = new Move(null, f2, true);
                    repaint();
                }
                //final stack 3
                else if(((x > 450) && (x < 528)) && ((y > 10) && (y < 10+CARDY))) {
                    move = new Move(null, f3, true);
                    repaint();
                }
                //final stack 4
                else if(((x > 538) && (x < 616)) && ((y > 10) && (y < 10+CARDY))) {
                    move = new Move(null, f4, true);
                    repaint();
                }
                //work 1
                else if(((x > 10) && x < 88) && (y > 130) && (y < 130+CARDY)){
                    move = new Move(null, w1, false);
                    repaint();
                }
                //work 2
                else if(((x > 98) && (x < 171)) && (y > 130) && (y < 130+CARDY)) {
                    move = new Move(null, w2, false);
                    repaint();
                }
                //work 3
                else if(((x > 186) && (x < 259)) && (y > 130) && (y < 130+CARDY)) {
                    move = new Move(null, w3, false);
                    repaint();
                }
                //work 4
                else if(((x > 274) && (x < 347)) && (y > 130) && (y < 130+CARDY)) {
                    move = new Move(null, w4, false);
                    repaint();
                }
                //work 5
                else if(((x > 362) && (x < 435)) && (y > 130) && (y < 130+CARDY)) {
                    move = new Move(null, w5, false);
                    repaint();
                }
                //work 6
                else if(((x > 450) && (x < 523)) && (y > 130) && (y < 130+CARDY)) {
                    move = new Move(null, w6, false);
                    repaint();
                }
                //work 7
                else if(((x > 538) && (x < 611)) && (y > 130) && (y < 130+CARDY)) {
                    move = new Move(null, w7, false);
                    repaint();
                }
                //return the card
                else {
                    move = new Move(null, null, false);
                    repaint();
                }
            }
        }); 
    }
    
    /**
     * Initializes all of the areas of the game. 
     * The deck, the finishing stacks, the discard stack and the work stacks.
     */
    public void initializeCards(){
        deck = new DeckOfCards(10, ROW1);
        deck.shuffle();
        discardStack = new DiscardStack(98, ROW1);
        w1 = new WorkStack(10, ROW2);
        w2 = new WorkStack(98, ROW2);
        w3 = new WorkStack(186, ROW2);
        w4 = new WorkStack(274, ROW2);
        w5 = new WorkStack(362, ROW2);
        w6 = new WorkStack(450, ROW2);
        w7 = new WorkStack(538, ROW2);
        f1 = new FinalStack(274, ROW1);
        f2 = new FinalStack(362, ROW1);
        f3 = new FinalStack(450, ROW1);
        f4 = new FinalStack(538, ROW1);
        w1.push(deck.dealOneCard());
        w2.pushMultipleCards(deck.dealMultipleCards(2));
        w3.pushMultipleCards(deck.dealMultipleCards(3));
        w4.pushMultipleCards(deck.dealMultipleCards(4));
        w5.pushMultipleCards(deck.dealMultipleCards(5));
        w6.pushMultipleCards(deck.dealMultipleCards(6));
        w7.pushMultipleCards(deck.dealMultipleCards(7));
        w1.peek().isFaceDown(0);
        w2.peek().isFaceDown(0);
        w3.peek().isFaceDown(0);
        w4.peek().isFaceDown(0);
        w5.peek().isFaceDown(0);
        w6.peek().isFaceDown(0);
        w7.peek().isFaceDown(0);
    }
    
    
    
    
    
    
    /**
     * paintComponent will always paint what is in the stacks. 
     * @param g 
     */
    @Override
    public void paintComponent(Graphics g){
        super.paintComponents(g);
        g2 = (Graphics2D) g;
        //first two parameters sets location: horizontal, vertical; other two sets size: length, width
        //10 is the horizontal location for this row
        //deck stack location
        g2.drawRect(10, ROW1, CARDX, CARDY);
        //stack one location [part of final stacks]
        g2.drawRect(274, ROW1, CARDX, CARDY);
        //stack two location [part of final stacks]
        g2.drawRect(362, ROW1, CARDX, CARDY);
        //stack three location [part of final stacks]
        g2.drawRect(450, ROW1, CARDX, CARDY);
        //stack four location [part of final stacks]
        g2.drawRect(538, ROW1, CARDX, CARDY);
        //temporary stacks for game, Seven Stacks || 130 is the horizontal location for this row
        g2.drawRect(10, ROW2, CARDX, CARDY);
        g2.drawRect(98, ROW2, CARDX, CARDY);
        g2.drawRect(186, ROW2, CARDX, CARDY);
        g2.drawRect(274, ROW2, CARDX, CARDY);
        g2.drawRect(362, ROW2, CARDX, CARDY);
        g2.drawRect(450, ROW2, CARDX, CARDY);
        g2.drawRect(538, ROW2, CARDX, CARDY);
        
        deck.drawDeck(g2);
        discardStack.drawDiscardStack(g2);
        f1.drawStack(g2);
        f2.drawStack(g2);
        f3.drawStack(g2);
        f4.drawStack(g2);
        w1.drawStack(g2);
        w2.drawStack(g2);
        w3.drawStack(g2);
        w4.drawStack(g2); 
        w5.drawStack(g2);
        w6.drawStack(g2);
        w7.drawStack(g2);
        
        /**
         * Makes sure the bottom of each work stack is diplayed correctly throughout the game.
         */
        if(!w1.isEmpty())
            w1.peek().isFaceDown(0);
        if(!w2.isEmpty())
            w2.peek().isFaceDown(0);
        if(!w3.isEmpty())
            w3.peek().isFaceDown(0);
        if(!w4.isEmpty())
            w4.peek().isFaceDown(0);
        if(!w5.isEmpty())
            w5.peek().isFaceDown(0);
        if(!w6.isEmpty())
            w6.peek().isFaceDown(0);
        if(!w7.isEmpty())
            w7.peek().isFaceDown(0);
    } 
}
