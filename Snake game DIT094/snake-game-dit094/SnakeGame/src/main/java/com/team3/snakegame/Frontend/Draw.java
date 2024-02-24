package com.team3.snakegame.Frontend;

import com.team3.snakegame.Backend.GameGrid;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;


public class Draw {
    public static void build(GraphicsContext gC, GameGrid gameGrid){
        gC.setFill(Color.BLACK);
        gC.fillRect(0,0,600,600);
        // Draw the gameGrid
        //Draw the snake
        gC.setFill(CustomizeController.snakeColor);
        for(int i = 0; i< gameGrid.getSnake().getSnakeBody().size(); i++){
            gC.fillRect(gameGrid.getSnake().getSnakeBody().get(i).getX(),gameGrid.getSnake().getSnakeBody().get(i).getY(),30,30);

        }
        //Draw the fruit
        gC.drawImage(gameGrid.getFruit().getType(), gameGrid.getFruit().getRow(), gameGrid.getFruit().getColumn(),30,30);
    }

}
