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
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * this is the main panel for the chess game. doing this will allow me to expand
 * and add other j panels into the game later if i want
 * @author Eva
 */
public class JChessPanel extends JPanel {
    /*
     * the board size
     */

    private static final int SIZE = 8;
    /*
     * the diameter of each Sqaure
     */
    private static final int SQAURE_DIM = 80;
    /*
     * this int will represent the players piece being moved if the player has
     * moved a piece, the flag will be reset to 0
     */
    static int flag = 0;
    //FOR A MORE EXITING SPACE-IKEA THEME:*/
    final Color[] SPACEIKEATHEME
        = {new Color(252, 198, 10), // sunshine
            new Color(35, 210, 254), //bubblegum
            new Color(255, 102, 181)}; //cottoncanday

    final Color[] BLAHTHEME
        = {new Color(100, 100, 100), //darkgray
            new Color(150, 150, 150),//lightgray
            new Color(172, 207, 204)};//seafoam

//    //The Current board colors:*//
//    final Color DARK_BROWN = new Color(184, 174, 156);
//    final Color LIGHT_BROWN = new Color(234, 231, 225);
//    final Color SEAFOAM = new Color(172, 207, 204);
    private GridLayout boardLayout; // the grid of the Jpanel
    private JLabel chessLabel; // for version 2
    private Chess chess; // chesss game for chesspanel
    private Grid boardGrid = new Grid(SIZE, SIZE); // the grid 
    JButton jButSquare[][] = new JButton[SIZE][SIZE];//a jbuytton for each square
    private boolean spaceIkeaSet;
    private int player = 1;

    /**
     * this is the constructor that will set the pieces on the grid panel
     */
    public JChessPanel() {
        super(new GridLayout(SIZE, SIZE)); // inputs grid layout
        chess = new Chess();//sets new chessgame up
        setPreferredSize(new Dimension(SIZE * SQAURE_DIM, SIZE * SQAURE_DIM));
        // sets the size of the jpanel
        spaceIkeaSet = false;
        this.displayChessBoard();
    }

    private void displayChessBoard() {
        for (int i = 0; i < SIZE; i++) { //  creates the botton for each panel 
            for (int j = 0; j < SIZE; j++) { //  creates the botton for each panel 
                BoardGamePiece temp = chess.chessBoard.square[i][j].getPiece();
                if (temp != null) { // if there is a piece in the square
                    String tempName = temp.getPieceName();
                    add(jButSquare[i][j] = new JButton(tempName));
                    if (temp.getColor()) {
                        jButSquare[i][j].setForeground(Color.BLACK); // top - black set
                    } else {
                        jButSquare[i][j].setForeground(Color.WHITE); // bottom - white set
                    }
                } else {
                    add(jButSquare[i][j] = new JButton(""));
                }

                jButSquare[i][j].setPreferredSize(new Dimension(SQAURE_DIM, SQAURE_DIM));
                jButSquare[i][j].addActionListener(new ChessSquareButtonListener(i * SIZE + j + 1));

                // setting board background color
                if ((i + j) % 2 == 0) {
                    jButSquare[i][j].setBackground(BLAHTHEME[0]);
                } else {
                    jButSquare[i][j].setBackground(BLAHTHEME[1]);
                }
            }

        }
    }

    private void resetChessBoard() {
        Color color1 = spaceIkeaSet ? SPACEIKEATHEME[0] : BLAHTHEME[0];
        Color color2 = spaceIkeaSet ? SPACEIKEATHEME[1] : BLAHTHEME[1];
        JChessPanel.flag = 0;
        for (int i = 0; i < SIZE; i++) { //  creates the botton for each panel 
            for (int j = 0; j < SIZE; j++) { //  creates the botton for each panel 
                BoardGamePiece temp = chess.chessBoard.square[i][j].getPiece();
                if (temp != null) { // if there is a piece in the square
                    String tempName = temp.getPieceName();
                    jButSquare[i][j].setText(tempName);
                    if (temp.getColor()) {
                        jButSquare[i][j].setForeground(Color.BLACK);
                    } else {
                        jButSquare[i][j].setForeground(Color.WHITE);
                    }
                } else {
                    jButSquare[i][j].setText("");
                }
                // setting board background color
                if ((i + j) % 2 == 0) {
                    jButSquare[i][j].setBackground(color1);
                } else {
                    jButSquare[i][j].setBackground(color2);
                }
            }
        }

    }

    private class ChessSquareButtonListener implements ActionListener {

        private final int squarePosition; // position of the Jbutton
        private int x; // the row of position
        private int y; // the column of position
        private int flagX;
        private int flagY;
        private boolean pTurn;

        BoardGamePiece piece; // the board game piece at the cell

        /**
         * constructor of listener will set the position of the square
         * @param pos [description]
         * @return [description]
         */
        public ChessSquareButtonListener(int pos) {
            this.squarePosition = pos;
        }

        private void getPieceCoord() {
            x = boardGrid.getX(squarePosition); // get row
            y = boardGrid.getY(squarePosition);//get col
            piece = chess.chessBoard.square[x - 1][y - 1].getPiece(); // gets the piece
        }

        private void getFlagCoord() {
            this.flagX = boardGrid.getX(flag);
            this.flagY = boardGrid.getY(flag);
        }

        private BoardGamePiece getPieceToMove() {
            return chess.chessBoard.square[flagX - 1][flagY - 1].getPiece();
        }

        private void resetSquareColors() {
            Color color1 = spaceIkeaSet ? SPACEIKEATHEME[0] : BLAHTHEME[0];
            Color color2 = spaceIkeaSet ? SPACEIKEATHEME[1] : BLAHTHEME[1];
            if ((flagX - 1 + flagY - 1) % 2 == 0) {
                jButSquare[flagX - 1][flagY - 1].setBackground(color1);
            } else {
                jButSquare[flagX - 1][flagY - 1].setBackground(color2);
            }
        }

        private void resetText() {
            String tempName = piece.getPieceName();
            jButSquare[x - 1][y - 1].setText(tempName);
            //setting the color of text
            if (piece.getColor()) {
                jButSquare[x - 1][y - 1].setForeground(Color.BLACK);
            } else {
                jButSquare[x - 1][y - 1].setForeground(Color.WHITE);
            }
            jButSquare[flagX - 1][flagY - 1].setText("");
        }

        /**
         * the action performed method
         * @param e [the clicking of the button activates the action performed ]
         */
        @Override

        public void actionPerformed(ActionEvent e) {
            System.out.println("BUTTON PUSHED at button :" + squarePosition);//testyer

            this.getPieceCoord();
            if (piece != null) {
                chess.chessBoard.generateValidityMatrix(piece, squarePosition);
                chess.chessBoard.validityMatrix.print();
                System.out.println(piece.getPieceName());//tester
            }
            if (flag != 0) {//if there is a flag
                // this looks for the x and y position of the flag
                this.getFlagCoord();

                if (this.squarePosition == flag) { // allows you to deselect
                    flag = 0;
                    this.resetSquareColors();
                    return;
                }

                //this is retrieving the piece that needs to be moved 
                BoardGamePiece moveP = getPieceToMove();
                if (moveP.getColor()) {
                    System.out.println("player 1 set color: "
                        + (chess.getPlayer(1).getSetColor() ? " true " : "false"));// tester
                } else if (!moveP.getColor()) {
                    System.out.println("player 2 set color: "
                        + (chess.getPlayer(2).getSetColor() ? " true " : "false"));// tester
                }

                //swaping positions
                if (chess.chessBoard.validityMatrix.checkValidity(flag, moveP, squarePosition)) {
                    chess.chessBoard.square[x - 1][y - 1].setPiece(moveP);
                    chess.chessBoard.square[flagX - 1][flagY - 1].resetSquare();
                    piece = chess.chessBoard.square[x - 1][y - 1].getPiece();
                    //setting the text of the buttons
                    this.resetText();
                    //resetting the color of the board after piece is moved
                    this.resetSquareColors();
                    player = (player == 1) ? 2 : 1;
                    flag = 0;
                }
            } else if (flag == 0 && (piece != null)) { // if there is no piece to be moved 
                //and the square holds a piece
                if (chess.getPlayer(player).getSetColor() == piece.getColor()) {
                    jButSquare[x - 1][y - 1].
                        setBackground(spaceIkeaSet ? SPACEIKEATHEME[2] : BLAHTHEME[2]);
                    flag = squarePosition;
                }
            }

        }
    }

    class JSave extends JPanel {

        private static final int ROW = 3;
        private static final int COL = 1;

        JButton saveButton;
        JButton loadButton;
        JButton resetButton;

        public JSave() {

            super(new GridLayout(ROW, COL));
//        setPreferredSize(new Dimension(8 * 80, 40));
            add(saveButton = new JButton("Save Game"));
            add(loadButton = new JButton("Load Game"));
            add(resetButton = new JButton("Reset Game"));
            saveButton.addActionListener(new serializeButtonListener());
            loadButton.addActionListener(new serializeButtonListener());
            resetButton.addActionListener(new serializeButtonListener());
        }

        private class serializeButtonListener implements ActionListener {

            @Override
            public void actionPerformed(ActionEvent e) {
                String file = "./testSave.ser";
                if (e.getSource() == saveButton) {
                    // System.out.println("Save Button Pushed"); // tester
                    try {
                        FileOutputStream fos = new FileOutputStream(file);
                        ObjectOutputStream oos = new ObjectOutputStream(fos);
                        oos.writeObject(chess);
                        oos.flush();
                        oos.close();
                        fos.close();
                        System.out.println("Chess Game saved in '" + file + "'");//tester
                    } catch (IOException ex) {
                        System.err.println("A problem encountered while"
                            + " attempting to save game");
                    }
                } else if (e.getSource() == loadButton) {
                    //System.out.println("Load Button Pushed");
                    try {
                        FileInputStream fis = new FileInputStream(file);
                        ObjectInputStream ois = new ObjectInputStream(fis);
                        chess = (Chess) ois.readObject();
                        ois.close();
                        fis.close();
                        resetChessBoard();
                        System.out.println("Chess Game loaded from '" + file + "'");//tester
                    } catch (IOException ex) {
                        System.out.println("Trouble reading saved game");
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(JChessPanel.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else if (e.getSource() == resetButton) {
                    //System.out.println("Reset Button Pushed");
                    chess = new Chess();
                    resetChessBoard();
                }
            }
        }
    }

    class ExtraFeatures extends JPanel {

        JButton colorThemeButton;
        String theme[] = {"Space Ikea Mode", "Normal Mode"};

        public ExtraFeatures() {
            add(colorThemeButton = new JButton(theme[0]));
            colorThemeButton.addActionListener(new exFeaturesButtonListener());
        }

        private class exFeaturesButtonListener implements ActionListener {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (spaceIkeaSet == false) {
                    colorThemeButton.setText(theme[1]);
                    spaceIkeaSet = true;
                } else {
                    colorThemeButton.setText(theme[0]);
                    spaceIkeaSet = false;
                }
                resetChessBoard();
            }

        }
    }
}
