package javapong;

import javapong.view.GameView;

import javax.swing.*;
import java.awt.*;

public class Window extends JFrame {

    private static Window instance;

    public static Window get() {
       if (instance == null) {
           instance = new Window();
       }
        return instance;
    }

    private Window() {
        Container contentPane = this.getContentPane();

        contentPane.setLayout(new BorderLayout());
        setSize(Config.WINDOW_WIDTH, Config.WINDOW_HEIGHT);
        setTitle("Javapong");


        contentPane.add(BorderLayout.CENTER, new GameView());

        setVisible(true);
    }
}
