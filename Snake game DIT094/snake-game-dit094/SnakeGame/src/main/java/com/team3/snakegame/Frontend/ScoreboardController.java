package com.team3.snakegame.Frontend;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.io.*;
import java.net.URL;
import java.util.*;


import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import static com.team3.snakegame.Frontend.MainSnake.sceneSwitcher;

public class ScoreboardController implements Initializable {
    @FXML
    private Label firstScoreLabel;

    @FXML
    private Label secondScoreLabel;

    @FXML
    private Label thirdScoreLabel;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        int firstScore = 0;
        int secondScore = 0;
        int thirdScore = 0;

        ClassLoader classLoader = getClass().getClassLoader();
        URL url = classLoader.getResource("scores.json");
        assert url != null;
        File file = new File(url.getFile());

        try(BufferedReader reader = new BufferedReader(new FileReader(file))){
            //get the elements of the json file using gson library and convert them to a list with all the scores
            JsonElement jsonElement = new JsonParser().parse(reader);
            JsonObject jsonObject = jsonElement.getAsJsonObject();
            JsonArray scores = jsonObject.getAsJsonArray("scores");

            //create a new arraylist of integers to be able to sort the scores
            ArrayList<Integer> scoresInt = new ArrayList<>();
            for(int i = 0;i<scores.size(); i++){
                scoresInt.add(scores.get(i).getAsInt());
            }

            scoresInt.sort(Collections.reverseOrder());


            firstScore = scoresInt.get(0);
            secondScore = scoresInt.get(1);
            thirdScore = scoresInt.get(2);

        }catch (IOException e ){
            e.printStackTrace();
        }

        firstScoreLabel.setText(String.valueOf(firstScore));
        secondScoreLabel.setText(String.valueOf(secondScore));
        thirdScoreLabel.setText(String.valueOf(thirdScore));

    }

    public void back() throws IOException {
        sceneSwitcher.setMainMenuScene();
    }


}






