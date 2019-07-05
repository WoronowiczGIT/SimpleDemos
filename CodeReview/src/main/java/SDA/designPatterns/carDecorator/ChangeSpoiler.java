package SDA.designPatterns.carDecorator;

public class ChangeSpoiler implements Car{
    private Car myCar;
    private boolean hasSpoiler;

    public ChangeSpoiler(Car myCar, boolean hasSpoiler) {
        this.myCar = myCar;
        this.hasSpoiler = hasSpoiler;
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
        return myCar.getColor();
    }

    @Override
    public boolean getSpoiler() {
        return hasSpoiler;
    }
}
