package com.team3.snakegame.Backend;

import javafx.scene.image.Image;
import javafx.scene.shape.Rectangle;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.net.URL;
import java.util.Random;
import java.util.Scanner;



public class GameGrid {
    private final Snake snake;
    private Fruit fruit;

    private int score;

    private final int height;
    private final int width;
    private final int squareNumber;
    private final Orientation direction = Orientation.LEFT;
    private Orientation lastOrientation = direction;
    private final Random random = new Random();

    public GameGrid(int height, int width, int squareNumber){
        this.height = height;
        this.width = width;
        this.squareNumber = squareNumber;
        this.snake = new Snake(height,width,squareNumber); //NOt the best place to initialise but for testing purposes it's here now
        generateFruit(); //NOt the best place to initialise but for testing purposes it's here now

    }

    //The movement of the snake
    public void moveSnake(){
        Rectangle rec = new Rectangle(this.height, this.width);
        if(snake.getOrientation() == Orientation.LEFT) {
            rec.setX(snake.getSnakeBody().get(0).getX()-this.width);
            rec.setY(snake.getSnakeBody().get(0).getY());

        }else if (snake.getOrientation() == Orientation.RIGHT){
            rec.setX(snake.getSnakeBody().get(0).getX()+this.width);
            rec.setY(snake.getSnakeBody().get(0).getY());

        }else if (snake.getOrientation() == Orientation.UP){
            rec.setX(snake.getSnakeBody().get(0).getX());
            rec.setY(snake.getSnakeBody().get(0).getY()-this.height);

        }else {
            rec.setX(snake.getSnakeBody().get(0).getX());
            rec.setY(snake.getSnakeBody().get(0).getY()+this.height);
        }
        lastOrientation = snake.getOrientation();
        snake.getSnakeBody().remove(snake.getSnakeBody().get(snake.getSnakeBody().size()-1));
        snake.getSnakeBody().add(0,rec);
    }

    //Generation of the fruit
    public void generateFruit(){

        boolean onSnake = true;
        // locate the fruit randomly
        int row = random.nextInt(squareNumber)*width;
        int column = random.nextInt(squareNumber)*height;
        Image type = Fruit.randomFruitType();
        // Each time a fruit is generated, a new type is given to that fruit.

        while (onSnake){
            for (int i = 0; i < snake.getSnakeBody().size()-1; i++){
                // check the width and height of the snake body , and locate the fruit randomly
                if(row == snake.getSnakeBody().get(i).getX() && column == snake.getSnakeBody().get(i).getY()){
                    row = random.nextInt(squareNumber)*width;
                    column = random.nextInt(squareNumber)*height;
                } else{
                    //Stores the attributes of the new fruit
                    fruit = new Fruit(row,column,type);
                    onSnake = false;
                }
            }
        }
    }
    //Makes the snake able to eat the fruit
    public void eat(){
        if(snake.getSnakeBody().get(0).getX() == getFruit().getRow() && snake.getSnakeBody().get(0).getY() == getFruit().getColumn()) {
            snake.increment();
            generateFruit();
            score+= 10;
        }
    }

    public boolean gameOver(){
        //If the snake's head run into the walls(out of the grid area), game over
        if (snake.getSnakeBody().get(0).getX() == width*squareNumber ||
                snake.getSnakeBody().get(0).getY() == height*squareNumber){
            saveScoreboard();
            return true;
        }
        if (snake.getSnakeBody().get(0).getX() < 0 ||
                snake.getSnakeBody().get(0).getY() < 0){
            saveScoreboard();
            return true;
        }
        //If the snake runs into itself, game over
        for(int i = 1; i < snake.getSnakeBody().size() - 1 ; i++){
            if(snake.getSnakeBody().get(0).getX() == snake.getSnakeBody().get(i).getX() &&
                    snake.getSnakeBody().get(0).getY() == snake.getSnakeBody().get(i).getY()){
                saveScoreboard();
                return true;
            }
        }
        return false;
    }

    public void saveScoreboard(){
        try{

            ClassLoader classLoader = getClass().getClassLoader();
            URL url = classLoader.getResource("scores.json");

            assert url != null;
            Scanner reader = new Scanner(new File(url.getFile()));
            StringBuilder builder = new StringBuilder();

            while (reader.hasNextLine()){
                builder.append(reader.nextLine());
            }
            reader.close();

            int scoresStart = builder.indexOf("[") + 1;
            int scoresEnd = builder.lastIndexOf("]");

            String scoresString = builder.substring(scoresStart, scoresEnd);

            scoresString += ", " + score;

            builder.replace(scoresStart, scoresEnd, scoresString);

            BufferedWriter writer = new BufferedWriter(new FileWriter(url.getFile()));
            writer.write(builder.toString());
            writer.close();

        }catch(Exception e){
            System.out.println("Error writing to file");
        }
    }
    public void up(){
        if (lastOrientation != Orientation.DOWN){
            snake.setOrientation(Orientation.UP);
        }
    }
    public void down(){
        if (lastOrientation != Orientation.UP){
            snake.setOrientation(Orientation.DOWN);
        }
    }
    public void left(){
        if (lastOrientation != Orientation.RIGHT){
            snake.setOrientation(Orientation.LEFT);
        }
    }
    public void right(){
        if (snake.getOrientation() != Orientation.LEFT){
            snake.setOrientation(Orientation.RIGHT);
        }
    }


    public Fruit getFruit() {
        return fruit;
    }

    public int getScore() {
        return score;
    }

    public Snake getSnake(){
        return this.snake;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int getSquareNumber() {
        return squareNumber;
    }

    public Orientation getLastOrientation() {
        return lastOrientation;
    }
}
