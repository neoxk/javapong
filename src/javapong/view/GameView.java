package javapong.view;

import javapong.Config;

import javax.swing.*;
import java.awt.*;

public class GameView extends JPanel {


    public GameView() {
       setBackground(Color.BLACK);
       setLayout(null);
       setSize(Config.GAME_VIEW_WIDTH, Config.GAME_VIEW_HEIGHT);

       Paddle paddle1 = new Paddle(Color.decode(Config.P1_PADDLE_COLOR), 10);
       Paddle paddle2 = new Paddle(Color.decode(Config.P2_PADDLE_COLOR), Config.GAME_VIEW_WIDTH - Config.PADDLE_WIDTH - 10);

       GameDivider gameDivider = new GameDivider();

       paddle1.setLocation(paddle1.getLocation());
       paddle2.setLocation(paddle2.getLocation());

       gameDivider.setLocation((Config.GAME_VIEW_WIDTH / 2) - (Config.PLAYER_DIVIDER_WIDTH / 2),0 );

       add(paddle1);
       add(paddle2);
       add(gameDivider);

        setVisible(true);
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
