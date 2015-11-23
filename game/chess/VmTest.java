package assignment2.game.chess;

import assignment2.game.BoardGamePiece;
import assignment2.grid.Grid;
import assignment2.grid.Square;

class VmTest { // inner class for the boardgame

    static final int BOARDSIZE = 8;
    boolean vM[][] = new boolean[BOARDSIZE][BOARDSIZE];
    Grid board = new Grid(BOARDSIZE); //sets a grid of 8 by 8;
    Square square[][] = new Square[BOARDSIZE][BOARDSIZE];

    private VmTest(BoardGamePiece piece, int curPos) {
        //get piece position
        for (int row = 0; row < BOARDSIZE; row++) {// first loop for rows
            for (int col = 0; col < BOARDSIZE; col++) { // second loop for columns 
                int newPos = (row * BOARDSIZE) + col + 1;
                System.out.println("checking position:" + newPos); /*
                 * tester
                 */

                if (checkValidity(curPos, piece, newPos)) {
                    vM[row][col] = true;
                } else {
                    vM[row][col] = false;
                }
            }
        }
    }

    /**
     *
     * This method goes to check the validity a requested space on the baord
     * according the piece being checked. the current numeric cell value the
     * piece has and the numeric cell value that the player would like to put
     * the piece
     *
     * @param curPos [this is a numeric value of the cell the piece is currently
     * at]
     * @param piece [this is the piece that will be a specific class to be able
     * to determine wether a move is valid ]
     * @param newPos [this is the new position the piece would go into]
     * @return [the function returns true if the location of the requested space
     * is a valid place for the piece to move to]
     */
    private boolean checkValidity(int curPos, BoardGamePiece piece, int newPos) {

        int move = piece.move(curPos, newPos, board); // asks the specific piece to 
        System.out.println("");
//move to check if it is a valid move right off the back
        int newX = board.getX(newPos);
        int newY = board.getY(newPos);
        Square tempNew = square[newX - 1][newY - 1]; // locating the sqaure for the selected location 
        Boolean newPosColor, curPosColor;

        //the following portion of the code  will check the square to make sure 
        //that the peice on the square is not of the smae setColor 
        //to prevent a usr from kiling their own pieces 
        if (tempNew != null) {
            int curX = board.getX(curPos);
            int curY = board.getY(curPos);

            Square tempCur = square[curX - 1][curY - 1]; // assigns a temp to Square obect
            newPosColor = (tempNew.getPiece()).getColor();
            curPosColor = (tempCur.getPiece()).getColor();
            if ((newPosColor && curPosColor) || (!newPosColor && !curPosColor)) {
                // checking the set color to see if they are form the same set
                return false;
            }
        } else if (move == curPos) { // a pieces move will return its on position if it 
            //cannot move to that positon  
            return false;
        }
        return true;
    }

    /**
     * This method is the method that gets the validity of the sqaure the piece
     * being moved is trying to go to its read the validity matrix and double
     * checks to makes sure that the location of the validity matrix is a valid
     * spot otherwise, the peice will not be able to move to the new location
     *
     * @param newPos [the numeric cell position of the square the piece is
     * trying to move ]
     * @param g [the grid that holds a specific size of rows and columns ]
     * @return [the boolean value held at the position that has been requested ]
     */
    public boolean getValidity(int newPos, Grid g) {
        int x = g.getX(newPos);
        int y = g.getY(newPos);
        return vM[x - 1][y - 1]; // returns the value 
        //found in the validity matrix 
        //for that position desired by the chess piece
    }

    public void print() { // tester to make sure it works.
        // it does not work 
        for (int row = 0; row < BOARDSIZE; row++) {
            for (int col = 0; col < BOARDSIZE; col++) {
                int temp;
                if (vM[row][col] == true) {
                    temp = 1;
                } else {
                    temp = 0;
                }
                System.out.print(temp + " ");
            }
            System.out.println("");
        }
    }

    public static void main(String[] args) {
        TestKnight pawn1 = new TestKnight();
        pawn1.setColor(true);
        VmTest vm = new VmTest(pawn1, 58);
        vm.print();
    }

}
