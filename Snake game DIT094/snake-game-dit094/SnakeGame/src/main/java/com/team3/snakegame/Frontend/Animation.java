package com.team3.snakegame.Frontend;

import com.team3.snakegame.Backend.GameGrid;
import javafx.application.Platform;
import javafx.scene.canvas.GraphicsContext;

import java.io.IOException;

import static com.team3.snakegame.Frontend.MainSnake.sceneSwitcher;

//This class will re draw the snake and fruit according to a given time
public class Animation implements Runnable{
    //We need GameGrid as a component to the Animation class to access its methods (moveSnake(), eat())
    private final GameGrid gameGrid;
    // To store the graphics passed in when initializing the Animation class.
    private final GraphicsContext gC;
    private boolean gameOver;
    private final double FPS = CustomizeController.snakeSpeed;
    //FPS to control the speed of the snake
    private boolean paused;
    //Checks if the game is paused.
    private boolean isPressed;


    Animation(GameGrid gameGrid, GraphicsContext gC){
        this.gameGrid = gameGrid;
        this.gC = gC;
        this.gameOver = false;
        this.paused = false;
        this.isPressed = false;

    }

    @Override
    public void run() {

        //Those are needed to slow down the execution of the while loop.
        double drawInterval  = 1000000000/FPS;
        double delta = 0;
        double lastTime =System.nanoTime();
        double currentTime;

        // The game runs in the while loop until gameOver = true
        while(!gameOver && !paused) {
            currentTime = System.nanoTime();
            delta += (currentTime - lastTime) / drawInterval;
            lastTime = currentTime;
            if (delta >= 1) {
                //Check if the condition for the game over is meet.
                if (gameGrid.gameOver()) {
                    this.gameOver = true;
                    Platform.runLater(() -> {
                        try {
                            sceneSwitcher.setGameOverScene();
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    });
                }
                //Checks if the game is paused and waits until it's not.
                if (paused) {
                    Thread.onSpinWait();
                }
                else {

                    //Update the snake information
                    gameGrid.moveSnake();
                    gameGrid.eat();
                    //Draw the snake in accordance to the new information.
                    Draw.build(gC, gameGrid);

                    delta--;
                }
                isPressed = false;
            }
        }
    }

    public void pause(){
        this.paused = true;
    }
    //Pauses the game
    public void resume(){
        this.paused = false;
    }
    //Resumes the game
    //Getter for the state of the game; paused or not


    public boolean isPressed() {
        return isPressed;
    }

    public void setPressed() {
        isPressed = true;
    }
}


