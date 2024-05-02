package javapong.model;

import javapong.Config;
import javapong.view.Ball;

public class BallModel {
    private int pos_x = Config.GAME_VIEW_WIDTH / 2 - Config.BALL_SIZE / 2;
    private int pos_y = Config.GAME_VIEW_HEIGHT / 2 - Config.BALL_SIZE / 2;
    private int dx = Config.BALL_SPEED;
    private int dy = Config.BALL_SPEED;
    private Ball ball;

    public BallModel() {
        this.ball = new Ball();
        ball.moveTo(pos_x, pos_y);
    }

    public Ball getBall() {
        return ball;
    }

    public void newFrame() {
        pos_x += dx;
        pos_y += dy;

        if (pos_x <= 0 || pos_x >= Config.GAME_VIEW_WIDTH - Config.BALL_SIZE) {
            dx = -dx + (int) (Math.random() * 2) - 1;
        }

        if (pos_y <= 0 ||
                pos_y >= Config.GAME_VIEW_HEIGHT - Config.BALL_SIZE
        ) {
            dy = -dy + (int) (Math.random() * 2) - 1;
        }

        ball.moveTo(pos_x, pos_y);
    }
}
