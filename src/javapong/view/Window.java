package javapong.view;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Window extends Application {

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage) {
        Paddle paddle1 = new Paddle(0, 0);
        Paddle paddle2 = new Paddle(1000-50, 0);
        
        Scene scene = new Scene(new Pane(paddle1, paddle2), 1000, 600);


        stage.setScene(scene);
        stage.show();
    }
}
