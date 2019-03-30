package SDA.SOLID.OpenClose.DrawingObjects;

import javafx.scene.shape.Shape;

public class GraphicEditor implements DrawShape{

    private Graphics shape;

    GraphicEditor(Graphics shape) {
        this.shape = shape;
    }

    public Graphics getShape() {
        return shape;
    }

    public void draw(Graphics Shape){

    }
}
