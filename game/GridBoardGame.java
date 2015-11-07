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

    int players;
    Grid board;
    int pieces;

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

    abstract void move();//Can enums inherit? 

    void initBoard(int gridL, int gridW) {
        board = new Grid(gridL, gridW);
    }
}
