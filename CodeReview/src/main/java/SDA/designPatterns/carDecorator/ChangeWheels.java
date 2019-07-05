package SDA.designPatterns.carDecorator;

public class ChangeWheels implements Car {
    private Car myCar;
    private int newWheelSize;
    public ChangeWheels(Car myCar, int wheelSize) {
        this.myCar = myCar;
        newWheelSize = wheelSize;
    }

    @Override
    public String getDescription() {
        return myCar.getDescription();
    }

    @Override
    public int getWheelSize() {
        return newWheelSize;
    }

    @Override
    public String getColor() {
        return myCar.getColor();
    }

    @Override
    public boolean getSpoiler() {
        return myCar.getSpoiler();
    }
}
