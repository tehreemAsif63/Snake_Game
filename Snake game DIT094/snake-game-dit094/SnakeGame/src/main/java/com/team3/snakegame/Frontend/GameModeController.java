package com.team3.snakegame.Frontend;

import java.io.IOException;

import static com.team3.snakegame.Frontend.MainSnake.sceneSwitcher;

public class GameModeController {

    public void backToMenu() throws IOException {
        sceneSwitcher.setMainMenuScene();
    }

    public void classicMode() {
        sceneSwitcher.setGameScene();
    }

    public void peacefulMode(){
        sceneSwitcher.setPeacefulMode();
    }
}
