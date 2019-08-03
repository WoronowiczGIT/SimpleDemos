package project;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class App extends Application
{
    public static void main( String[] args )
    {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Stage window = primaryStage;
        Pane pane = new Pane();
        Label label = new Label("some text");

        pane.getChildren().addAll(label);
        Scene scene = new Scene(pane,200,200);


        window.setScene(scene);
        window.setTitle("Title");
        window.show();
    }
}
