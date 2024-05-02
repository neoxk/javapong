package javapong;

import javapong.view.GameView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Window extends JFrame {

    public Window() {
        Container contentPane = this.getContentPane();

        contentPane.setLayout(new BorderLayout());
        setSize(Config.WINDOW_WIDTH, Config.WINDOW_HEIGHT);
        setTitle("Javapong");


        contentPane.add(BorderLayout.CENTER, new GameView(this));

        setVisible(true);


    }
}
