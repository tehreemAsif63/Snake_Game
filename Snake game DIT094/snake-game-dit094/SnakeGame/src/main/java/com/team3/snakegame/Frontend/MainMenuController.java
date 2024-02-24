package com.team3.snakegame.Frontend;


import java.io.IOException;
import static com.team3.snakegame.Frontend.MainSnake.sceneSwitcher;

public class MainMenuController {


    public void play() throws IOException {
        sceneSwitcher.setGameModeScene();
    }

    public void customize() throws IOException {
        sceneSwitcher.setCustomizeSceneScene();
    }

    public void leaderboard() throws IOException {
        sceneSwitcher.setScoreboardScene();
    }

    public void exit(){
        System.exit(0);
    }

}
