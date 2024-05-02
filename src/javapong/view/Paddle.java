package javapong.view;

import javapong.Config;

import javax.swing.*;
import java.awt.*;

public class Paddle extends JComponent {
    private Color color;
    public static final int LEFT = 0;
    public static final int RIGHT = 1;
    private int pos_x;
    private int pos_y;

    public static Paddle get(int type) {
        if (type == LEFT) return new Paddle(10, 10, Color.decode(Config.P1_PADDLE_COLOR));
        else return new Paddle(Config.GAME_VIEW_WIDTH - Config.PADDLE_WIDTH - 10, 10, Color.decode(Config.P2_PADDLE_COLOR));
    }

    private Paddle(int x, int y, Color color) {
        setSize(Config.PADDLE_WIDTH, Config.PADDLE_HEIGHT);
        setLocation(x, y);
        pos_x = x;
        pos_y = y;
        this.color = color;
    }
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(color);
        g.fillRect(0, 0, Config.PADDLE_WIDTH, Config.PADDLE_HEIGHT);
    }

    public void moveUp() {
        if (pos_y <= 0) return;

        pos_y = pos_y - Config.PADDLE_SPEED;
        setLocation(pos_x, pos_y);
        revalidate();
    }

    public void moveDown() {
        if (pos_y >= Config.GAME_VIEW_HEIGHT - Config.PADDLE_HEIGHT) return;

        pos_y = pos_y + Config.PADDLE_SPEED;
        setLocation(pos_x, pos_y);
        revalidate();
    }

}
