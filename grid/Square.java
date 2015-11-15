/*
 NOTE: this is the second version of sqaures more tailored to the board game  to  

 NOTE TO SELF: Still need to fix the boundaries of the left, right upper, lower in a grid!!! 
 */
package assignment2.grid;

import assignment2.game.BoardGamePiece;

/**
 * This is the square class. It is here
 * @author Eva
 */
public class Square {

    BoardGamePiece gamePiece; // holds the object that is a pice for the game
    //NOTE TO SELF: 
    //... i dont like this, its doesnt seem super object oriented because this square class should really be called boardgamesqaure 
    //-.-" ewwwww Eva, ewww 

    protected int position;  // the numeric cell positon of sqaure on grid
    /**
     * This is the constructor of the Square class
     * by calling the sqaure object, there is automatically a 
     * null set to the board game piece object in the square
     * 
     */
    public Square() {
        gamePiece = null;
    }

    /**
     * this sets the numeric cell position of the sqaure if it is on a grid 
     * @param pos [description]
     */
    public void setPosition(int pos) {
        this.position = pos; // retrieves the position of the square
    }

    /**
     * [this method returns the postiion of the square in the graph]
     * @return [the in representing the numeric cell position]
     */
    public int getPosition() {
        return this.position;
    }
        /**
         * this is the method that sets the piece in the square
         * this is used to reposition and move the pieces around
         * 
         * @param piece [this is the boardgamepiece that will be moved to the square]
         */
    public void setPiece(BoardGamePiece piece) {
        this.gamePiece = piece; // there will probably be an issue with this... oh geezes do i use the new operator ? 
    }
    /**
     * this method retrieves the piece ( or a null) from the requested square
     * @return [the board game piece at a given sqaure or a null pointer]
     */
    public BoardGamePiece getPiece() {
        return this.gamePiece;// you need to check to make sure this works!!! 
    }
    /**
     * this method sets the sqaure's object back to a null
     * this methods is used to reposition and move peice around
     */
    public void resetSquare() {
        gamePiece = null;
    }

}
