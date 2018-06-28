package ru.two4me.lessons;

public class Apple {
    private int positionX;
    private int positionY;

    public Apple(int x, int y){
        positionX = x;
        positionY = y;
    }

    public int getPositionY() {
        return positionY;
    }

    public int getPositionX() {
        return positionX;
    }

    public void setRandomPosition(){
        positionX = Math.abs((int) (Math.random()*Main.WITH - 3));
        positionY = Math.abs((int) (Math.random()*Main.HEIGHT - 3));
    }
}
