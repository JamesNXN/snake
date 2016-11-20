package com.mygdx.game;

import java.util.Random;
/**
 * Created by nxn1 on 20/11/2016.
 */
public class Board {
    Cell[][] board = new Cell[256][256];
    Random random = new Random();
    Snake snake = new Snake();
    char prevDirection = 'R';

    void spawnFruit(){
        int x = random.nextInt(256) + 1;
        int y = random.nextInt(256) + 1;
        board[y][x] = new Cell(x,y,true);
    }

    void spawnSnake(){
        snake.addSegmant(new Cell(126,128));
        snake.addSegmant(new Cell(127,128));
        snake.addSegmant(new Cell(128,128));
        board[128][128] = snake.body.get(2);
        board[128][127] = snake.body.get(1);
        board[128][126] = snake.body.get(0);
    }
    void moveSnake(Cell cell){
        snake.body.add(cell);
        snake.body.remove(0);
    }
    void move(char direction){
        Cell head = snake.body.get(-1);
        Cell tail = snake.body.get(0);
        int headX = head.getX();
        int headY = head.getY();
        int tailX = tail.getX();
        int tailY = tail.getY();

        if (direction == 'U'){
            this.moveSnake(new Cell(headX,headY+1));
            board[tailY][tailX] = new Cell();
            board[headY+1][headX] = snake.body.get(-1);
            this.prevDirection = 'U';
        } else if (direction == 'R'){
            this.moveSnake(new Cell(headX+1,headY));
            board[tailY][tailX] = new Cell();
            board[headY][headX+1] = snake.body.get(-1);
            this.prevDirection = 'R';
        } else if (direction == 'D'){
            this.moveSnake(new Cell(headX,headY-1));
            board[tailY][tailX] = new Cell();
            board[headY-1][headX] = snake.body.get(-1);
            this.prevDirection = 'D';
        } else if (direction == 'L') {
            this.moveSnake(new Cell(headX - 1, headY));
            board[tailY][tailX] = new Cell();
            board[headY][headX - 1] = snake.body.get(-1);
            this.prevDirection = 'L';
        }
    }
}

