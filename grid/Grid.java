/*
 *COMP 2526 Assignment 2 -- chess game
 * November 11th , 2015 
 */
package assignment2.grid;

/**
 * This is the grid class.
 *
 * it will be extended by the boardclass for board games in order to better
 * manage columns and rows of the board.
 *
 * It can be used on conjuntion with the square class to create an object at
 * each position on the grid
 *
 * @author Eva
 */
public class Grid {

    private final int row;
    private final int colummn;

    /**
     * this constructor sets a default 10 by 10 grid
     */
    public Grid() {
        this.row = 10;
        this.colummn = 10;
    }

    /**
     * this constructor sets the square grid of an indicated size
     * @param size [description]
     */
    public Grid(int size) {
        this.row = size;
        this.colummn = size;
    }

    /**
     * this constructor sets a grid with r rows and c columns
     * @param r the number of rows in the grid
     * @param c the number of columns in the grid
     */
    public Grid(int r, int c) {
        this.row = r;
        this.colummn = c;
    }

    /**
     * gets the number of rows there are in the grid
     * @return int indicating number of rows in grid
     */
    public int getRowSize() {
        return this.row;
    }

    /**
     * returns number of columns found in the row
     * @return int indicating number of cols in grid
     */
    public int getColSize() {
        return this.colummn;
    }

    /**
     * gets the numeric value of the position of the graph according to the x
     * and y indices numbered from 1 - n from left to right, top to bottom
     *
     * @param x [int indicating the row ]
     * @param y [int indicating the col ]
     * @return [int indicating the numeric value assigned to the intersection of
     * the x an y indices]
     */
    public int getPos(int x, int y) {
        return ((x - 1) * this.colummn) + y;
    }

    /**
     * this method will return the column at the position requested this method
     * assumes the rows and columns start at 1 this method also assumes the
     * position of the object begins at 1 - n from top to bottom, left to right
     * @param pos [description]
     * @return [description]
     */
    public int getX(int pos) {
        if (pos % colummn == 0) {
            return (pos / this.colummn);
        } else {
            return (pos / this.colummn) + 1;
        }
    }

    /**
     * THis method will return the position at the y axis of the object assuming
     * that the grid has the numbers 1 - n count left to rigth, top to bottom
     *
     * @param pos [description]
     * @return [description]
     */
    public int getY(int pos) {
        int posY = pos % this.row;
        if (posY == 0) {
            return this.colummn;
        } else {
            return (posY);
        }
    }

}
