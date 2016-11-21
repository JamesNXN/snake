package com.mygdx.game;

import java.util.List;
import java.util.ArrayList;
/**
 holds the snakes body and can add segments and also checks for collisions with the snakes own body.
 */
class Snake{
    List<Cell> body = new ArrayList<Cell>();

    void addSegmant(Cell cell) {
        body.add(cell);
    }

    boolean checkCollision(){
        Cell head = this.body.get(-1);
        for (Cell cells : this.body){
            if (head == cells) {
                return true;
            }
        }
        return false;
    }
}
