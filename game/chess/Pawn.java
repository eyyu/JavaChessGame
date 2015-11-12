/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment2.game.chess;
import assignment2.game.BoardGamePiece;
/**
 *
 * @author Eva
 */
class Pawn implements BoardGamePiece  {
	Boolean setColor; // this sets the color of the piece according to the playe. 
					//black is represented by 0 and white represented by one
	Boolean firstmove = true; // allows the one time movment of two steps in the very first move of the pawn;
    ChessPiece PAWN;

    /**
     * This method moves a pawn in chess and restricts it to only the moves a
     * pawn can make
     * @param  x [the int representing the number of spaces going up or down ( signed)]
     * @param  y [the int representing the number of spaces going left or right ( signed)]
     * @return   [the int of the position of the square it needs to move to]
     */
    public static int move(int x, int y) {
    	if(y == 2 && this.firstmove){
    		//move up two spaces
    		this.firstmove = false;
    	} 
    	if (y == 1 && x == 0){
    		//move pawn to the upper
    	}
    }

}
