/*
NOTE TO SELF: Still need to fix the boundaries of the left, right upper, lower in a grid!!! 
 */
package assignment2.grid;

import java.awt.Color;

/**
 * This is the square2 class. 
 * It is here
 * @author Eva
 */
public class Square2 {
	// somehow implement   piece so each square2 has a piece ?

    //are the follwong necessary fr the game? 
    protected int side;
    protected int vol;
    protected int perim;
    protected int position; // when it is on a grid 
    			  //going from left to right, 
    			  //top to bottom 
    			  //startin at 1;
    // are the follwing necesary for the game? 
    //*** 			  
    //Note to self: should i make this a sqaure instead of an int??
    // if so, how do i make it work?
    //****
    protected int prevSquare2; // for making the square2 a node in a linked list 
    protected int nextSquare2; // for making the square2 a node in a linked list 

    /* the following variables will needs to be assocaited with the grid class*/
    protected int rightSquare2; // for making the square2 a node in a graph
    protected int leftSquare2; // for making the square2 a node in a graph
    protected int lowerSquare2; // for making the square2 a node in a graph
    protected int upperSquare2; // for making the square2 a node in a graph
	/**
	 * basic empty constructor  for a swaure 
	 * that sets a default of square2 with a size of 1 
	 * 
	 */
	public Square2(){
		this.square2(1);
	}
	/**
	 * this constructor sets a sqaure that is not part of a grid or a map 
	 * it will not have a position assigned to it.
	 * It will only define the side of a square2  
	 * 
	 * @param  s [takes in the length of a side ]
	 */
    public Square2(int s) {
        side = s;
        vol = side * side * side;
        perim = side * 4;
    }
    /**
     * this constructor is for a sqaure that is part of a grid 
     * it will set the position of the squar2e
     *  
     * @param  s   [takes in the length of a side of the square2]
     * @param  pos [description]
     */
    public Square2(int s, int pos, Grid grid){
    	this.square2(s);
    	this.setPosition(pos, grid);
	}
	/**
     */
    /**
     * this constructor is for a sqaure that is part of a linked list
     * it goes to link the square2s with each other and 
     * it will set the position of the squar2e
     *  
     * @param  s    [takes in the lenght of a side of a square2]
     * @param  pos  [the position of the sqaure according to the gric]
     * @param  next [connects the sqaure to the next one]
     * @return      [connects the square2 to the prev one]
     */
    public Square2(int s, int pos, int prev, int next){
    	this.square2(s);
    	this.setPosition(pos);
    	this.prevSquare2 = prev;
		this.nextSquare2 = next;
	}
	//perhaps the set left nad right are not necssary par tof the game.. 
	/**
	 * Finds the position of the square2 on  a linked list or map 
	 * @param pos [description]
	 */
	protected void setPosition(int pos, Grid grid){
		int x = grid.getCol(); // retrives number the rows in the grid 
		int y = grid.getRow(); // retrieves the the columns in the grid 
		this.position = pos; // retrieves the position of the squar
		this.setrightSquare2(x,y);
		this.setupperSquare2(x,y);
		this.setlowerSquare2(x,y);
		this.setLeftSquare2(x,y);
	}
	//this one is necessary for the pieces. most-def keep it 
	/**
	 * [getPosition description]
	 * @return [description]
	 */
	public int getPosition(){
		return this.position;
	}
	/**
	 * sets the position of the sqaure left of the current square2 on the grid
	 * @param x [int indicating the number of rows]
	 * @param y [int indicating the number of columns]
	 */
	protected void setLeftSquare2(int x , int y){
		if(){

		}
		this.leftSquare2 = this.position - 1;
	}
	/**
	 * set the position of the square2 right of the current square2 on the grid 
	 * @param x [int indicating the number of rows]
	 * @param y [int indicating the number of columns]
	 */
	protected void setRightSquare2(int x , int y){
		this.rightSquare2 = this.position + 1;
	}
	/**
	 * set the position of the square2 on top of the current square2 on the grid 
	 * @param x [int indicating the number of rows]
	 * @param y [int indicating the number of columns]
	 */
	protected void setUpperSquare2(int x , int y){
		this.upperSquare2 = this.position - col;
	}
	/**
	 * sets the position of the sqaure below the current square2 on the grid
	 * @param x [int indicating the number of rows]
	 * @param y [int indicating the number of columns]
	 */
	protected void setLowerSquare2(int x , int y){
		this.lowerSquare2 = this.position + col;
	}

	/**
	 * returns the position of the sqaure on the left of the current sqaure 
	 * @return [in representing the numerical position of the square2 left of the current square2]
	 */
	public int getLeftSquare2(){
		return this.leftSquare2; 
	}
	/**
	 * returns the position of the sqaure on the right of the current sqaure 
	 * @return [in representing the numerical position of the square2 right of the current square2]
	 */
	public int getRightSquare2(){
		return this.rightSquare2; 
	}
	/**
	 * returns the position of the sqaure on the top of the current sqaure 
	 * @return [in representing the numerical position of the square2 on top of the current square2]
	 */
	public int getUpperSquare2(){
		return this.upperSquare2; 
	}
	/**
	 * returns the position of the sqaure the underneath of the current sqaure 
	 * @return [in representing the numerical position of the square2 underneath the current square2]
	 */
	public int getLowerSquare2(){
		return this.lowerSquare2; 
	}



}
