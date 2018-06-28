package ru.two4me.lessons;

public class Snake {

    public int length = 2;
    private int direction = 0;
    private int speed = 4;
    public int snakeX[] = new int[100];
    public int snakeY[] = new int[100];

    public Snake(int x, int y, int x1, int y1){
        snakeX[0] = x;
        snakeY[0] = y;
        snakeX[1] = x1;
        snakeY[1] = y1;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getSpeed() {
        return speed;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }

    public int getDirection() {
        return direction;
    }

    public void move(){

        for (int l = length; l>0; l--){
            snakeX[l] = snakeX[l-1];
            snakeY[l] = snakeY[l-1];
        }

        //up
        if (direction == 0){
            snakeY[0]--;
        }
        //right
        if (direction == 1){
            snakeX[0]++;
        }
        //down
        if (direction == 2){
            snakeY[0]++;
        }
        //left
        if (direction == 3){
            snakeX[0]--;
        }

        if (snakeX[0] > Main.WITH -1) snakeX[0] = 0;
        if (snakeX[0] < 0) snakeX[0] = Main.WITH-1;

        if (snakeY[0] > Main.HEIGHT -3) snakeY[0] = 0;
        if (snakeY[0] < 0) snakeY[0] = Main.HEIGHT -3;
    }
}
