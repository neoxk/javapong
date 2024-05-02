package javapong;

import javapong.view.Ball;
import javapong.view.Paddle;

public class GameController implements Runnable {
    private Ball ball;
    private Paddle paddle1;
    private Paddle paddle2;

    public GameController(Ball ball, Paddle paddle1, Paddle paddle2) {
        this.ball = ball;
        this.paddle1 = paddle1;
        this.paddle2 = paddle2;
    }

    public void newFrame() {
        ball.move();
        if (ball.getBounds().intersects(paddle1.getBounds()) || ball.getBounds().intersects(paddle2.getBounds())) {
            ball.bounceX();
        }
        else if (ball.getY() <= 0 || ball.getY() >= Config.GAME_VIEW_HEIGHT - Config.BALL_SIZE) {
            ball.bounceY();
        }
        else if (ball.getX() <= 0 || ball.getX() >= Config.GAME_VIEW_WIDTH - Config.BALL_SIZE) {
            ball.bounceX();
        }
    }

    public void p1_moveUp() {
        paddle1.moveUp();
    }
    public void p1_moveDown() {
        paddle1.moveDown();
    }
    public void p2_moveUp() {
        paddle2.moveUp();
    }
    public void p2_moveDown() {
        paddle2.moveDown();
    }

    @Override
    public void run() {
        while (true) {
            newFrame();
            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
