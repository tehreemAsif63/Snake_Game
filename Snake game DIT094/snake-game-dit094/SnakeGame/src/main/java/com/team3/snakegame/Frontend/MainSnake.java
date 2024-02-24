package com.team3.snakegame.Frontend;


import javafx.application.Application;
import javafx.stage.Stage;

import java.io.IOException;

public class MainSnake extends Application {

    public static Stage stage;
    public static SceneSwitcher sceneSwitcher = new SceneSwitcher();
    @Override
    public void start(Stage primaryStage) throws IOException  {
        stage = primaryStage;
        sceneSwitcher.setMainMenuScene();
    }
    public static void main(String[] args) {
        launch(args);
    }
}


