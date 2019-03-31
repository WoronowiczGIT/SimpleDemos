package SDA.SOLID.LiskovSubstitution;

import SDA.SOLID.LiskovSubstitution.CarsAndGears.AutomaticCar;
import SDA.SOLID.LiskovSubstitution.CarsAndGears.ManualCar;

public class Main {
    public static void main(String[] args) {
        AutomaticCar ac = new AutomaticCar();
        ManualCar mc = new ManualCar();

        ac.turnOnEngine();
        mc.turnOnEngine();






    }
}
