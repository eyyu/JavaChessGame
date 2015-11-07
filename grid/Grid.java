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

    int row;
    int colummn;

    public Grid() {
        row = 10;
        colummn = 10;
    }

    public Grid(int r, int c) {
        colummn = c;
        row = r;
    }

    public int getRow() {
        return this.row;
    }

    public int getCol() {
        return this.colummn;
    }

    public int getPos(int x, int y) {
        return (x - 1) * y;
    }

}
