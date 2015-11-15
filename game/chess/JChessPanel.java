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

    private static final int SIZE = 8;
    private static final int SQAURE_DIM = 80;
    static int flag = 0;
    //FOR A MORE EXITING SPACE-IKEA THEME:*/
    final Color SUNSHINE = new Color(252, 198, 10);
    final Color BUBBLEGUM = new Color(35, 210, 254);
    final Color COTTONCANDY = new Color(255, 102, 181);

    //The Current board colors:*//
    final Color DARK_BROWN = new Color(184, 174, 156);
    final Color LIGHT_BROWN = new Color(234, 231, 225);
    final Color SEAFOAM = new Color(172, 207, 204);

    private GridLayout boardLayout;
    private JLabel chessLabel;
    private Chess chess;
    private Grid boardGrid = new Grid(SIZE, SIZE);
    JButton jButSquare[][] = new JButton[SIZE][SIZE];

    public JChessPanel() {
        super(new GridLayout(SIZE, SIZE));
        chess = new Chess();
        setPreferredSize(new Dimension(SIZE * SQAURE_DIM, SIZE * SQAURE_DIM));

        for (int i = 0; i < SIZE; i++) { //  creates the botton for each panel 
            for (int j = 0; j < SIZE; j++) { //  creates the botton for each panel 
                BoardGamePiece temp = chess.chessBoard.square[i][j].getPiece();
                if (temp != null) {
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
                if ((i + j) % 2 == 0) {
                    jButSquare[i][j].setBackground(DARK_BROWN);

                } else {
                    jButSquare[i][j].setBackground(LIGHT_BROWN);
                }
            }

        }
    }

    private class ChessSquareButtonListener implements ActionListener {

        private int squarePosition;
        private int x;
        private int y;

        BoardGamePiece piece;

        public ChessSquareButtonListener(int pos) {
            this.squarePosition = pos;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("BUTTON PUSHED at button :" + squarePosition);

            x = boardGrid.getX(squarePosition);
            y = boardGrid.getY(squarePosition);

            piece = chess.chessBoard.square[x - 1][y - 1].getPiece();
            System.out.println("BUTTON PUSHED row:" + x); //*tester  
            System.out.println("BUTTON PUSHED col:" + y); //*tester 

            if (piece != null) {
                System.out.println(piece.getPieceName());//tester
            }

            if (flag != 0) {
                int flagX, flagY;
                flagX = boardGrid.getX(flag);
                flagY = boardGrid.getY(flag);

                BoardGamePiece moveP = chess.chessBoard.square[flagX - 1][flagY - 1].getPiece();

                chess.chessBoard.square[x - 1][y - 1].setPiece(moveP);
                chess.chessBoard.square[flagX - 1][flagY - 1].resetSquare();
                piece = chess.chessBoard.square[x - 1][y - 1].getPiece();
                String tempName = piece.getPieceName();
                jButSquare[x - 1][y - 1].setText(tempName);
                if (piece.getColor()) {
                    jButSquare[x - 1][y - 1].setForeground(Color.BLACK);
                } else {
                    jButSquare[x - 1][y - 1].setForeground(Color.WHITE);
                }
                jButSquare[flagX - 1][flagY - 1].setText("");
                if ((flagX - 1 + flagY - 1) % 2 == 0) {
                    jButSquare[flagX - 1][flagY - 1].setBackground(DARK_BROWN);

                } else {
                    jButSquare[flagX - 1][flagY - 1].setBackground(LIGHT_BROWN);
                }
                flag = 0;
            } else if (flag == 0 && (piece != null)) {
                jButSquare[x - 1][y - 1].setBackground(SEAFOAM);
                flag = squarePosition;
            }

        }
    }

}
