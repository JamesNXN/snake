package com.mygdx.game;

import java.util.List;
import java.util.ArrayList;
/**
 * Created by nxn1 on 20/11/2016.
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
