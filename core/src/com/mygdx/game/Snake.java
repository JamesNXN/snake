package com.mygdx.game;

import java.util.List;
import java.util.ArrayList;
/**
 * Created by nxn1 on 20/11/2016.
 */
public class Snake{
    List<Cell> body = new ArrayList<Cell>();

    void addSegmant(Cell cell) {
        body.add(cell);
    }
}
