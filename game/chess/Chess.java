/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment2.game.chess;
package assignment2.game.*;
/**
 *
 * @author Eva
 */
public class Chess extends GridBoardGame{
	static final int PIECES = 16; // 16 pieces 
	static final int PLAYERS = 2; // 2 players at a time
    static final int GRIDSIZE = 8; // 8*8 board

    Grid gameBoard;
    Boolean validityMatrix[][] = new Boolean[GRIDSIZE][GRIDSIZE];
    Square gameMatrix[][] = new Square[GRIDSIZE][GRIDSIZE];

	Player p1; // should be starting player
	Player p2; // should get second turn 

//notes : track every piece and 
//each piece has an availability grid 
// for piece pickes the piece needs its own calculation/ update of grid availability

    /*
     * Grid baord game constructor will create a new grid for the board @param
     * size [description]
     */

    public Chess(int size) {
        super.initBoard(size, size);
    }

    /**
     * Grid baord game constructor will create a new grid for the board if the
     * grid of the board is not
     *
     * @param x [the rows of the grid]
     * @param y [the columns of the grid]
     */
    public Chess(int x, int y) {
        super.initBoard(x, y);
    }

    @Override
    abstract public void start();

    @Override
    abstract public void end();

    @Override
    abstract public void win();

    @Override
    abstract public int getPlayers();

    @Override
    abstract public void initPlayers();

    @Override
    abstract public int getPiece();

    @Override
    abstract public void setPlayer();

    @Override
    abstract public void getPos();

    abstract void move();//Can enums inherit? Answer: No. like, obvi.

    //parent has:
    /*protected Grid initBoard(int gridL, int gridW) {
        return new Grid(gridL, gridW);
    }
    */
	
	public void checkAvailGrid(){

	}
    /**
     * This method should generate a 8*8 grid 
     *
     * @param p     [description]
     * @param s_src [description]
     */
    private void generateValidityMatrix(ChessPiece p, Square s_src){

    }
    //reminder to make a readMe.txt file for instruction on chess. 
    //just get somethign from wiki or something, no need to do it yourself 
    //because thats not the point of this assignment, you fool. 
    
    public void setInstructions();
    public void getInstructions();

}

static class Moves(){
	static boolean moveDiagonal(ChessPiece p, Square s_src, Square s_dest){

	}
	static boolean moveUp(ChessPiece p, Square s_src, Square s_dest){

	}
	static boolean moveDown(ChessPiece p, Square s_src, Square s_dest){

	}
	static boolean moveLeft(ChessPiece p, Square s_src, Square s_dest){

	}
	static boolean moveRight(ChessPiece p, Square s_src, Square s_dest){

	}
	static boolean knightMove(ChessPiece p, Square s_src, Square s_dest){ // NOTE: is there a special name for this move???

	}
	
}
