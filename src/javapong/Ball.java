package javapong;

import javapong.Config;

import javax.swing.*;
import java.awt.*;

public class Ball extends JComponent {
    private int pos_x = Config.GAME_VIEW_WIDTH / 2 - Config.BALL_SIZE / 2;
    private int pos_y = Config.GAME_VIEW_HEIGHT / 2 - Config.BALL_SIZE / 2;
    private double dx;
    private double dy;

    public Ball() {
        setSize(Config.BALL_SIZE, Config.BALL_SIZE);
        dx = Math.random() * 2 - 1;
        dy = Math.sqrt(Math.pow(Config.BALL_SPEED, 2) - Math.pow(dx, 2));
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.decode(Config.BALL_COLOR));
        g.fillOval(0, 0, Config.BALL_SIZE, Config.BALL_SIZE);
    }

    public void bounceX() {
        dx = -dx;
        dy = dy + Math.random() * 0.01 - 0.005;
    }

    public void bounceY() {
        dy = -dy;
        dx = dx + Math.random() * 0.01 - 0.005;
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
