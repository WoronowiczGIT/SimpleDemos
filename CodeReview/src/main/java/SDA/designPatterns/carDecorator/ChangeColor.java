package SDA.designPatterns.carDecorator;

public class ChangeColor implements Car{
    private Car myCar;
    private String newColor;

    public ChangeColor(Car myCar, String newColor) {
        this.myCar = myCar;
        this.newColor = newColor;
    }

    @Override
    public String getDescription() {
        return myCar.getDescription();
    }

    @Override
    public int getWheelSize() {
        return myCar.getWheelSize();
    }

    @Override
    public String getColor() {
        return newColor;
    }

    @Override
    public boolean getSpoiler() {
        return myCar.getSpoiler();
    }
}
