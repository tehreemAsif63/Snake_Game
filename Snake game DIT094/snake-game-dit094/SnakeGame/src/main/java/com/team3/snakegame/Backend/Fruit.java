package com.team3.snakegame.Backend;

import javafx.scene.image.Image;

import java.util.Random;

public class Fruit {
    private final int row;
    private final int column;
    private final Image type;

    static final Image fruitImage1 = new Image("1.png");
    static final Image fruitImage2 = new Image("2.png");
    static final Image fruitImage3 = new Image("3.png");
    static final Image fruitImage4 = new Image("4.png");
    static final Image fruitImage5 = new Image("5.png");
    static final Image fruitImage6 = new Image("6.png");
    static final Image fruitImage7 = new Image("7.png");
    static final Image fruitImage8 = new Image("8.png");
    static final Image fruitImage9 = new Image("9.png");

    Fruit(int row, int column, Image type){
        this.row = row;
        this.column = column;
        this.type = type;
    }

    public static Image randomFruitType(){
        Image[] fruits = new Image [] {fruitImage1,fruitImage2, fruitImage3, fruitImage4, fruitImage5, fruitImage6, fruitImage7, fruitImage8, fruitImage9};
        Random rand = new Random();
        return fruits[rand.nextInt(fruits.length)];
    }
    // Takes an array of the different fruit types and randomizes an index to be returned.
    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    public Image getType(){ return type; }
}
