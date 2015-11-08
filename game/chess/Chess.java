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
	int piece = 16;
	int players = 2;
	Player p1;
	Player p2;
//notes : track every piece and 
//each piece has an availability grid 
// for piece pickes the piece needs its own calculation/ update of grid availability
// 	

    BoardGameLayout GRID;
    int players;
    Grid board;
    int pieces;
    /*
     * Grid baord game constructor will create a new grid for the board @param
     * size [description]
     */

    public GridBoardGame(int size) {
        this.initBoard(size, size);
    }

    /**
     * Grid baord game constructor will create a new grid for the board if the
     * grid of the board is not
     *
     * @param x [the rows of the grid]
     * @param y [the columns of the grid]
     */
    public GridBoardGame(int x, int y) {
        this.initBoard(x, y);
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
