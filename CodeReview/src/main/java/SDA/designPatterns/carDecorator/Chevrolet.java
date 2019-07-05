package SDA.designPatterns.carDecorator;

public class Chevrolet implements Car{
    private String name = "Chevrolet";
    private int wheelSize = 15;
    private boolean hasSpoiler = false;
    private String color = "red";

    Chevrolet(String model){
        name += " "+model;
    }

    @Override
    public String getDescription() {
        return name;
    }

    @Override
    public int getWheelSize() {
        return wheelSize;
    }

    @Override
    public String getColor() {
        return color;
    }

    @Override
    public boolean getSpoiler() {
        return hasSpoiler;
    }
}
