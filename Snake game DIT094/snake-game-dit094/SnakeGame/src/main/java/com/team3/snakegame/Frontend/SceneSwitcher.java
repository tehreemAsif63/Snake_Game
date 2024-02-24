package com.team3.snakegame.Frontend;

import com.team3.snakegame.Backend.GameGrid;
import com.team3.snakegame.Backend.PeacefulMode;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import java.io.IOException;
import java.net.URL;

import static com.team3.snakegame.Frontend.MainSnake.stage;

public class SceneSwitcher {
    private GameGrid gameGrid;
    private final PeacefulMode peacefulMode;

    public SceneSwitcher(){
        this.peacefulMode = new PeacefulMode(30,30,20);
    }
    private Animation animation;

    public void setCustomizeSceneScene() throws IOException {
        URL fxmlResource = getClass().getResource("/CustomizeScene.fxml");
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(fxmlResource);
        Parent root = loader.load();
        Scene CustomizeScene = new Scene(root);
        stage.setScene(CustomizeScene);
    }


    public void setGameOverScene() throws IOException {
        URL fxmlResource = getClass().getResource("/GameOverScene.fxml");
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(fxmlResource);
        Parent root = loader.load();
        Scene gameOverScene = new Scene(root);
        stage.setScene(gameOverScene);
    }
    public void setMainMenuScene() throws IOException {

        URL fxmlResource = getClass().getResource("/MainMenu.fxml");
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(fxmlResource);
        Parent root = loader.load();
        Scene scene = new Scene(root);


        stage.setTitle("Snake Game");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    public void setGameModeScene() throws IOException {
        URL fxmlResource = getClass().getResource("/GameModeScene.fxml");
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(fxmlResource);
        // Finds where the fxml file is located, so it can load the scene builder's information
        Parent root = loader.load();
        // The root is the first scene's contents
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        // Displays the stage's content
    }
    public void setGameScene(){
        Canvas canvas = new Canvas(600,600);
        GraphicsContext gC = canvas.getGraphicsContext2D();
        Group group = new Group();
        group.getChildren().add(canvas);

        Scene gameScene = new Scene(group,600,600);
        stage.setScene(gameScene);

        gameGrid = new GameGrid(30,30,20);
        animation = new Animation(gameGrid,gC);
        gameScene.setOnKeyPressed(event -> {
            if(animation.isPressed()){
                return;
            }
            switch (event.getCode()){
                case LEFT -> gameGrid.left();
                case RIGHT -> gameGrid.right();
                case DOWN -> gameGrid.down();
                case UP -> gameGrid.up();
            }
            animation.setPressed();
        });

        animation = new Animation(gameGrid,gC);
        Thread thread = new Thread(animation);
        thread.start();
        stage.show();
    }

    public void setPeacefulMode(){
        Canvas canvas = new Canvas(600,600);
        GraphicsContext gC = canvas.getGraphicsContext2D();
        Group group = new Group();
        group.getChildren().add(canvas);

        Scene gameScene = new Scene(group,600,600);
        stage.setScene(gameScene);

        animation = new Animation(peacefulMode,gC);
        gameScene.setOnKeyPressed(event -> {
            if(animation.isPressed()){
                return;
            }
            switch (event.getCode()){
                case LEFT -> peacefulMode.left();
                case RIGHT -> peacefulMode.right();
                case DOWN -> peacefulMode.down();
                case UP -> peacefulMode.up();
                case ESCAPE -> {
                    try {
                        setPauseMenu();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
            animation.setPressed();
        });

        Thread thread = new Thread(animation);
        thread.start();
        stage.show();
    }


    public void setPauseMenu() throws IOException {
        URL fxmlResource = getClass().getResource("/PauseMenu.fxml");
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(fxmlResource);
        Parent parent = loader.load();
        Scene pauseMenuScene = new Scene(parent);
        stage.setScene(pauseMenuScene);
        animation.pause();

        pauseMenuScene.setOnKeyPressed(event -> {
            if (KeyCode.ESCAPE == event.getCode()) {
                animation.resume();
                setPeacefulMode();
            }
        });
    }


    public void setScoreboardScene() throws IOException{
        URL fxmlResource = getClass().getResource("/scoreboard.fxml");
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(fxmlResource);
        Parent root = loader.load();
        Scene scoreboardScene = new Scene(root);
        stage.setScene(scoreboardScene);
    }

    public GameGrid getGameGrid() {
        return gameGrid;
    }

    public PeacefulMode getPeacefulMode() {
        return peacefulMode;
    }
}
