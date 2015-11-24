package assignment2.game.chess;

import assignment2.grid.Grid;

/**
 *
 */
public class GridPrint {

    public static void main(String args[]) {
        Grid grid = new Grid(8);
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                System.out.printf("%3d", grid.getPos(i + 1, j + 1));
            }
            System.out.println("");
        }
    }

}
