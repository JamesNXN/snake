package com.mygdx.game;

/**
 * Created by nxn1 on 20/11/2016.
 */
public class Cell {
    private int x;
    private int y;
    private boolean fruit;

    public Cell(){
        x = 0;
        y = 0;
        fruit = false;
    }
    public Cell(int coordX, int coordY) {
        x = coordX;
        y = coordY;
        fruit = false;
    }
    public Cell(int coordX, int coordY, boolean amIFruit){
        x = coordX;
        y = coordY;
        fruit = amIFruit;
    }

    int getX(){
        return x;
    }

    int getY(){
        return y;
    }
    boolean getFruit(){
        return fruit;
    }
}
