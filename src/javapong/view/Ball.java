package javapong.view;

import javapong.Config;

import javax.swing.*;
import java.awt.*;

public class Ball extends JComponent {
    private int pos_x = Config.GAME_VIEW_WIDTH / 2 - Config.BALL_SIZE / 2;
    private int pos_y = Config.GAME_VIEW_HEIGHT / 2 - Config.BALL_SIZE / 2;
    private int dx = Config.BALL_SPEED;
    private int dy = Config.BALL_SPEED;

    public Ball() {
        setSize(Config.BALL_SIZE, Config.BALL_SIZE);
    }
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.decode(Config.BALL_COLOR));
        g.fillOval(0, 0, Config.BALL_SIZE, Config.BALL_SIZE);
    }

    public void bounceX() {
        dx = -dx;
    }

    public void bounceY() {
        dy = -dy;
    }

    public void move() {
        pos_x += dx;
        pos_y += dy;

        pos_x += dx;
        pos_y += dy;

        if (pos_x <= 0 || pos_x >= Config.GAME_VIEW_WIDTH - Config.BALL_SIZE) {
            dx = -dx + (int) (Math.random() * 2) - 1;
        }

        if (pos_y <= 0 ||
                pos_y >= Config.GAME_VIEW_HEIGHT - Config.BALL_SIZE
        ) {
            dy = -dy + (int) (Math.random() * 2) - 1;
        }

        setLocation(pos_x, pos_y);
        revalidate();
    }
}
