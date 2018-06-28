package ru.two4me.lessons;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Main extends Canvas implements ActionListener {

    public static final int WITH = 25;
    public static final int HEIGHT = 25;
    public static final int SCALE = 20;



    Snake snake = new Snake(5,6,5,5);
    Timer timer = new Timer(1000/snake.getSpeed(),this);
    Apple apple = new Apple(Math.abs((int) (Math.random()*WITH - 1)),Math.abs((int) (Math.random()*HEIGHT - 1)));

    public Main(){
        timer.start();
        addKeyListener(new KeyBoard());
        setFocusable(true);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Hello");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(WITH*SCALE+16, HEIGHT*SCALE-1);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);

        frame.add(new Main());

        frame.setVisible(true);

    }

    public void paint(Graphics g){
        g.setColor(Color.BLACK);
        g.fillRect(0,0,WITH*SCALE,HEIGHT*SCALE);

        for ( int x=0; x<WITH*SCALE; x+=SCALE){
            g.setColor(Color.BLACK);
            g.drawLine(x,0,x,HEIGHT*SCALE);
        }

        for ( int y=0; y<HEIGHT*SCALE; y+=SCALE){
            g.setColor(Color.BLACK);
            g.drawLine(0,y,WITH*SCALE,y);
        }

        g.setColor(Color.RED);
        g.fillOval(apple.getPositionX()*SCALE+3, apple.getPositionY()*SCALE+3, SCALE-6, SCALE-6);

        for (int l=0; l < snake.getLength(); l++){
            g.setColor(Color.BLUE);
            g.fillRect(snake.snakeX[l]*SCALE+3, snake.snakeY[l]*SCALE+3, SCALE-6, SCALE-6);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        snake.move();
        if ((snake.snakeX[0]== apple.getPositionX()) && (snake.snakeY[0]== apple.getPositionY())){
            apple.setRandomPosition();
            snake.length++;
        }

        for (int l = 1; l<snake.length; l++){
            if((snake.snakeX[l]==apple.getPositionX())&&(snake.snakeY[l]==apple.getPositionY())){
                apple.setRandomPosition();
            }
            if((snake.snakeX[0]==snake.snakeX[l])&&(snake.snakeY[0]==snake.snakeY[l])){
                timer.stop();
                JOptionPane.showMessageDialog(null, "You die, restart the game?");
                snake.length=2;
                snake.setDirection(0);
                apple.setRandomPosition();
                timer.start();
            }
        }
        repaint();
    }

    public class KeyBoard extends KeyAdapter{
        public void keyPressed (KeyEvent e){
            int key = e.getKeyCode();

            if ((key==KeyEvent.VK_UP) && (snake.getDirection() != 2)) snake.setDirection(0);
            if ((key==KeyEvent.VK_RIGHT) && (snake.getDirection() != 3)) snake.setDirection(1);
            if ((key==KeyEvent.VK_DOWN) && (snake.getDirection() != 0)) snake.setDirection(2);
            if ((key==KeyEvent.VK_LEFT) && (snake.getDirection() != 1)) snake.setDirection(3);

        }
    }
}
