package SDA.SOLID.LiskovSubstitution.CarsAndGears;

public class AutomaticCar implements Car {
   private Boolean isOn;
    private int speed;

    public Boolean getOn() {
        return isOn;
    }

    public int getSpeed() {
        return speed;
    }

    @Override
    public void turnOnEngine() {
        isOn = true;
    }

    @Override
    public void setSpeed(int speed) {
        this.speed = speed;
    }
}
