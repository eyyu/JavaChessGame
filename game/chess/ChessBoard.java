/*
 * COMP 2526 -- ASSIGNEMNT 2 -- CHESS GAME 
 * Author: Eva Yu * 
 * BCIT -- A00942918 -- CST2B  * 

 */
package assignment2.game.chess;

import assignment2.game.BoardGamePiece;
import assignment2.grid.Grid;
import assignment2.grid.Square;
import assignment2.player.Player;
import java.io.Serializable;

/**
 * This is the chess board class that a chess game will have it carries a matrix
 * of square objects each sqaure will have either a null object or a board game
 * piece object
 *
 * this board also has a grid called from the grid class in order to more easily
 * facilitate retrieval fo the numeric position given a row and column value or
 * vice versa
 *
 *
 * @author Eva
 */
public class ChessBoard implements Serializable {

    static final private int BOARDSIZE = 8;
    private static final int PAWNSROW = 2;
    // pawns occur at the second row from either end of the board
    private static final int PAWN_INIT_ROW_DIFF = 5; // this is the difference between
    // the first row of pawns and the 
    // second row of pawn when the game is initialized
    Grid board = new Grid(BOARDSIZE); //sets a grid of 8 by 8;
    Square square[][] = new Square[BOARDSIZE][BOARDSIZE];

    /*
     * Note: the validityMatrix is yet to be used ( nor does it properly
     * fuction) in version one.
     *
     * the following is an obeject is a private class that hols a matirx for the
     * spaces a piece can move be used by the chess peice to generate the
     * correct places for validity. if the spot chosen is valid, for the piece
     * chosen, then the pieve will c all move and move to that position
     */
    ValidityMatrix validityMatrix;

    /**
     * This is onw long class initaition. it sets all the pieces of the board
     * and sets theColor of each piece the there are no players on the board.
     * the board is simply instantiated for the chess game class
     *
     */
    public ChessBoard() {
        this.initSquare();
        this.initBoard();

    } // end chessBoard constructor 1 

    /**
     * This method simply intiates an instance of a square for every sqaure on
     * the board it also sets the numeric cell position of each square starting
     * at 1 to 64
     */
    private void initSquare() {
        for (int row = 0; row < BOARDSIZE; row++) { // SET THEM PAWNS UP
            for (int col = 0; col < BOARDSIZE; col++) {
                square[row][col] = new Square();
                square[row][col].setPosition(row * BOARDSIZE + col + 1);
            }
        }
    }

    /**
     * this method initiates the board with the correct pieces and set Colors
     *
     */
    private void initBoard() {
        for (int row = 1; row < BOARDSIZE; row += PAWN_INIT_ROW_DIFF) { // SET THEM PAWNS UP
            for (int col = 0; col < BOARDSIZE; col++) {

                this.square[row][col].setPiece(new Pawn()); // new pawn for each sqaure in the
                // are these too many nested functions??!?  
                //but ... it makes life so much easier!! NO ,it is NOT ( says I )
                if (row < (BOARDSIZE / 2)) {
                    (this.square[row][col].getPiece()).setColor(true); // White set
                }

                if (row > (BOARDSIZE / 2)) {
                    (this.square[row][col].getPiece()).setColor(false); // Black set
                }
            }
        }

        // the following loop for all the pieces
        for (int row = 0; row < BOARDSIZE; row += (BOARDSIZE - 1)) {
            for (int col = 0; col < BOARDSIZE; col++) {
                int pos = square[row][col].getPosition();
                switch (pos) {
                    //Rook
                    case 1:
                    case 8:
                    case 57:
                    case 64:
                        this.square[row][col].setPiece(new Rook());
                        break;
                    //knight
                    case 2:
                    case 7:
                    case 58:
                    case 63:
                        this.square[row][col].setPiece(new Knight());
                        break;
                    //bishop
                    case 3:
                    case 6:
                    case 59:
                    case 62:
                        this.square[row][col].setPiece(new Bishop());
                        break;
                    case 5:
                    case 61: //KING
                        this.square[row][col].setPiece(new King());
                        break;
                    case 4:
                    case 60: //QUEEN
                        this.square[row][col].setPiece(new Queen());
                        break;
                }

                if (row < (BOARDSIZE / 2)) {
                    (this.square[row][col].getPiece()).setColor(true); // White set
                }

                if (row > (BOARDSIZE / 2)) {
                    (this.square[row][col].getPiece()).setColor(false); // Black set
                }
            }
        } // set the first and last rows 
    }

    /**
     * NOTE: this is not a working functio for version 1
     *
     * this methods SHOULD be generating a validity matrix that will represent
     * the tree of possible steps the piece chosen by the player to be moving
     *
     * @param p [this is a BOARDGAMEPIECE object that will be the piece passed
     * in]
     * @param pos [this is the numeric cell position of eahc piece on the board]
     */
    public void generateValidityMatrix(BoardGamePiece p, int pos) {
        this.validityMatrix = new ValidityMatrix(p, pos);
    }

    /**
     * NOTE: this is not a working function for version 1
     *
     * this method should pas in the new position of the baord the user decides
     * to move the piece to. id the piece cannot move to that location ,the
     * method should reutrn a false the method should check the validity matrix
     * to generate the right moves
     *
     * @param newPos [this is the int of athe numeric cell postion of  the new
     * position that the user wants to move the piece to ]
     * @param g [this is the grid that will faiclitate retrival of the x and y
     * values]
     * @return [a boolean value representing whether the user can move  the
     * piece to the desired location ]
     */
    public boolean checkMove(int newPos, Grid g) {
        //piece handling code
        //get the x and get the y 
        //use the x and y in the validitiy matix generated  
        return true;

    }

    /**
     * NOTE: this method is not a working function for version 1 NOTE: I have
     * not yet deicede whether this methods needs to be here is only really
     * calls the move method that each and every BOARDGAME PIECE CLASSS
     * overrides
     *
     * @param p [this is the BOARDGAMEPIECE object being moved]
     * @param newPos [the numeric cell position to move to]
     * @param curPos [the current position of the piece]
     * @return [the numeric cell position to move to if it is valid the current
     * position if not valid]
     */
    public int move(BoardGamePiece p, int newPos, int curPos) {
        return p.move(curPos, newPos, board);
    }

    /**
     * NOTE: none of thsi inner class is functioning for version 1 please stay
     * tuned for version 2!
     *
     *
     * this is an inner class that has is holds a 2d array that is like a "sudo
     * board" for the piece requesting the baord it will go to retrieve a 2d
     * array that holds only boolean values that will represent wehther or not a
     * peice can be moved to the specific numeric cell location the player
     * requests on the board.
     */
    class ValidityMatrix implements Serializable { // inner class for the boardgame

        boolean vM[][] = new boolean[BOARDSIZE][BOARDSIZE];

        private ValidityMatrix(BoardGamePiece piece, int curPos) {
            //get piece position
            for (int row = 0; row < BOARDSIZE; row++) {// first loop for rows
                for (int col = 0; col < BOARDSIZE; col++) { // second loop for columns 
                    int newPos = (row * BOARDSIZE) + col + 1;
                    System.out.println("checking position:" + newPos); /*
                     * tester
                     */

                    if (checkValidity(curPos, piece, newPos)) {
                        System.out.println("true on:" + newPos);
                        vM[row][col] = true;
                    } else {
                        System.out.println("false on:" + newPos);
                        vM[row][col] = false;
                    }
                }
            }
        }

        /**
         *
         * This method goes to check the validity a requested space on the baord
         * according the piece being checked. the current numeric cell value the
         * piece has and the numeric cell value that the player would like to
         * put the piece
         *
         * @param curPos [this is a numeric value of the cell the piece is
         * currently at]
         * @param piece [this is the piece that will be a specific class to be
         * able to determine wether a move is valid ]
         * @param newPos [this is the new position the piece would go into]
         * @return [the function returns true if the location of the requested
         * space is a valid place for the piece to move to]
         */
        public boolean checkValidity(int curPos, BoardGamePiece piece, int newPos) {
            //look for a piece in that square. if the piece is the same color, then you cannot 
            //move to that square... DUHHHHHH
            int move = piece.move(curPos, newPos, board); // asks the specific piece to 
            //move to check if it is a valid move right off the back
            int newX = board.getX(newPos);
            int newY = board.getY(newPos);

            Square tempNew = square[newX - 1][newY - 1]; // locating the sqaure for the selected location 
            Boolean newPosColor, curPosColor;
            System.out.println("checking with square: " + tempNew.getPosition());
            //the following portion of the code  will check the square to make sure 
            //that the peice on the square is not of the smae setColor 
            //to prevent a usr from kiling their own pieces 
            if (tempNew != null) {
                int curX = board.getX(curPos);
                int curY = board.getY(curPos);

                Square tempCur = square[curX - 1][curY - 1]; // assigns a temp to Square obect
                //newPosColor = (tempNew.getPiece()).getColor();
                //curPosColor = (tempCur.getPiece()).getColor();
                // if ((newPosColor && curPosColor) || (!newPosColor && !curPosColor)) {
                //     // checking the set color to see if they are form the same set
                //     return false;
                // }
            }
            if (move == curPos) { // a pieces move will return its on position if it 
                //cannot move to that positon  
                return false;
            }
            return true;
        }

        /**
         * This method is the method that gets the validity of the sqaure the
         * piece being moved is trying to go to its read the validity matrix and
         * double checks to makes sure that the location of the validity matrix
         * is a valid spot otherwise, the peice will not be able to move to the
         * new location
         *
         * @param newPos [the numeric cell position of the square the piece is
         * trying to move ]
         * @param g [the grid that holds a specific size of rows and columns ]
         * @return [the boolean value held at the position that has been
         * requested ]
         */
        public boolean getValidity(int newPos, Grid g) {
            int x = g.getX(newPos);
            int y = g.getY(newPos);
            return vM[x - 1][y - 1]; // returns the value 
            //found in the validity matrix 
            //for that position desired by the chess piece
        }

        public void print() { // tester to make sure it works.
            // it does not work 
            for (int row = 0; row < BOARDSIZE; row++) {
                for (int col = 0; col < BOARDSIZE; col++) {
                    int temp;
                    if (vM[row][col] == true) {
                        temp = 1;
                    } else {
                        temp = 0;
                    }
                    System.out.print(temp + " ");
                }
                System.out.println("");
            }
        }

    }

}//end ChessBoard class

/**
 * THis class represetns th Pawn piece on the chess board. this piece has a
 * setColor assigned to it and should not be changed once accessed the piece
 * also has a ENUM value assigned to it this class has only one method, move
 * that it ovverrides from the boardGamePiece class e This is a package that
 * repersents a pawn
 * @author Eva
 */
class Pawn implements BoardGamePiece, Serializable {

    Boolean setColor; // this sets the color of the piece according to the playe. 
    //black is represented by 0 and white represented by one
    Boolean firstmove = true; // allows the one time movment of two 
    //steps in the very first move of the pawn;
    public String pieceName = "PAWN";

    Player player;// player assigned to the piece

    /**
     * This method moves a pawn in chess and restricts it to only the moves a
     * pawn can make
     * @param x [the int representing the number of spaces going up or down (
     * signed)]
     * @param y [the int representing the number of spaces going left or right (
     * signed)]
     * @return [the int of the position of the square it needs to move to]
     */
    @Override
    public int move(int currentPos, int dest, Grid g) {

        //NOTE TO SELF for V2: 
        //need to get sqaure for makng a kill to see if there is a
        //piece in the square.
        int xCur, xDest, xDiff;
        int yCur, yDest, yDiff;

        xCur = g.getX(currentPos);
        yCur = g.getY(currentPos);
        xDest = g.getX(dest);
        yDest = g.getY(dest);
//
//        System.out.println("xCur:" + xCur);//tester
//        System.out.println("yCur:" + yCur);//tester
//        System.out.println("xDest:" + xDest);//tester
//        System.out.println("yDest:" + yDest);//tester

        if (setColor == true) { // if set is white
            xDiff = xDest - xCur;
            yDiff = yDest - yCur;
        } else { // if set is black
            xDiff = xCur - xDest;
            yDiff = yCur - yDest;
        }

//        System.out.println("xDiff:" + xDiff);//tester
//        System.out.println("yDiff:" + yDiff);//tester
        if (this.firstmove == true) {
            this.firstmove = false;
            if (xDiff == 2) {
                return dest;
            }
        }

        if (xDiff == 1 && yDiff == 0) {
            return dest;
        }
        //Note to self: 
        //for the kills..
        /*
         * if (yDiff == 1 && xDiff == 1){ g.getPiece(); return dest; //move pawn
         * to the upper } if (yDiff == 1 && xDiff == 1){ return dest; //move
         * pawn to the upper }
         */
        return currentPos;
    }

    /**
     * please refer to parent class for details of the method
     */
    @Override
    public void setColor(Boolean setColor) {
        this.setColor = setColor;
    }

    /**
     * please refer to parent class for details of the method
     */
    @Override
    public boolean getColor() {
        return this.setColor;
    }

    /**
     * please refer to parent class for details of the method
     * @return [description]
     */
    @Override
    public String getPieceName() {
        return this.pieceName;
    }

    /**
     * please refer to parent class for details of the method
     */
    @Override
    public Player getPlayer() {
        return this.player;
    }

    /**
     * please refer to parent class for details of the method
     */
    @Override
    public void setPlayer(Player p) {
    }
}

/**
 * THis class represetns the Rook piece on the chess board. this piece has a
 * setColor assigned to it and should not be changed once accessed the piece
 * also has a ENUM value assigned to it this class has only one method, move
 * that it ovverrides from the boardGamePiece class
 *
 * @author Eva
 */
class Rook implements BoardGamePiece, Serializable {

    public String pieceName = "ROOK";
    Boolean setColor; // this sets the color of the piece according to the playe. 
    Player player; // player assigned to the piece

    /**
     * This method moves a bishop in chess and retricts it to only the moves a
     * bishop can make
     */
    @Override
    public int move(int currentPos, int dest, Grid g) {
        int xCur, xDest, xDiff;
        int yCur, yDest, yDiff;

        xCur = g.getX(currentPos);
        yCur = g.getY(currentPos);
        xDest = g.getX(dest);
        yDest = g.getY(dest);

        yDiff = Math.abs(yDest - yCur);
        xDiff = Math.abs(xDest - xCur);

        if (yDiff == 0) { // Note to Self: do i need to specifiy xDiff?
            return dest;
        } else if (xDiff == 0) {
            return dest; // Note to Self: do i need to specifiy xDiff?
        }
        return currentPos;
    }

    /**
     * please refer to parent class for details of the method
     */
    @Override
    public void setColor(Boolean setColor) {
        this.setColor = setColor;
    }

    /**
     * please refer to parent class for details of the method
     */
    @Override
    public boolean getColor() {
        return this.setColor;
    }

    /**
     * please refer to parent class for details of the method
     */
    @Override
    public String getPieceName() {
        return this.pieceName;
    }

    /**
     * please refer to parent class for details of the method
     */
    @Override
    public Player getPlayer() {
        return this.player;
    }

    /**
     * please refer to parent class for details of the method
     */
    @Override
    public void setPlayer(Player p) {
    }
}

/**
 * THis class represetns the Knight piece on the chess board. this piece has a
 * setColor assigned to it and should not be changed once accessed the piece
 * also has a ENUM value assigned to it this class has only one method, move
 * that it ovverrides from the boardGamePiece class
 *
 * @author Eva
 */
class Knight implements BoardGamePiece, Serializable {

    public String pieceName = "KNIGHT";
    Boolean setColor; // this sets the color of the piece according to the playe. 
    Player player;// player assigned to the piece

    /**
     * This method moves a knight in chess and retricts it to only the moves a
     * knight can make
     */
    /**
     * This method moves a knight in chess and retricts it to only the moves a
     * knight can make
     */
    @Override
    public int move(int currentPos, int dest, Grid g) {
        int xCur, xDest, xDiff;
        int yCur, yDest, yDiff;
        int lStep;

        xCur = g.getX(currentPos);
        yCur = g.getY(currentPos);

        xDest = g.getX(dest);
        yDest = g.getY(dest);

        yDiff = Math.abs(yDest - yCur);
        xDiff = Math.abs(xDest - xCur);
//        System.out.println("xCur:" + xCur);//tester
//        System.out.println("yCur:" + yCur);//tester
//        System.out.println("xDest:" + xDest);//tester
//        System.out.println("yDest:" + yDest);//tester
//        System.out.println("xDiff:" + xDiff);//tester
//        System.out.println("yDiff:" + yDiff);//tester
        lStep = Math.abs(yDiff - xDiff);//this is the difference between a y and an x step. 
        //a night should move in one directiosn 3 steps and then turn and move 1
        //the final diffence should be 2 
//        System.out.println("lStep: " + lStep);//tester
        if (lStep == 1
            && (yDiff == 1 || xDiff == 1)
            && (yDiff == 2 || xDiff == 2)) {
            return dest;
        }
        return currentPos;

    }

    /**
     * please refer to parent class for details of the method
     */
    @Override
    public void setColor(Boolean setColor) {
        this.setColor = setColor;
    }

    /**
     * please refer to parent class for details of the method
     */
    @Override
    public boolean getColor() {
        return this.setColor;
    }

    /**
     * please refer to parent class for details of the method
     */
    @Override
    public String getPieceName() {
        return this.pieceName;
    }

    /**
     * please refer to parent class for details of the method
     */
    @Override
    public Player getPlayer() {
        return this.player;
    }

    /**
     * please refer to parent class for details of the method
     */
    @Override
    public void setPlayer(Player p) {
    }
}

/**
 * THis class represetns the Bishop piece on the chess board. this piece has a
 * setColor assigned to it and should not be changed once accessed the piece
 * also has a ENUM value assigned to it this class has only one method, move
 * that it ovverrides from the boardGamePiece class
 *
 * @author Eva
 */
class Bishop implements BoardGamePiece, Serializable {

    Boolean setColor; // this sets the color of the piece according to the playe. 
    public String pieceName = "BISHOP";
    Player player;// player assigned to the piece

    /**
     * This method moves a bishop in chess and retricts it to only the moves a
     * bishop can make
     */
    @Override
    public int move(int currentPos, int dest, Grid g) {
        int xCur, xDest, xDiff;
        int yCur, yDest, yDiff;

        xCur = g.getX(currentPos);
        yCur = g.getY(currentPos);
        xDest = g.getX(dest);
        yDest = g.getY(dest);

        yDiff = yDest - yCur;
        xDiff = xDest - xCur;

        if (xDiff == yDiff) {
            return dest;
        }
        return currentPos;

    }

    /**
     * please refer to parent class for details of the method
     */
    @Override
    public void setColor(Boolean setColor) {
        this.setColor = setColor;
    }

    /**
     * please refer to parent class for details of the method
     */
    @Override
    public boolean getColor() {
        return this.setColor;
    }

    /**
     * please refer to parent class for details of the method
     */
    @Override
    public String getPieceName() {
        return this.pieceName;
    }

    /**
     * please refer to parent class for details of the method
     */
    @Override
    public Player getPlayer() {
        return this.player;
    }

    /**
     * please refer to parent class for details of the method
     */
    @Override
    public void setPlayer(Player p) {
    }
}

/**
 * THis class represetns the King piece on the chess board. this piece has a
 * setColor assigned to it and should not be changed once accessed the piece
 * also has a ENUM value assigned to it this class has only one method, move
 * that it ovverrides from the boardGamePiece class
 *
 * @author Eva
 */
class King implements BoardGamePiece, Serializable {

    Boolean setColor; // this sets the color of the piece according to the playe. 
    public String pieceName = "KING";
    Player player;// player assigned to the piece

    /**
     * This method moves a king in chess and restricts it to only the moves a
     * king can make
     */
    @Override
    public int move(int currentPos, int dest, Grid g) {
        int xCur, xDest, xDiff;
        int yCur, yDest, yDiff;

        xCur = g.getX(currentPos);
        yCur = g.getY(currentPos);
        xDest = g.getX(dest);
        yDest = g.getY(dest);

        yDiff = yDest - yCur;
        xDiff = xDest - xCur;

        if ((yDiff == 1 && xDiff == 0)
            || (yDiff == 0 && xDiff == 1)
            || (yDiff == 1 && xDiff == 1)) {
            return dest;
        }
        return currentPos;
    }

    /**
     * please refer to parent class for details of the method
     */
    @Override
    public void setColor(Boolean setColor) {
        this.setColor = setColor;
    }

    /**
     * please refer to parent class for details of the method
     */
    @Override
    public boolean getColor() {
        return this.setColor;
    }

    /**
     * please refer to parent class for details of the method
     */
    @Override
    public String getPieceName() {
        return this.pieceName;
    }

    /**
     * please refer to parent class for details of the method
     */
    @Override
    public Player getPlayer() {
        return this.player;
    }

    /**
     * please refer to parent class for details of the method
     */
    @Override
    public void setPlayer(Player p) {
    }
}

/**
 * THis class represetns the Queen piece on the chess board. this piece has a
 * setColor assigned to it and should not be changed once accessed the piece
 * also has a ENUM value assigned to it this class has only one method, move
 * that it ovverrides from the boardGamePiece class
 *
 * @author Eva
 */
class Queen implements BoardGamePiece, Serializable {

    public String pieceName = "QUEEN";
    Boolean setColor; // this sets the color of the piece according to the playe. 
    Player player;// player assigned to the piece

    /**
     * This method moves a queen in chess and retricts it to only the moves a
     * queen can make
     */
    @Override
    public int move(int currentPos, int dest, Grid g) {
        int xCur, xDest, xDiff;
        int yCur, yDest, yDiff;

        xCur = g.getX(currentPos);
        yCur = g.getY(currentPos);
        xDest = g.getX(dest);
        yDest = g.getY(dest);

        yDiff = Math.abs(yDest - yCur);
        xDiff = Math.abs(xDest - xCur);

        if ((yDiff == xDiff) || // going at an angle
            (yDiff == 0) || // moving on the x axis
            (xDiff == 0)) { // moving on the y axis 
            return dest;
        }
        return currentPos;
    }

    /**
     * please refer to parent class for details of the method
     */
    @Override
    public void setColor(Boolean setColor) {
        this.setColor = setColor;
    }

    /**
     * please refer to parent class for details of the method
     */
    @Override
    public boolean getColor() {
        return this.setColor;
    }

    /**
     * please refer to parent class for details of the method
     */
    @Override
    public String getPieceName() {
        return this.pieceName;
    }

    /**
     * please refer to parent class for details of the method
     */
    @Override
    public Player getPlayer() {
        return this.player;
    }

    /**
     * please refer to parent class for details of the method
     */
    @Override
    public void setPlayer(Player p) {
    }
}
