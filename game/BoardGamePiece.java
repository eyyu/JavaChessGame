/*
 * COMP 2526 -- ASSIGNEMNT 2 -- CHESS GAME 
 * Author: Eva Yu * 
 * BCIT -- A00942918 -- CST2B  * 

 */
package assignment2.game;

/**
 * This interface will make sure that for any board game with a pices, the pieces ( were they a class)
 *  should implment this interface in order to ensure a move method can be called for every piece 
 * @author Eva
 */
public interface BoardGamePiece {

    void move();
}
