/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment2.grid;

/**
 *
 * @author Eva
 */
public class Grid {

    private int row;
    private int colummn;
    /**
     * this constructor sets a defaukt 10 by 10 grid
     */
    public Grid() {
        this.row = 10;
        this.colummn = 10;
    }
    /**
     * this constructor sets the sqaure grid of an indicated size  
     * @param  size [description]
     */
    public Grid(int size){
        this.row = size;
        this.colummn = size;
    }
    /**
     * this constructor sets a grid with r rows and c columns
     * @param  r the number of rows in the grid 
     * @param  c the number of columns in the grid 
     */
    public Grid(int r, int c) {
        this.row = r;
        this.colummn = c;
    }
    /**
     * gets the number of rows there are in the grid 
     * @return int indicating number of rows in grid 
     */
    public int getRow() {
        return this.row;
    }
    /**
     * returns number of columns found in the row 
     * @return int indicating number of cols in grid 
     */
    public int getCol() {
        return this.colummn;
    }
    /**
     * gets the numeric value of the position of the graph according to the x and y indices
     * numbered from 1 - n 
     * from left to right, top to bottom 
     * 
     * @param  x [int indicating the row ]
     * @param  y [int indicating the col ]
     * @return   [int indicating the numberic value assinged to the intersetion of the x an y indices]
     */
    public int getPos(int x, int y) {
        return (x * col) + y + 1;
    }

}
