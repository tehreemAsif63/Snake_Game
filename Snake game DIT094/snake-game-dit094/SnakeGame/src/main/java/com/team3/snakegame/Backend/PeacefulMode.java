package com.team3.snakegame.Backend;

public class PeacefulMode extends GameGrid {
    public PeacefulMode(int height, int width, int squareNumber) {
        super(height, width, squareNumber);
    }

    @Override
    public boolean gameOver() {
        //When the snake runs into the horizontal wall it will get generated on the opposite1
        //horizontal wall and vice versa with the vertical wall.
        for (int i = 0; i < getSnake().getSnakeBody().size(); i++) {
            if (getSnake().getSnakeBody().get(0).getX() == getWidth() * getSquareNumber()+getWidth()) {
                getSnake().getSnakeBody().get(i).setX(0);
            }
            else if (getSnake().getSnakeBody().get(0).getX() == -getWidth()) {
                getSnake().getSnakeBody().get(i).setX(getWidth() * getSquareNumber());
            }
            if ((getSnake().getSnakeBody().get(0).getY() == getHeight() * getSquareNumber()+getHeight())){
                getSnake().getSnakeBody().get(i).setY(0);
            }
            else if(getSnake().getSnakeBody().get(0).getY() == -getHeight()){
                getSnake().getSnakeBody().get(i).setY(getHeight() * getSquareNumber());
            }
        }
        return false;
    }

    public boolean checkSnakePos(){
        return !(getSnake().getSnakeBody().get(0).getX() < 600) ||
                !(getSnake().getSnakeBody().get(0).getX() > -1) ||
                !(getSnake().getSnakeBody().get(0).getY() < 600) ||
                !(getSnake().getSnakeBody().get(0).getY() > -1);
    }

    public void up(){
        if (getLastOrientation() != Orientation.DOWN && !checkSnakePos()){
            getSnake().setOrientation(Orientation.UP);
        }
    }
    public void down(){
        if (getLastOrientation() != Orientation.UP && !checkSnakePos() ){
            getSnake().setOrientation(Orientation.DOWN);
        }
    }
    public void left(){
        if (getLastOrientation()!= Orientation.RIGHT && !checkSnakePos()){
            getSnake().setOrientation(Orientation.LEFT);
        }
    }
    public void right(){
        if (getLastOrientation() != Orientation.LEFT && !checkSnakePos() ){
            getSnake().setOrientation(Orientation.RIGHT);
        }
    }

}
