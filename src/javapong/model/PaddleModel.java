package javapong.model;

import javapong.Window;
import javapong.view.Paddle;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class PaddleModel {
    private int pos_y;
    private int pos_x;
    private Paddle view;

    public PaddleModel(int pos_x, Paddle view) {
        pos_y = 10;
        this.pos_x = pos_x;
        this.view = view;

        Window.get().addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyChar() == 'w') pos_y -= 10;
                if (e.getKeyChar() == 's') pos_y += 10;
                System.out.println(e.getKeyChar());
            }
        });
    }

    public void set_y(int y) {
        pos_y = y;
        view.modelChanged();
    }

    public int get_x() {
        return pos_x;
    }

    public int get_y() {
        return pos_y;
    }





}
