package com.mygdx.game;

import java.util.Random;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
/**
 Contains the boards current state and some stuff such as spawning the snake and fruit
 and moving the snake around.
 */
public class Board {
    private final int HEIGHT = 64;
    private final int WIDTH = 64;
    Cell[][] board = new Cell[HEIGHT][WIDTH];
    Random random = new Random();
    Snake snake = new Snake();
    Cell fruit = new Cell();
    char prevDirection = 'R';


    void spawnFruit(){
        int x = random.nextInt(HEIGHT) + 1;
        int y = random.nextInt(WIDTH) + 1;
        for (Cell cells : snake.body){
            if (cells.getX() == x && cells.getY() == y){
                this.spawnFruit();
            }
        }
        board[y][x] = new Cell(x,y,Color.RED);
        fruit = new Cell(x,y, Color.RED);
    }

    void spawnSnake(){
        snake.addSegment(new Cell((WIDTH/2)-2,HEIGHT/2, Color.WHITE));
        snake.addSegment(new Cell((WIDTH/2)-1,HEIGHT/2, Color.WHITE));
        snake.addSegment(new Cell(WIDTH/2,HEIGHT/2, Color.WHITE));
        board[HEIGHT/2][WIDTH/2] = snake.body.get(2);
        board[HEIGHT/2][(WIDTH/2)-1] = snake.body.get(1);
        board[HEIGHT/2][(WIDTH/2)-2] = snake.body.get(0);
        this.spawnFruit();
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
            this.moveSnake(new Cell(headX,headY+1, Color.WHITE));
            board[tailY][tailX] = new Cell();
            board[headY+1][headX] = snake.body.get(-1);
            this.prevDirection = 'U';
            if (headX == fruit.getX() && headY+1 == fruit.getY()){
                snake.body.add(new Cell(headX,headY+2, Color.WHITE));
                board[headY+2][headX] = snake.body.get(-1);
                this.spawnFruit();
            }
        } else if (direction == 'R'){
            this.moveSnake(new Cell(headX+1,headY, Color.WHITE));
            board[tailY][tailX] = new Cell();
            board[headY][headX+1] = snake.body.get(-1);
            this.prevDirection = 'R';
            if (headX+1 == fruit.getX() && headY == fruit.getY()){
                snake.body.add(new Cell(headX+2,headY, Color.WHITE));
                board[headY][headX+2] = snake.body.get(-1);
                this.spawnFruit();
            }
        } else if (direction == 'D'){
            this.moveSnake(new Cell(headX,headY-1, Color.WHITE));
            board[tailY][tailX] = new Cell();
            board[headY-1][headX] = snake.body.get(-1);
            this.prevDirection = 'D';
            if (headX == fruit.getX() && headY-1 == fruit.getY()){
                snake.body.add(new Cell(headX,headY-2, Color.WHITE));
                board[headY-2][headX] = snake.body.get(-1);
                this.spawnFruit();
            }
        } else if (direction == 'L') {
            this.moveSnake(new Cell(headX - 1, headY, Color.WHITE));
            board[tailY][tailX] = new Cell();
            board[headY][headX - 1] = snake.body.get(-1);
            this.prevDirection = 'L';
            if (headX-1 == fruit.getX() && headY == fruit.getY()){
                snake.body.add(new Cell(headX-2,headY, Color.WHITE));
                board[headY][headX-2] = snake.body.get(-1);
                this.spawnFruit();
            }
        }
    }
    void update(Pixmap screen){
        // changes board state and main logic stuff
    }
}

