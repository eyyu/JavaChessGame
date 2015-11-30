/*
 * COMP 2526 -- ASSIGNEMNT 2 -- CHESS GAME 
 * Author: Eva Yu * 
 * BCIT -- A00942918 -- CST2B  * 

 */
package assignment2.game.chess;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * this is the main class for the chess game gui it holds a frame for the jPanel
 * chess game
 * @author Eva
 */
public class ChessFrame extends JFrame {

    public static final int SIZE = 8;

    public static void main(String args[]) {
        JFrame chessFrame;
        JChessPanel chessPanel = new JChessPanel();
        JPanel chessGamePanel = new JPanel(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 0;
        chessGamePanel.add(chessPanel.new JSave(), c);
        c.gridx = 1;
        c.gridy = 0;
        chessGamePanel.add(chessPanel, c);
        c.gridx = 1;
        c.gridy = 1;
        chessGamePanel.add(chessPanel.new ExtraFeatures(), c);
        JFrame.setDefaultLookAndFeelDecorated(true);
        chessFrame = new JFrame("Chess Game Version 2.0");
        chessFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        chessFrame.getContentPane().add(chessGamePanel);
        chessFrame.pack();
        chessFrame.setVisible(true);
    }
}
