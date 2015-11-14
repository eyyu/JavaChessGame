/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment2.game.chess;

import assignment2.game.BoardGamePiece;
import assignment2.grid.Grid;
import assignment2.grid.Square;
import assignment2.player.Player;

/**
 *
 * @author Eva
 */
public class Chess {

    static final int PIECES = 32; // 16 pieces 
    static final int PLAYERS = 2; // 2 players at a time
    static final int GRIDSIZE = 8; // 8*8 board

    ChessBoard chessBoard;
    Player p1; // should be starting player
    Player p2; // should get second turn 
    private int p1count; // number of pieces that the player has
    private int p2count; // number of peices that the player has 
    private BoardGamePiece p1pieces[] = new BoardGamePiece[PIECES / 2];
    private BoardGamePiece p2pieces[] = new BoardGamePiece[PIECES / 2];
    Boolean p1setColor; // true== white
    Boolean p2setColor; // false == black;

//notes : track every piece and 
//each piece has an availability grid 
// for piece pickes the piece needs its own calculation/ update of grid availability

    /*
     * Grid baord game constructor will create a new grid for the board @param
     * size [description]
     */
    public Chess() {
        this.initPlayers();
        this.chessBoard = new ChessBoard();
    }

    private void initPlayers() {
        this.p1 = new Player();
        this.p2 = new Player();
        this.p2.setSetColor(false); // auto set player 2 to black set setColor
        this.p2.restrictTurn();
    }

    public Player getPlayer(int player) { // the function will allow one to set the ame of the player and the status of the player
        if (player == 1) {
            return p1;
        }
        return p2;
    }

    // this method should set the side of the players.
    /*
     * @Override abstract public void start() { System.out.println("Congrats!
     * You Won!"); }
     *
     * @Override abstract public void end() { System.out.println("Congrats! You
     * Won!"); } // write the win function here
     *
     * @Override abstract public void win() { System.out.println("Congrats! You
     * Won!"); } // write the win function and assign winner
     */
    /**
     * This method will return the number of players there are in the game.
     * @return []
     *
     * @Override public int getPlayers() { return this.PLAYERS; }
     *
     * @Override abstract public int getPiece(){
     *
     * }
     *
     * @Override abstract public void setPlayer(){
     *
     * }
     *
     * @Override abstract public void getPos(){
     *
     * }
     *
     * abstract void move(){
     *
     * }
     */
    //reminder to make a readMe.txt file for instruction on chess. 
    //just get somethign from wiki or something, no need to do it yourself 
    //because thats not the point of this assignment, you fool. 
    public void setInstructions() {
        System.out.println("Set Instructions");
    }

    public void getInstructions() {
        System.out.println("Set Instructions");
    }
}
