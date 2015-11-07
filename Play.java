/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment2;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates and open the template
 * in the editor.
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 *
 * @author Eva
 */
public class ChessBoard extends JFrame {

    final static int BOARD_SIZE = 8;

    public static void main(String args[]) {
        final Color HOTPINK = new Color(251, 12, 138);
        final Color BUBBLEGUM = new Color(35, 210, 254);

        JFrame.setDefaultLookAndFeelDecorated(true);
        JFrame chessFrame;
        GridLayout boardLayout;

        JButton[][] BoardSpace = new JButton[BOARD_SIZE][BOARD_SIZE];

        chessFrame = new JFrame("HOTPINK BUBBLEGUM BUTTON PUSH"); // sets the frame to but the grid layout 
        chessFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        boardLayout = new GridLayout(BOARD_SIZE, BOARD_SIZE);// creates a grid layout 
        chessFrame.setLayout(boardLayout);

        for (int i = 0; i < BOARD_SIZE; i++) { //  creates the botton for each panel 
            for (int j = 0; j < BOARD_SIZE; j++) { //  creates the botton for each panel 
                chessFrame.add(BoardSpace[i][j] = new JButton("I AM: " + (i * BOARD_SIZE + j + 1)));
                BoardSpace[i][j].setPreferredSize(new Dimension(80, 80));
                if ((i + j) % 2 == 0) {
                    BoardSpace[i][j].setBackground(HOTPINK);
                } else {
                    BoardSpace[i][j].setBackground(BUBBLEGUM);
                }
                BoardSpace[i][j].addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        System.out.println("BUTTON PUSHED");
                    }
                });
            }//end inner for 
        }//end out for 
        chessFrame.pack();
        chessFrame.setVisible(true);
    }//end main 
}//end ChessBoard class
