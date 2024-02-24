package com.team3.snakegame.Frontend;

import javafx.fxml.FXML;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import java.io.IOException;

import static com.team3.snakegame.Frontend.MainSnake.sceneSwitcher;


public class CustomizeController {
    @FXML
    HBox h1;
    @FXML
    HBox h2;
    @FXML
    HBox h3;
    public static Color snakeColor = Color.WHEAT;
    public static int snakeSpeed = 10;

    public void setRed() {
        snakeColor = Color.RED;
        h1.setBackground(new Background(new BackgroundFill(Color.RED,null,null)));
        h2.setBackground(new Background(new BackgroundFill(Color.RED,null,null)));
        h3.setBackground(new Background(new BackgroundFill(Color.RED,null,null)));
    }
    public void setWhite() {
        snakeColor = Color.WHITE;
        h1.setBackground(new Background(new BackgroundFill(Color.WHITE,null,null)));
        h2.setBackground(new Background(new BackgroundFill(Color.WHITE,null,null)));
        h3.setBackground(new Background(new BackgroundFill(Color.WHITE,null,null)));
    }
    public void setBlue() {
        snakeColor = Color.BLUE;
        h1.setBackground(new Background(new BackgroundFill(Color.BLUE,null,null)));
        h2.setBackground(new Background(new BackgroundFill(Color.BLUE,null,null)));
        h3.setBackground(new Background(new BackgroundFill(Color.BLUE,null,null)));
    }
    public void setPink() {
        snakeColor = Color.PINK;
        h1.setBackground(new Background(new BackgroundFill(Color.PINK,null,null)));
        h2.setBackground(new Background(new BackgroundFill(Color.PINK,null,null)));
        h3.setBackground(new Background(new BackgroundFill(Color.PINK,null,null)));
    }

    public void setSlow() {
        snakeSpeed = 7;
    }
    public void setNormal() {
        snakeSpeed = 10;
    }
    public void setFast() {
        snakeSpeed = 12;
    }
    public void setExtreme() {
        snakeSpeed = 15;
    }


    public void backToMenu() throws IOException {
        sceneSwitcher.setMainMenuScene();
    }


    public void play() throws IOException {
        sceneSwitcher.setGameModeScene();
    }



}
