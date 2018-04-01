/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package lewisproject1;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

/**
 * This class will act as the Controller and View for our 
 * Solitaire game. It will extend JFrame for the View model
 * and it will also act as a controller with our logic class. 
 * @author Logarithm
 */
public class CV extends JFrame {
    
    private Board board;
    private JMenuBar menuBar;
    private JMenu menuF;
    private JMenuItem newGame;
    private JMenu menuE;
    private JMenuItem bgColor;
    
    public CV(){
        //default settings for JFrame
        this.setSize(650,550);
        //this.setLayout(new BorderLayout());
        this.setTitle("Solitaire");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.getContentPane().setBackground(new Color(51250));
        this.setVisible(true);
        
        menuBar = new JMenuBar();
        menuF = new JMenu("File");
        menuBar.add(menuF);
        menuE = new JMenu("Edit");
        menuBar.add(menuE);
        //newGame will go in File
        newGame = new JMenuItem("New Game");
        newGame.setMnemonic(KeyEvent.VK_N);
        //This action listener allows us to create a new game! [Board is currently a Solitaire Game]
        newGame.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    remove(board);
                    board = new Board();
                    board.initializeCards();
                    add(board, BorderLayout.CENTER);
                    validate();
                    repaint();
                }
        });
        menuF.add(newGame);
        //bgColor will go in Edit
        bgColor = new JMenuItem("BG Color");
        bgColor.setMnemonic(KeyEvent.VK_B);
        bgColor.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Color newColor = JColorChooser.showDialog(
                        null, "Choose a Background Color", getContentPane().getBackground());
                if(newColor != null) {
                    getContentPane().setBackground(newColor);
                }
            }
        });
        menuE.add(bgColor);
        //add board to JFrame
        board = new Board();
        board.initializeCards();
        this.add(menuBar, BorderLayout.NORTH);
        this.add(board, BorderLayout.CENTER);
    } 
}
