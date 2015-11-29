package assignment2.player;

import java.io.Serializable;

/**
 * @author Eva
 */
/**
 * This class represents a player for a game it has a turn value that is boolean
 * of true or false each player can be asigned a name, otherwise it will be set
 * to null
 *
 * Each player also has a boolean value to win set to true or false. this can be
 * set on or off according to the game and its limitations
 *
 */
public class Player implements Serializable {

    boolean turn = true;
    boolean pieceMove = true;
    String name = null;
    boolean winner = false;
    boolean setColor = true; // i dont like this here, it is not in the right class

    /**
     * [THe constructor for palyer class that sets up an unnamed character that
     * has a default turn to true]
     */
    
    public Player() {
    }

    /**
     * [The constructor for player class with a name assigned to the player sets
     * the default turn to true ]
     * @param s [description]
     */
    public Player(String s) {
        this.setName(s);
    }

    /**
     * [The constructor for the player that will set turn off the turn so the
     * players first turn is turned on or off. THis constructor also takes in a
     * String literal to represent the name of the player]
     * @param s [The string literal to represetnt the name]
     * @param setTurnOff [either 1 or 0;]
     */
    public Player(String s, boolean setTurnOff) {
        this.setName(s);
        if (setTurnOff) {
            this.restrictTurn();
        }
    }

    /**
     * [The constructor for player class that wil not have a name for the player
     * but will set the players turn off as the first turn of the player]
     * @param s [description]
     * @return [description]
     */
    public Player(Boolean setTurnOff) {
        if (setTurnOff) {
            this.restrictTurn();
        }
    }

    /**
     * [The constructor for player class that ]
     * @param s [description]
     * @return [description]
     */
    public void setTurn() {
        this.turn = true;
    }

    /**
     * this method is used to restrict the turn of the player
     */
    public void restrictTurn() {
        this.turn = false;
    }

    /**
     * NOTE: this method may be necessary for v2, currently not used in v1
     *
     * this method is used to set the piece to be able to move
     *
     */
    public void setPieceMove() {
        this.pieceMove = true;
    }

    /**
     * NOTE: this method may be necessary for v2, currently not used in v1
     *
     * this is a method that restricts a piece from moving
     */
    public void restrictPieceMove() {
        this.pieceMove = false;
    }

    /**
     * NOTE: this method may be necessary for v2, currently not used in v1
     *
     * @return [description]
     */
    public boolean getPieceMove() {
        return this.pieceMove;
    }

    /**
     * this method is used to set the name of the player. this method does not
     * need to be used
     * @param s [description]
     */
    public void setName(String s) {
        this.name = s;
    }

    /**
     * this method is used to set the player as the winner
     */
    public void setWin() {
        this.winner = true;
    }

    /**
     * this method retrieves whether the player has won
     * @return [only returns true if the player is set to winner]
     */
    public boolean isWinner() {
        return this.winner;
    }

    /**
     * NOTE: this method may be necessary for v2, currently not used in v1 is
     * this suposed to be in player class? perhaps a i need a chess player class
     */
    public void setSetColor(boolean setCol) {
        this.setColor = setCol;
    }

    /**
     * NOTE: this method may be necessary for v2, currently not used in v1 is
     * this suposed to be in player class? perhaps a i need a chess player class
     */
    public boolean getSetColor() {
        return this.setColor;
    }
}
