package javapong.view;

import javapong.Config;
import javapong.model.PaddleModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class GameView extends JPanel {


    public GameView(JFrame window) {
       setBackground(Color.BLACK);
       setLayout(null);
       setSize(Config.GAME_VIEW_WIDTH, Config.GAME_VIEW_HEIGHT);

        PaddleModel paddle1 = new PaddleModel(Paddle.LEFT);
        PaddleModel paddle2 = new PaddleModel(Paddle.RIGHT);

        Ball ball = new Ball();

       GameDivider gameDivider = new GameDivider();

       gameDivider.setLocation((Config.GAME_VIEW_WIDTH / 2) - (Config.PLAYER_DIVIDER_WIDTH / 2),0 );

       add(paddle1.getPaddle());
       add(paddle2.getPaddle());
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

class GameDivider extends JComponent {
    private final int SPACING = 40;
    private final int NUM_LINES = 10;

    public GameDivider() {
        setSize(20, Config.GAME_VIEW_HEIGHT);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.decode(Config.PLAYER_DIVIDER_COLOR));

        int line_height = (Config.GAME_VIEW_HEIGHT - ((NUM_LINES - 1) * SPACING)) / NUM_LINES;

        int y_pointer = 0;
        for (int i = 0; i < NUM_LINES; i++) {
            g.fillRect(0, y_pointer, Config.PLAYER_DIVIDER_WIDTH, line_height);
            y_pointer += line_height + SPACING;
        }

    }
}
