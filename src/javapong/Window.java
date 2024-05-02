package javapong;

import javapong.view.GameView;

import javax.swing.*;
import java.awt.*;

public class Window extends JFrame {
    public Window() {
        setLayout(new BorderLayout());
        setSize(Config.WINDOW_WIDTH, Config.WINDOW_HEIGHT);
        setTitle("Javapong");

        add(BorderLayout.CENTER, new GameView());

        setVisible(true);
    }
}
