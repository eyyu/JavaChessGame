/*
 * COMP 2526 -- ASSIGNEMNT 2 -- CHESS GAME 
 * Author: Eva Yu 
 * BCIT -- A00942918 -- CST2B 
 */
package assignment2.game;

import assignment2.player.Player;

/**
 *
 * @author Eva
 */
abstract class BoardGame implements Game {

    int numOfPlayer;
    int pieces;
    BoardGameLayout layout;
    boolean setColor = true;
    boolean setColor = true;

    @Override
    abstract public void start();

    @Override
    abstract public void end();

    @Override
    abstract public void win();

    @Override
    abstract public int getPlayers();

    abstract public void initPlayers();

    abstract public int getPiece();

    abstract public void setPlayer();

    abstract public void getPos();

    public void setType(BoardGameLayout l) {
        layout = l;
    }

}
