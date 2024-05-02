package javapong.view;

import javapong.Config;
import javapong.model.PaddleModel;

import javax.swing.*;
import java.awt.*;

public class Paddle extends JComponent {
    private Color color;
    private PaddleModel model;

    public Paddle(Color color, int pos_x) {
        model = new PaddleModel(pos_x, this);
        setSize(Config.PADDLE_WIDTH, Config.PADDLE_HEIGHT);
        this.color = color;
    }
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(color);
        g.fillRect(0, model.get_y(), Config.PADDLE_WIDTH, Config.PADDLE_HEIGHT);
    }

    public void modelChanged() {
        repaint();
    }

    public Point getLocation() {
        return new Point(model.get_x(), model.get_y());
    }
}
