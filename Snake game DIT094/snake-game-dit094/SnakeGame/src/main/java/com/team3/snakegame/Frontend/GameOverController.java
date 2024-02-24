package com.team3.snakegame.Frontend;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static com.team3.snakegame.Frontend.MainSnake.sceneSwitcher;


public class GameOverController implements Initializable {
    @FXML
    Label scoreLabel;


    public void playAgain(){
        sceneSwitcher.setGameScene();

    }

    public void backToMenu() throws IOException {
        sceneSwitcher.setMainMenuScene();

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        String x = String.valueOf(sceneSwitcher.getGameGrid().getScore());

        scoreLabel.setText(x);
    }

    public void customize() throws IOException {
        sceneSwitcher.setCustomizeSceneScene();
    }

}
