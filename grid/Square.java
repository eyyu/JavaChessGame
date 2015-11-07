/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
    public Square(int s, int pos){
    	this.square(s);
    	this.setPosition(pos);
	}
	/**
     */
    /**
     * this constructor is for a sqaure that is part of a grid or map
     * it goes to link the squares with each other as well
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
	protected void setPosition(int pos){
		this.position = pos;
	}
	/**
	 * [getPosition description]
	 * @return [description]
	 */
	public int getPosition(){
		return this.position;
	}
	
	protected void setLeftSquare()
	
	}

	protected void setLeftSquare()
	
	}
	
	protected void setLeftSquare()
	
	}
	
	protected void setLeftSquare()
	
	}


}
