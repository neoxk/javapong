package javapong;

import javax.swing.*;
import java.awt.*;

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
