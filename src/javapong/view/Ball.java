package javapong.view;

import javapong.Config;

import javax.swing.*;
import java.awt.*;

public class Ball extends JComponent {
    public Ball() {
        setSize(Config.BALL_SIZE, Config.BALL_SIZE);
    }
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.decode(Config.BALL_COLOR));
        g.fillOval(0, 0, Config.BALL_SIZE, Config.BALL_SIZE);
    }

    public void moveTo(int x, int y) {
        setLocation(x, y);
        revalidate();
    }
}
