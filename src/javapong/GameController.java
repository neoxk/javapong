package javapong;

import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class GameController implements Runnable {
    private Ball ball;
    private Paddle paddle1;
    private Paddle paddle2;
    private JFrame window;
    private Score score;

    public GameController(JFrame window, Ball ball, Paddle paddle1, Paddle paddle2, Score score) {
        this.ball = ball;
        this.paddle1 = paddle1;
        this.paddle2 = paddle2;
        this.window = window;
        this.score = score;

        window.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_W) {
                    p1_moveUp();
                } else if (e.getKeyCode() == KeyEvent.VK_S) {
                    p1_moveDown();
                } else if (e.getKeyCode() == KeyEvent.VK_UP) {
                    p2_moveUp();
                } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                    p2_moveDown();
                }
            }
        });
    }

    public void newFrame() {
        ball.move();
        if (ball.getBounds().intersects(paddle1.getBounds()) || ball.getBounds().intersects(paddle2.getBounds())) {
            ball.bounceX();
        }
        else if (ball.getY() <= 0 || ball.getY() >= Config.GAME_VIEW_HEIGHT - Config.BALL_SIZE) {
            ball.bounceY();
        }
        else if (ball.getX() <= 0 ) {
            score.p2_increment();
            ball.reset();
        }
        else if (ball.getX() >= Config.GAME_VIEW_WIDTH - Config.BALL_SIZE) {
            score.p1_increment();
            ball.reset();
        }
    }


    public void p1_moveUp() {
        paddle1.moveUp();
        if (paddle1.getY() < 0) paddle1.moveDown();
    }
    public void p1_moveDown() {
        paddle1.moveDown();
        if (paddle1.getY() > Config.GAME_VIEW_HEIGHT - Config.PADDLE_HEIGHT) paddle1.moveUp();
    }
    public void p2_moveUp() {
        paddle2.moveUp();
        if (paddle2.getY() < 0) paddle2.moveDown();
    }
    public void p2_moveDown() {
        paddle2.moveDown();
        if (paddle2.getY() > Config.GAME_VIEW_HEIGHT - Config.PADDLE_HEIGHT) paddle2.moveUp();
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
