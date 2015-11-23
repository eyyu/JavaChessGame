package assignment2.game.chess;

import assignment2.game.BoardGamePiece;
import assignment2.grid.Grid;
import assignment2.player.Player;

class TestPawn implements BoardGamePiece {

    Boolean setColor = true; // this sets the color of the piece according to the playe. 
    //black is represented by 0 and white represented by one
    Boolean firstmove = true; // allows the one time movment of two 
    //steps in the very first move of the pawn;
    public String pieceName = "PAWN";

    Player player;// player assigned to the piece

    /**
     * This method moves a pawn in chess and restricts it to only the moves a
     * pawn can make
     * @param x [the int representing the number of spaces going up or down (
     * signed)]
     * @param y [the int representing the number of spaces going left or right (
     * signed)]
     * @return [the int of the position of the square it needs to move to]
     */
    @Override
    public int move(int currentPos, int dest, Grid g) {

        //NOTE TO SELF for V2: 
        //need to get sqaure for makng a kill to see if there is a
        //piece in the square.
        int xCur, xDest, xDiff;
        int yCur, yDest, yDiff;

        xCur = g.getX(currentPos);
        yCur = g.getY(currentPos);
        xDest = g.getX(dest);
        yDest = g.getY(dest);
//
//        System.out.println("xCur:" + xCur);//tester
//        System.out.println("yCur:" + yCur);//tester
//        System.out.println("xDest:" + xDest);//tester
//        System.out.println("yDest:" + yDest);//tester

        if (setColor == true) { // if set is white
            xDiff = xDest - xCur;
            yDiff = yDest - yCur;
        } else { // if set is black
            xDiff = xCur - xDest;
            yDiff = yCur - yDest;
        }

//        System.out.println("xDiff:" + xDiff);//tester
//        System.out.println("yDiff:" + yDiff);//tester
        if (this.firstmove == true) {
            this.firstmove = false;
            if (xDiff == 2) {
                return dest;
            }
        }

        if (xDiff == 1 && yDiff == 0) {
            return dest;
        }
        //Note to self: 
        //for the kills..
        /*
         * if (yDiff == 1 && xDiff == 1){ g.getPiece(); return dest; //move pawn
         * to the upper } if (yDiff == 1 && xDiff == 1){ return dest; //move
         * pawn to the upper }
         */
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
     * @return [description]
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
        TestPawn pawn = new TestPawn();
        System.out.println("move to 24: " + pawn.move(10, 26, g));
        System.out.println("move to 32: " + pawn.move(26, 34, g));
    }
}
