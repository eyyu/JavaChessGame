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

    Color color;
    int side;
    int vol;
    int perim;

    public Square(int s) {
        side = s;
        vol = side * side * side;
        perim = side * 4;
    }

}
