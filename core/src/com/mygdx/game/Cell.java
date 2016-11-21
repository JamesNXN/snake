package com.mygdx.game;

import com.badlogic.gdx.graphics.Color;
/**
 This Class holds information on the cells that form the snakes body
 and the cell for the fruit.
 */
class Cell {
    private int x;
    private int y;
    private Color color;

    Cell(){
        x = 0;
        y = 0;
        color = Color.BLACK;
    }
    Cell(int coordX, int coordY) {
        x = coordX;
        y = coordY;
        color = color.BLACK;
    }
    Cell(int coordX, int coordY, Color cellColor){
        x = coordX;
        y = coordY;
        color = cellColor;
    }
    @Override
    public boolean equals(Object obj){
        Cell cell = (Cell) obj;
        return this.getX() == cell.getX() && this.getY() == cell.getY();
    }

    int getX(){
        return x;
    }

    int getY(){
        return y;
    }

    Color getColor(){
        return color;
    }
}
