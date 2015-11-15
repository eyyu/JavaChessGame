/*
 * COMP 2526 -- ASSIGNEMNT 2 -- CHESS GAME 
 * Author: Eva Yu * 
 * BCIT -- A00942918 -- CST2B  * 

 */
package assignment2.game.chess;

import assignment2.game.BoardGamePiece;
import assignment2.grid.Grid;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * this is the main panel for the chess game. doing this will allow me to expand
 * and add other j panels into the game later if i want
 * @author Eva
 */
public class JChessPanel extends JPanel {
    /* the board size*/
    private static final int SIZE = 8; 
    /*the diameter of each Sqaure*/             
    private static final int SQAURE_DIM = 80;
    /* this int will represent the players piece being moved
    if the player has moved a piece, the flag will be reset to 0*/
    static int flag = 0;

    //FOR A MORE EXITING SPACE-IKEA THEME:*/
    final Color SUNSHINE = new Color(252, 198, 10);
    final Color BUBBLEGUM = new Color(35, 210, 254);
    final Color COTTONCANDY = new Color(255, 102, 181);

    //The Current board colors:*//
    final Color DARK_BROWN = new Color(184, 174, 156);
    final Color LIGHT_BROWN = new Color(234, 231, 225);
    final Color SEAFOAM = new Color(172, 207, 204);

    private GridLayout boardLayout; // the grid of the Jpanel
    private JLabel chessLabel; // for version 2
    private Chess chess; // chesss game for chesspanel
    private Grid boardGrid = new Grid(SIZE, SIZE); // the grid 
    JButton jButSquare[][] = new JButton[SIZE][SIZE];//a jbuytton for each square
        /**
         * this is the constructor that will set the pieces on the grid panel
         */
    public JChessPanel() {
        super(new GridLayout(SIZE, SIZE)); // inputs grid layout
        chess = new Chess();//sets new chessgame up
        setPreferredSize(new Dimension(SIZE * SQAURE_DIM, SIZE * SQAURE_DIM)); 
                                                // sets the size of the jpanel

        for (int i = 0; i < SIZE; i++) { //  creates the botton for each panel 
            for (int j = 0; j < SIZE; j++) { //  creates the botton for each panel 
                BoardGamePiece temp = chess.chessBoard.square[i][j].getPiece();
                if (temp != null) { // if there is a piece in the square
                    String tempName = temp.getPieceName();
                    add(jButSquare[i][j] = new JButton(tempName));
                    if (temp.getColor()) {
                        jButSquare[i][j].setForeground(Color.BLACK);
                    } else {
                        jButSquare[i][j].setForeground(Color.WHITE);
                    }
                } else {
                    add(jButSquare[i][j] = new JButton(""));
                }

                jButSquare[i][j].setPreferredSize(new Dimension(SQAURE_DIM, SQAURE_DIM)); 
                jButSquare[i][j].addActionListener(new ChessSquareButtonListener(i * SIZE + j + 1));

                // setting board background color
                if ((i + j) % 2 == 0) {
                    jButSquare[i][j].setBackground(DARK_BROWN); 
                } else {
                    jButSquare[i][j].setBackground(LIGHT_BROWN);
                }
            }

        }
    }

    private class ChessSquareButtonListener implements ActionListener {

        private int squarePosition; // position of the Jbutton
        private int x; // the row of position
        private int y; // the column of position

        BoardGamePiece piece; // the board game piece at the cell
            /**
             * constructor of listener will set the positon of the sqaure
             * @param  pos [description]
             * @return     [description]
             */
        public ChessSquareButtonListener(int pos) {
            this.squarePosition = pos;
        }
            /**
             * the action performed method 
             * @param e [the clicking of the button activates the action performed ]
             */
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("BUTTON PUSHED at button :" + squarePosition);

            x = boardGrid.getX(squarePosition); // get row
            y = boardGrid.getY(squarePosition);//get col

            piece = chess.chessBoard.square[x - 1][y - 1].getPiece(); // gets the piece

            System.out.println("BUTTON PUSHED row:" + x); //*tester  
            System.out.println("BUTTON PUSHED col:" + y); //*tester 

            if (piece != null) {
                System.out.println(piece.getPieceName());//tester
            }

            if (flag != 0) {//if there is a flag
                // this looks for the x and y position of the flag
                int flagX, flagY;
                flagX = boardGrid.getX(flag);
                flagY = boardGrid.getY(flag);
                
                //this is retrieving the piece that needs to be moved 
                BoardGamePiece moveP = chess.chessBoard.square[flagX - 1][flagY - 1].getPiece();

                //swaping positions    
                chess.chessBoard.square[x - 1][y - 1].setPiece(moveP);
                chess.chessBoard.square[flagX - 1][flagY - 1].resetSquare();
                piece = chess.chessBoard.square[x - 1][y - 1].getPiece();
                
                //setting the text of the jbutton
                String tempName = piece.getPieceName();
                jButSquare[x - 1][y - 1].setText(tempName);
                //setting the color of text
                if (piece.getColor()) {
                    jButSquare[x - 1][y - 1].setForeground(Color.BLACK);
                } else {
                    jButSquare[x - 1][y - 1].setForeground(Color.WHITE);
                }
                jButSquare[flagX - 1][flagY - 1].setText("");
                
                //resetting the color of the board after piece is moved
                if ((flagX - 1 + flagY - 1) % 2 == 0) {
                    jButSquare[flagX - 1][flagY - 1].setBackground(DARK_BROWN);

                } else {
                    jButSquare[flagX - 1][flagY - 1].setBackground(LIGHT_BROWN);
                }
                flag = 0;
            } else if (flag == 0 && (piece != null)) { // if there is no piece to be moved 
                                                       //and the square holds a piece
                jButSquare[x - 1][y - 1].setBackground(SEAFOAM);
                flag = squarePosition;
            }

        }
    }

}
