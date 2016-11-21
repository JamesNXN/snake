package com.mygdx.game;

import java.util.Random;
/**
 Contains the boards current state and some stuff such as spawning the snake and fruit
 and moving the snake around.
 */
public class Board {
    private Cell[][] board = new Cell[256][256];
    private Random random = new Random();
    private Snake snake = new Snake();
    private Cell fruit = new Cell();
    private char prevDirection = 'R';


    void spawnFruit(){
        int x = random.nextInt(256) + 1;
        int y = random.nextInt(256) + 1;
        for (Cell cells : snake.body){
            if (cells.getX() == x && cells.getY() == y){
                this.spawnFruit();
            }
        }
        board[y][x] = new Cell(x,y);
        fruit = new Cell(x,y);
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
            if (headX == fruit.getX() && headY+1 == fruit.getY()){
                snake.body.add(new Cell(headX,headY+2));
                board[headY+2][headX] = snake.body.get(-1);
                this.spawnFruit();
            }
        } else if (direction == 'R'){
            this.moveSnake(new Cell(headX+1,headY));
            board[tailY][tailX] = new Cell();
            board[headY][headX+1] = snake.body.get(-1);
            this.prevDirection = 'R';
            if (headX+1 == fruit.getX() && headY == fruit.getY()){
                snake.body.add(new Cell(headX+2,headY));
                board[headY][headX+2] = snake.body.get(-1);
                this.spawnFruit();
            }
        } else if (direction == 'D'){
            this.moveSnake(new Cell(headX,headY-1));
            board[tailY][tailX] = new Cell();
            board[headY-1][headX] = snake.body.get(-1);
            this.prevDirection = 'D';
            if (headX == fruit.getX() && headY-1 == fruit.getY()){
                snake.body.add(new Cell(headX,headY-2));
                board[headY-2][headX] = snake.body.get(-1);
                this.spawnFruit();
            }
        } else if (direction == 'L') {
            this.moveSnake(new Cell(headX - 1, headY));
            board[tailY][tailX] = new Cell();
            board[headY][headX - 1] = snake.body.get(-1);
            this.prevDirection = 'L';
            if (headX-1 == fruit.getX() && headY == fruit.getY()){
                snake.body.add(new Cell(headX-2,headY));
                board[headY][headX-2] = snake.body.get(-1);
                this.spawnFruit();
            }
        }
    }
}

