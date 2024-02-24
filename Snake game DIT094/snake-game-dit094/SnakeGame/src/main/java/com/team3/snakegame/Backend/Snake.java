package com.team3.snakegame.Backend;

import javafx.scene.shape.Rectangle;
import java.util.ArrayList;

public class Snake {
    //Snake is an ArrayList of rectangles
    private final ArrayList<Rectangle> snakeBody;
    private final int height;
    private final int width;
    // Save the movement direction of the Snake.
    private Orientation orientation;

    //When the Snake is created you must pass the dimension of the scene.
    public Snake(int height, int width, int squareNumber){
        this.height = height;
        this.width = width;
        // When creation,the Snake start moving to LEFT.
        orientation = Orientation.LEFT;
        snakeBody = new ArrayList<>();

        //we initialize the Snake with two rectangles
        Rectangle rec = new Rectangle(this.height, this.width);
        //We specify the snake to spawn in the middle of the scene(width*squareNumber/2)
        rec.setX((float)width*squareNumber/2);
        rec.setY((float)height*squareNumber/2);
        //We add the rectangle to the arraylist
        snakeBody.add(rec);

        rec = new Rectangle();
        rec.setX((float)(width*squareNumber/2) + width);
        rec.setY((float)height*squareNumber/2);
        snakeBody.add(rec);
    }
    public void increment(){
        //The snake grows by adding a new rectangle to the arraylist (snakeBody) and
        //specifying the location of the rectangle in accordance to the direction of the snake.
        Rectangle rec = new Rectangle(this.width, this.height);
        if(orientation == Orientation.LEFT) {
            rec.setX(snakeBody.get(0).getX()+this.width);
            rec.setY(snakeBody.get(0).getY());

        }else if (orientation == Orientation.RIGHT){
            rec.setX(snakeBody.get(0).getX()-this.width);
            rec.setY(snakeBody.get(0).getY());

        }else if (orientation == Orientation.UP){
            rec.setX(snakeBody.get(0).getX());
            rec.setY(snakeBody.get(0).getY()+this.height);

        }else {
            rec.setX(snakeBody.get(0).getX());
            rec.setY(snakeBody.get(0).getY()-this.height);
        }
        snakeBody.add(rec);
    }


    //Getters and setters for the attributes of the Snake
    public ArrayList<Rectangle> getSnakeBody() {
        return snakeBody;
    }

    public Orientation getOrientation() {
        return orientation;
    }

    public void setOrientation(Orientation orientation) {
        this.orientation = orientation;
    }

}
