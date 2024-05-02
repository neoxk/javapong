package javapong;

import javapong.Config;

import javax.swing.*;
import java.awt.*;

class GameDivider extends JComponent {
    private final int SPACING = 20;
    private final int NUM_LINES = 15;

    public GameDivider() {
        setSize(20, Config.GAME_VIEW_HEIGHT);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.decode(Config.PLAYER_DIVIDER_COLOR));

        int line_height = (Config.GAME_VIEW_HEIGHT - ((NUM_LINES - 1) * SPACING)) / NUM_LINES;

        int y_pointer = 0;
        for (int i = 0; i < NUM_LINES; i++) {
            g.fillRect(0, y_pointer, Config.PLAYER_DIVIDER_WIDTH, line_height);
            y_pointer += line_height + SPACING;
        }

    }
}
