package SDA.SOLID.OpenClose.DrawingObjects;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Shape;
import javafx.stage.Stage;

public class Main extends Application {
    public static void main(String[] args) { launch(args);}

    @Override
    public void start(Stage primaryStage) throws Exception {
        Pane root = new Pane();
        Scene scene = new Scene(root,500,500);

        GraphicEditor ge = new GraphicEditor(new Circle());

        DrawCircle dc = new DrawCircle();









        root.getChildren().addAll(ge.getShape());
        primaryStage.setScene(scene);
        primaryStage.show();



    }
}
