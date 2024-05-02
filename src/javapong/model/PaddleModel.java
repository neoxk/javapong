package javapong.model;

import javapong.Config;
import javapong.view.Paddle;

import java.awt.*;

public class PaddleModel {
    private Paddle paddle;
    private int pos_x;
    private int pos_y;

    public PaddleModel(int placement) {
        this.paddle = new Paddle();

       if (placement == Paddle.LEFT) {
           paddle.setColor(Color.decode(Config.P1_PADDLE_COLOR));
           pos_x = 10;
           pos_y = 10;
           paddle.moveTo(pos_x, pos_y);
       } else if (placement == Paddle.RIGHT) {
           paddle.setColor(Color.decode(Config.P2_PADDLE_COLOR));
           pos_x = Config.GAME_VIEW_WIDTH - Config.PADDLE_WIDTH - 10;
           pos_y = 10;
           paddle.moveTo(pos_x, pos_y);
       }
    }

    public Paddle getPaddle() {
        return paddle;
    }

    public void moveDown() {
        if (pos_y >= Config.GAME_VIEW_HEIGHT - Config.PADDLE_HEIGHT) return;

        pos_y = pos_y + Config.PADDLE_SPEED;
        paddle.moveTo(pos_x, pos_y);
    }

    public void moveUp() {
        if (pos_y <= 0) return;

        pos_y = pos_y - Config.PADDLE_SPEED;
        paddle.moveTo(pos_x, pos_y);
    }

}
