/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment2.game.chess;

import assignment2.grid.Grid;
import assignment2.grid.Square;

/**
 * TH=his is the chess board class that a chess game will have 
 * 
 * @author Eva
 */
public class ChessBoard{ 
    
    private static final BOARDSIZE = 8;
    private static final PAWNSROW = 2; // pawns occur at the second row from either end of the board
    private static final PAWN_INIT_ROW_DIFF = 5; // this is the difference between the first row of pawns and the second row of pawn when the game is initialized
    Grid board = new Grid(BOARDSIZE); //sets a grid of 8 by 8;
    Square square[][] = new Sqaure[BOARDSIZE][BOARDSIZE];

    /* the following is an obeject is a priavte class that hols a matirx for the spaces a piece can move 
    be used by the chess peice to generate the correct places for validity. 
    if the spot chosen is valid, for the piece chosen, then the pieve will c
    all move and move to that position*/
 	ValidityMatrix validityMatrix;   
    
    public ChessBoard(){
    	    
    	    for ( int row = 1; row < BOARDSIZE; row += PAWN_INIT_ROW_DIFF) { // SET THEM PAWNS UP
    	    	for(int col =0; col < BOARDSIZE; col++){
					this.sqaure[row][col].setPiece(new Pawn()); // new pawn for each sqaure in the
	    	    	this.sqaure[row][col].setPosition(board.getPos(row+1, col+1)); // are these too many nested functions??!?  
	    	    	//but ... it makes life so much easier!! NO ,it is NOT ( says I )
    	    	}
    	    }

    	    // the following loop for all the pieces
    	    for (int row = 0; row < BOARDSIZE; row += (BOARDSIZE -1)  ) {
    	    	for (int col = 0; col < BOARDSIZE; col++){
    	     	
	    	     	int pos = board.getPos(row+1, col+1);
	    	     	switch(pos){
	    	     	//Rook
	    	     	case 1:
	    	     	case 8:
	    	     		this.square[row][col] = setPiece(new Rook()); 
	    	     		this.sqaure[row][col].getPiece()).setColor = true;
	    	     		break;
	    	     	case 57:
	    	     	case 64:
	    	     		this.square[row][col] = setPiece(new Rook());	
	    	     		this.sqaure[row][col].getPiece()).setColor = false;
	    	     		break;
	    	     	//knight
	    	     	case 2:
	    	     	case 7:
	    	     		this.square[row][col] = setPiece(new Knight());	
	    	     		this.sqaure[row][col].getPiece()).setColor = true;
						break;
	    	     	case 58:
	    	     	case 63:
	    	     		this.square[row][col] = setPiece(new Knight());	
	    	     		this.sqaure[row][col].getPiece()).setColor = false;
	    	     		break;
	    	     	//bishop
	    	     	case 3:
	    	     	case 6:
	    	     		this.square[row][col] = setPiece(new Bishop());	
	    	     		this.sqaure[row][col].getPiece()).setColor = true;
	    	     		break;
	    	     	case 59: 
	    	     	case 62:
	    	     		this.square[row][col] = setPiece(new Bishop());	
	    	     		this.sqaure[row][col].getPiece()).setColor = false;
	    	     		break;
	    	     	case 5: // king
	    	     		this.square[row][col] = setPiece(new King());	
	    	     		this.sqaure[row][col].getPiece()).setColor = true;
	    	     		break;
	    	     	case 4: // queen
	    	     		this.square[row][col] = setPiece(new Queen());	
	    	     		this.sqaure[row][col].getPiece()).setColor = true;
	    	     		break;
	    	     	case 60: //QUEEN
	    	     		this.square[row][col] = setPiece(new Queen());	
	    	     		this.sqaure[row][col].getPiece()).setColor = false;
	    	     		break; 
	    	     	case 61: //KING
	    	     		this.square[row][col] = setPiece(new King());	
	    	     		this.sqaure[row][col].getPiece()).setColor = false;
	    	     		break;
	    	     	}
    	     	}	
    	     } // set the first and last rows 

    	    }
    	    	

    	    //SET THEM queens
    	    	//position 1)(x: 1,y:5 ) 2)(x:8 ,y:4 ) 
    	    //SET THEM kings
			  	//position 1)(x: 1,y: 4) 2)(x:8 ,y:5 ) 
    	    //SET THEM ROOKS
    	    	//position cols:1 ,8 rows:1, 8 	
    	    //SET THEM BISHOPS
    	    	//position cols: rows:3,6 	1, 8
    	    //SET THEM KNIGHTS
    	    	//position cols: rows: 2,7	1, 8
    	    	

    } // end chessBoard constructor 1 
	
	/**
	 * [generateValidityMatrix description]
	 * @param p [description]
	 */
	private void generateValidityMatrix(BoardGamePiece p, int pos){
		new ValidityMatrix(p);
		this.board.getX(pos);
		this.board.getY(pos);
	}
	/**
	 * this mode should check the validity of the move the player is attempting 
	 * @param  p   [description]
	 * @param  pos [description]
	 * @param  g   [description]
	 * @return     [description]
	 */
	public boolean checkMove(int newPos, Grid g){
		//piece handling code
		//get the x and get the y 
		//use the x and y in the validitiy matix generated  
		return 1;
	} 

	class ValidityMatrix{ // inner class for the boardgame
		boolean validityMatrix[][] = new boolean[BOARDSIZE][BOARDSIZE]; 
		
		static validityMatrix(BoardGamePiece piece){
			//get piece position
			for (int row = 0 ; row < BOARDSIZE ; row++ ) {// first loop for rows
				for (int col = 0; col < BOARDSIZE; col ++ ) { // second loop for columns 
					if (checkValidity(x, y, piece, (row * BOARDSIZE) + col + 1) //NOTE: need to write a method that will generate 
						validityMatrix[row][col] == true;
					else 
						validityMatrix[row][col] == false;
				}
			}
		}

		private boolean checkValidity(int curX, int curY, BoardGamePiece piece, int pos){

		}

		public boolean getValidity(int newPos, Grid g){

		}

	} 

}//end ChessBoard class

