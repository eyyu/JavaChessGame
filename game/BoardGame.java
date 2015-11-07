/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
