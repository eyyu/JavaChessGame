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
 *
 * @author Eva
 */
public class ChessFrame extends JFrame {

    public static final int SIZE = 8;

    public static void main(String args[]) {
        JFrame chessFrame;

        JFrame.setDefaultLookAndFeelDecorated(true);
        chessFrame = new JFrame("Space IKEA Chess Game");
        chessFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        chessFrame.getContentPane().add(new JChessPanel());
        chessFrame.pack();
        chessFrame.setVisible(true);
    }
}
