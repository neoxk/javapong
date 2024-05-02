package javapong;

import javax.swing.*;
import java.awt.*;

public class Score extends JLabel {
    private int p1_score = 0;
    private int p2_score = 0;
    public Score() {
        setText(p1_score + "   " + p2_score);
        setFont(getFont().deriveFont(45.0f));
        setForeground(Color.WHITE);
        setBounds(Config.GAME_VIEW_WIDTH / 2 - 50, 10, 200, 50);
    }

    public void p1_increment() {
        p1_score++;
        setText(p1_score + "   " + p2_score);
    }

    public void p2_increment() {
        p2_score++;
        setText(p1_score + "   " + p2_score);
    }
}
