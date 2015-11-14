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

    // somehow implement   piece so each square has a piece ?
    BoardGamePiece gamePiece; // holds the object that is a pice for the game
    //NOTE TO SELF: 
    //... i dont like this, its doesnt seem super object oriented because this square class should really be called boardgamesqaure 
    //-.-" ewwwww Eva, ewww 
    //are the follwong necessary fr the game? 

    protected int position; // when it is on a grid 
    //going from left to right, 
    //top to bottom 
    //startin at 1;

    public Square() {
        gamePiece = null;
    }

    public void setPosition(int pos) {
        this.position = pos; // retrieves the position of the square
    }

    //this one is necessary for the pieces. most-def keep it 
    /**
     * [getPosition description]
     * @return [description]
     */
    public int getPosition() {
        return this.position;
    }

    public void setPiece(BoardGamePiece piece) {
        this.gamePiece = piece; // there will probably be an issue with this... oh geezes do i use the new operator ? 
    }

    public BoardGamePiece getPiece() {
        return this.gamePiece;// you need to check to make sure this works!!! 
    }

    public void resetSquare() {
        gamePiece = null;
    }

}
