/*
 * COMP 2526 -- ASSIGNEMNT 2 -- CHESS GAME 
 * Author: Eva Yu 
 * BCIT -- A00942918 -- CST2B 
 */
package assignment2.game;

import assignment2.grid.Grid;

/**
 *
 * @author Eva
 */
abstract class GridBoardGame extends BoardGame {

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
    
    @Override
    abstract void move();//Can enums inherit? Answer: No. 
    
    @Override
    abstract void setInstructions();
    
    @Override
    abstract void getInstructions();
    
    @Override
    protected Grid initBoard(int gridL, int gridW) {
        return new Grid(gridL, gridW);
    }
}
