package com.mygdx.game;

/**
 This Class holds information on the cells that form the snakes body
 and the cell for the fruit.
 */
class Cell {
    private int x;
    private int y;

    Cell(){
        x = 0;
        y = 0;
    }
    Cell(int coordX, int coordY) {
        x = coordX;
        y = coordY;
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
}
