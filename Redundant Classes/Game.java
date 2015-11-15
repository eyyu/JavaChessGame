/*
 * COMP 2526 -- ASSIGNEMNT 2 -- CHESS GAME 
 * Author: Eva Yu 
 * BCIT -- A00942918 -- CST2B 
 */
package assignment2.game;

/**
 * Thsi interface will set the basic parameters  expected in any game.
 * Each game should have instructions and players
 * each game should have a starting point and define some parameters for a winner
 *  
 * @author Eva
 */
public interface Game {
	/*
	Mehotd should initiate the game
	 */
    void start();
    /*
    Method should signify ending of game -- tie or win 
     */
    void end();
    /*
    Method should Signify player who won the game 
     */
    void win();
    /*
    method should return the number of players playing in the game 
     */
    int getPlayers();
    /*
    method should set some indicaton of rules to the game 
     */
    void setInstructions();
    /*
    method should set how to retrieve the instructions of the game
     */
    void getInstructions();
}
