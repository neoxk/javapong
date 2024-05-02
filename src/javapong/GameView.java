package javapong;

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

       Score score = new Score();


       gameDivider.setLocation((Config.GAME_VIEW_WIDTH / 2) - (Config.PLAYER_DIVIDER_WIDTH / 2),0 );

       add(paddle1);
       add(paddle2);
       add(ball);
       add(gameDivider);
       add(score);

       setVisible(true);

        GameController gameController = new GameController(window, ball, paddle1, paddle2, score);



         new Thread(gameController).start();


    }

}

