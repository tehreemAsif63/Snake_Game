package com.team3.snakegame.Frontend;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static com.team3.snakegame.Frontend.MainSnake.sceneSwitcher;

public class PauseMenuController implements Initializable {
    @FXML Label scoreLabel;
    @FXML private javafx.scene.control.Button backToMenu;
    //Referencing the button in the pauseMenu.

    private void closeScene() {
        Stage pauseMenu = (Stage) backToMenu.getScene().getWindow();
        pauseMenu.close();
    }
    //Inspiration from: https://stackoverflow.com/questions/13567019/close-fxml-window-by-code-javafx
    public void backToMenu() throws IOException {
        closeScene();
        //When you press the button to go to mainMenu you close the previous scenes instead of hiding them.
        sceneSwitcher.setMainMenuScene();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        String x = String.valueOf(sceneSwitcher.getPeacefulMode().getScore());
        //Score counter for the peacefulMode.
        scoreLabel.setText(x);
        //Updates the score label with each fruit eaten.
    }
}


