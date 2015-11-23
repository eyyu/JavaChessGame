package assignment2.game.chess;

import assignment2.game.BoardGamePiece;
import assignment2.grid.Grid;
import assignment2.player.Player;

/**
 * THis class represetns the Knight piece on the chess board. this piece has a
 * setColor assigned to it and should not be changed once accessed the piece
 * also has a ENUM value assigned to it this class has only one method, move
 * that it ovverrides from the boardGamePiece class
 *
 * @author Eva
 */
class TestKnight implements BoardGamePiece {

    public String pieceName = "KNIGHT";
    Boolean setColor = true; // this sets the color of the piece according to the playe. 
    Player player;// player assigned to the piece

    /**
     * This method moves a knight in chess and retricts it to only the moves a
     * knight can make
     */
    @Override
    public int move(int currentPos, int dest, Grid g) {
        int xCur, xDest, xDiff;
        int yCur, yDest, yDiff;
        int lStep;

        xCur = g.getX(currentPos);
        yCur = g.getY(currentPos);

        xDest = g.getX(dest);
        yDest = g.getY(dest);

        yDiff = Math.abs(yDest - yCur);
        xDiff = Math.abs(xDest - xCur);
//        System.out.println("xCur:" + xCur);//tester
//        System.out.println("yCur:" + yCur);//tester
//        System.out.println("xDest:" + xDest);//tester
//        System.out.println("yDest:" + yDest);//tester
//        System.out.println("xDiff:" + xDiff);//tester
//        System.out.println("yDiff:" + yDiff);//tester
        lStep = Math.abs(yDiff - xDiff);//this is the difference between a y and an x step. 
        //a night should move in one directiosn 3 steps and then turn and move 1
        //the final diffence should be 2 
//        System.out.println("lStep: " + lStep);//tester
        if (lStep == 1
            && (yDiff == 1 || xDiff == 1)
            && (yDiff == 2 || xDiff == 2)) {
            return dest;
        }
        return currentPos;

    }

    /**
     * please refer to parent class for details of the method
     */
    @Override
    public void setColor(Boolean setColor) {
        this.setColor = setColor;
    }

    /**
     * please refer to parent class for details of the method
     */
    @Override
    public boolean getColor() {
        return this.setColor;
    }

    /**
     * please refer to parent class for details of the method
     */
    @Override
    public String getPieceName() {
        return this.pieceName;
    }

    /**
     * please refer to parent class for details of the method
     */
    @Override
    public Player getPlayer() {
        return this.player;
    }

    /**
     * please refer to parent class for details of the method
     */
    @Override
    public void setPlayer(Player p) {
    }

    public static void main(String[] args) {
        Grid g = new Grid(8);
        TestKnight pawn = new TestKnight();
        System.out.println("move to 24: " + pawn.move(7, 24, g));
        System.out.println("move to 22: " + pawn.move(7, 22, g));
    }
}
