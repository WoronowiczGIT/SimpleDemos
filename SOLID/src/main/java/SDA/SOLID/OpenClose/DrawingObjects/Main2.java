package SDA.SOLID.OpenClose.DrawingObjects;

import javafx.scene.shape.Rectangle;

public class Main2 {
    public static void main(String[] args) {
        GraphicEditor ge = new GraphicEditor(new Rectangle());

        ge.draw(new DrawCircle());
    }
}
