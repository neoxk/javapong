package javapong;

import javapong.Config;

import javax.swing.*;
import java.awt.*;

public class Ball extends JComponent {
    private int pos_x = Config.GAME_VIEW_WIDTH / 2 - Config.BALL_SIZE / 2;
    private int pos_y = Config.GAME_VIEW_HEIGHT / 2 - Config.BALL_SIZE / 2;
    private double dx = Config.BALL_SPEED;
    private double dy = Config.BALL_SPEED;

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

        setLocation(pos_x, pos_y);
        revalidate();
    }

    public void reset() {
        pos_x = Config.GAME_VIEW_WIDTH / 2 - Config.BALL_SIZE / 2;
        pos_y = Config.GAME_VIEW_HEIGHT / 2 - Config.BALL_SIZE / 2;
        dx = Config.BALL_SPEED;
        dy = Config.BALL_SPEED;
        setLocation(pos_x, pos_y);
        revalidate();
    }
}
