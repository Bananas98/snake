import com.sun.tools.javac.Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public  class SnakeGame extends JPanel implements ActionListener {
     public static JFrame f;
     public static final int SCALE = 32;
     public static final int WIDTH = 20;
     public static final int HEIGHT = 20;
     public static  int speed = 10;

     Snake snake = new Snake(5,6,5,5);
     Apple apple = new Apple( Math.abs((int) (Math.random() * SnakeGame.WIDTH-1)),Math.abs((int) (Math.random() * SnakeGame.HEIGHT-1)));
     Timer timer = new Timer(1000/speed,this);


     public SnakeGame(){
        timer.start();
        addKeyListener(new KeyBoard());
         setFocusable(true);
     }
     public void paint(Graphics g){
         g.setColor(Color.black);
         g.fillRect(0,0,WIDTH * SCALE,HEIGHT*SCALE);


         for (int x = 0;  x  < WIDTH*SCALE; x+= SCALE){
             g.setColor(Color.black);
             g.drawLine(x,0,x,HEIGHT*SCALE);
         }
         for (int y = 0; y  < WIDTH*SCALE; y+= SCALE){
             g.setColor(Color.black);
             g.drawLine(0,y,WIDTH*SCALE,y);
         }
         g.setColor(Color.red);
         g.fillRect(apple.posX * SCALE+1, apple.posY * SCALE+1,SCALE-1,SCALE-1);

         for (int l  = 0; l < snake.length; l++){
             g.setColor(Color.green);
             g.fillRect(snake.sX[l]*SCALE+1,snake.sY[l]*SCALE+1,SCALE-1,SCALE -1);
             g.setColor(Color.white);
             g.fillRect(snake.sX[0]*SCALE+1,snake.sY[0]*SCALE+1,SCALE-1,SCALE -1);
         }
     }

    public static void main(String[] args) {
        f  = new JFrame("Snake");
        f.setSize(WIDTH * SCALE+15,HEIGHT*SCALE+8);
        f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        f.setResizable(false);
        f.setLocationRelativeTo(null);
        f.add(new SnakeGame());
        f.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
         snake.move();
         if ((snake.sX[0] == apple.posX)&&(snake.sY[0] == apple.posY)){
             apple.setRandomPosition();
             snake.length++;
         }
        for (int l  = 1; l < snake.length; l++){
            if((snake.sX[l] == apple.posX)&&(snake.sY[l] == apple.posY)){
                apple.setRandomPosition();
            }
            if((snake.sX[0] == snake.sX[l])&&(snake.sY[0] == snake.sY[l])){
                timer.stop();
                JOptionPane.showMessageDialog(null, "you lose");
                f.setVisible(false);
                snake.length = 2;
                snake.direction = 0;
                apple.setRandomPosition();
                f.setVisible(true);
                timer.start();
            }
        }
        repaint();
    }
    class KeyBoard extends KeyAdapter{
         public void keyPressed(KeyEvent event){
             int key  = event.getKeyCode();

             if ((key == KeyEvent.VK_UP) && (snake.direction != 1)){
                 snake.direction = 0;
             }
             if ((key == KeyEvent.VK_DOWN) && (snake.direction != 0)){
                 snake.direction = 1;
             }
             if ((key == KeyEvent.VK_RIGHT) && (snake.direction != 3)){
                 snake.direction = 2;
             }
             if ((key == KeyEvent.VK_LEFT) && (snake.direction != 2)){
                 snake.direction = 3;
             }
         }
    }
}