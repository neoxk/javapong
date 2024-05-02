package javapong.view;

import javapong.Config;

import javax.swing.*;
import java.awt.*;

public class Paddle extends JComponent {
    private Color color;

    public Paddle(Color color) {
        setSize(Config.PADDLE_WIDTH, Config.PADDLE_HEIGHT);
        this.color = color;
    }
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(color);
        g.fillRect(0, 0, Config.PADDLE_WIDTH, Config.PADDLE_HEIGHT);
    }
}
