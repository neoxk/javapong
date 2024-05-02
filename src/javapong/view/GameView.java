package javapong.view;

import javapong.Config;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class GameView extends JPanel {


    public GameView(JFrame window) {
       setBackground(Color.BLACK);
       setLayout(null);
       setSize(Config.GAME_VIEW_WIDTH, Config.GAME_VIEW_HEIGHT);

        Paddle paddle1 = Paddle.get(Paddle.LEFT);
        Paddle paddle2 = Paddle.get(Paddle.RIGHT);

        Ball ball = new Ball();

       GameDivider gameDivider = new GameDivider();

       gameDivider.setLocation((Config.GAME_VIEW_WIDTH / 2) - (Config.PLAYER_DIVIDER_WIDTH / 2),0 );

       add(paddle1);
       add(paddle2);
       add(ball);
       add(gameDivider);

       setVisible(true);

         window.addKeyListener(new KeyAdapter() {
              @Override
              public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_W) {
                     paddle1.moveUp();
                } else if (e.getKeyCode() == KeyEvent.VK_S) {
                     paddle1.moveDown();
                } else if (e.getKeyCode() == KeyEvent.VK_UP) {
                     paddle2.moveUp();
                } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                     paddle2.moveDown();
                }
              }
         });

         new Thread(() -> {
             while (true) {
                 ball.newFrame();
                 try {
                     Thread.sleep(20);
                 } catch (InterruptedException e) {
                     e.printStackTrace();
                 }
             }
         }).start();


    }

}

