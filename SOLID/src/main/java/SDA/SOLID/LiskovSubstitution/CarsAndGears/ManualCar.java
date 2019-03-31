package SDA.SOLID.LiskovSubstitution.CarsAndGears;

import SDA.SOLID.LiskovSubstitution.CarsAndGears.Car;
import SDA.SOLID.LiskovSubstitution.CarsAndGears.GearBox;

public class ManualCar implements Car, GearBox {
    private Boolean isOn;
    private int speed;
    private  int gear;


    @Override
    public void turnOnEngine() {
        isOn = true;
    }

    @Override
    public void setSpeed(int speed) {
        this.speed = speed;
    }

    @Override
    public void changeGear(int gear) {
        this.gear = gear;
    }



    public Boolean getOn() {
        return isOn;
    }

    public int getSpeed() {
        return speed;
    }

    public int getGear() {
        return gear;
    }
}
