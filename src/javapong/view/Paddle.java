package javapong.view;

import javafx.scene.Parent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;


public class Paddle extends Rectangle {
    public Paddle(int posX, int posY) {
        super(posX, posY, 40, 150);

        setFill(Color.RED);
    }


}
