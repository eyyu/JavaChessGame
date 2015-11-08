/*
NOTE TO SELF: Still need to fix the boundaries of the left, right upper, lower in a grid!!! 
 */
package assignment2.grid;

import java.awt.Color;

/**
 *
 * @author Eva
 */
public class Square {

    protected int side;
    protected int vol;
    protected int perim;
    protected int position; // when it is on a grid 
    			  //going from left to right, 
    			  //top to bottom 
    			  //startin at 1;
    
    protected int prevSquare; // for making the square a node in a linked list 
    protected int nextSquare; // for making the square a node in a linked list 

    /* the following variables will needs to be assocaited with the grid class*/
    protected int rightSquare; // for making the square a node in a graph
    protected int leftSquare; // for making the square a node in a graph
    protected int lowerSquare; // for making the square a node in a graph
    protected int upperSquare; // for making the square a node in a graph
	/**
	 * basic empty constructor  for a swaure 
	 * that sets a default of square with a size of 1 
	 * 
	 */
	public Square(){
		this.square(1);
	}
	/**
	 * this constructor sets a swaure that is not part of a grid or a map 
	 * it will not have a position assigned to it 
	 * 
	 * @param  s [takes in the length of a side ]
	 */
    public Square(int s) {
        side = s;
        vol = side * side * side;
        perim = side * 4;
    }
    /**
     * this constructor is for a sqaure that is part of a grid 
     * it will set the position of the square
     *  
     * @param  s   [takes in the length of a side of the square]
     * @param  pos [description]
     */
    public Square(int s, int pos, Grid grid){
    	this.square(s);
    	this.setPosition(pos, grid);
	}
	/**
     */
    /**
     * this constructor is for a sqaure that is part of a linked list
     * it goes to link the squares with each other and 
     * it will set the position of the square
     *  
     * @param  s    [takes in the lenght of a side of a square]
     * @param  pos  [the position of the sqaure according to the gric]
     * @param  next [connects the sqaure to the next one]
     * @return      [connects the square to the prev one]
     */
    public Square(int s, int pos, int prev, int next){
    	this.square(s);
    	this.setPosition(pos);
    	this.prevSquare = prev;
		this.nextSquare = next;
	}
	/**
	 * Finds the position of the square on  a linked list or map 
	 * @param pos [description]
	 */
	protected void setPosition(int pos, Grid grid){
		int x = grid.getCol(); // retrives number the rows in the grid 
		int y = grid.getRow(); // retrieves the the columns in the grid 
		this.position = pos;
		setrightSquare(x,y);
		setupperSquare(x,y);
		setlowerSquare(x,y);
		setLeftSquare(x,y);
	}
	/**
	 * [getPosition description]
	 * @return [description]
	 */
	public int getPosition(){
		return this.position;
	}
	/**
	 * sets the position of the sqaure left of the current square on the grid
	 * @param x [int indicating the number of rows]
	 * @param y [int indicating the number of columns]
	 */
	protected void setLeftSquare(int x , int y){
		if(){

		}
		this.leftSquare = this.position - 1;
	}
	/**
	 * set the position of the square right of the current square on the grid 
	 * @param x [int indicating the number of rows]
	 * @param y [int indicating the number of columns]
	 */
	protected void setRightSquare(int x , int y){
		this.rightSquare = this.position + 1;
	}
	/**
	 * set the position of the square on top of the current square on the grid 
	 * @param x [int indicating the number of rows]
	 * @param y [int indicating the number of columns]
	 */
	protected void setUpperSquare(int x , int y){
		this.upperSquare = this.position - col;
	}
	/**
	 * sets the position of the sqaure below the current square on the grid
	 * @param x [int indicating the number of rows]
	 * @param y [int indicating the number of columns]
	 */
	protected void setLowerSquare(int x , int y){
		this.lowerSquare = this.position + col;
	}

	/**
	 * returns the position of the sqaure on the left of the current sqaure 
	 * @return [in representing the numerical position of the square left of the current square]
	 */
	public int getLeftSquare(){
		return this.leftSquare; 
	}
	/**
	 * returns the position of the sqaure on the right of the current sqaure 
	 * @return [in representing the numerical position of the square right of the current square]
	 */
	public int getRightSquare(){
		return this.rightSquare; 
	}
	/**
	 * returns the position of the sqaure on the top of the current sqaure 
	 * @return [in representing the numerical position of the square on top of the current square]
	 */
	public int getUpperSquare(){
		return this.upperSquare; 
	}
	/**
	 * returns the position of the sqaure the underneath of the current sqaure 
	 * @return [in representing the numerical position of the square underneath the current square]
	 */
	public int getLowerSquare(){
		return this.lowerSquare; 
	}

}
