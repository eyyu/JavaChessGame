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
 * This class will contain all the compnents of the chess game including the
 * players the pieces and the board
 *
 * NOTE NOV. 15. 2015:
 * @version: 1 only initiates the board so far , players do not take turns so
 * far
 *
 * it will also keep data the chess class will also keep track of the players
 * turns, the number of kills a player has made
 * @author Eva
 */
public class Chess implements Serializable {

    static final int PIECES = 32; // 16 pieces 
    static final int PLAYERS = 2; // 2 players at a time
    static final int GRIDSIZE = 8; // 8*8 board

    ChessBoard chessBoard;// this is the board that will contain 
    //all the sqaure, each with a piece or set to null
    private Player p1; // should be starting player
    private Player p2; // should get second turn 
    private int p1count; // number of pieces that the player has
    private int p2count; // number of peices that the player has 
    private BoardGamePiece p1pieces[] = new BoardGamePiece[PIECES / 2];
    private BoardGamePiece p2pieces[] = new BoardGamePiece[PIECES / 2];

    /*
     * Grid baord game constructor will create a new grid for the board @param
     */
    public Chess() {
        this.initPlayers();
        this.chessBoard = new ChessBoard();
    }

    /**
     * This method intializes the players for the chess class it will restrict
     * player 2's turn in order for whoever player one is to start first
     *
     */
    private void initPlayers() {
        this.p1 = new Player();
        this.p2 = new Player();
        this.p1.setSetColor(false); // auto set player 2 to black set setColor
        this.p2.restrictTurn();
    }

    /**
     * this method returns the player in order to use the player classes methods
     * on the player you can set the winner using thsi class
     * @param player [this is an interger representing the player you want to
     * retrieve. By default player 1 has the white set and player 2 has the
     * black set of the chess peices ]
     * @return [returns the player requested. only one of two players will be
     * returned]
     *
     * Note to self: i should write a try catch method in order to catch an
     * excpetions that is not player one or two
     */
    public Player getPlayer(int player) { // the function will allow one to set 
        //the name of the player and the 
        //status of the player
        if (player == 1) {
            return p1;
        } else if (player == 2) {
            return p2;
        } else {
            return null;
        }
    }

    /**
     * This method should be inherited from the parent class, game. however, in
     * version one, game is not yet inherited in chess class
     *
     * this method will set the instructions of the game. currently, in version
     * one, it will only print to stderr suggesting that this method has nto
     * been properly defined
     *
     */
    public void setInstructions() {
        System.err.println("Class has not been initilaized. No Instructions to set.");
    }

    /**
     * This method should return the how-to-play instructions of the game. like
     * setInstructions method, this program should actually be inherited from
     * the parent class. due to time constraints, version one does not inherit
     * from its supposed parent/superclass, game game is in the redundant
     * folders file
     *
     */
    public void getInstructions() {
        this.setInstructions();
        System.err.println("Refer to Wiki for Instructions");
    }
}
