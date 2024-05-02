package javapong.view;

import javapong.Config;

import javax.swing.*;
import java.awt.*;

public class Paddle extends JComponent {
    private Color color;
    public static final int LEFT = 0;
    public static final int RIGHT = 1;

    public Paddle() {
        setSize(Config.PADDLE_WIDTH, Config.PADDLE_HEIGHT);
    }
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(color);
        g.fillRect(0, 0, Config.PADDLE_WIDTH, Config.PADDLE_HEIGHT);
    }

    public void moveTo(int x, int y) {
        setLocation(x, y);
        revalidate();
    }

    public void setColor(Color color) {
        this.color = color;
        repaint();
    }

}
