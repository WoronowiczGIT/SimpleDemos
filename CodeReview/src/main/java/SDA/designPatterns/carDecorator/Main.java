package SDA.designPatterns.carDecorator;

public class Main {

    public static void main(String[] args) {
        Car firstCar = new Chevrolet("Equinox");

        System.out.println(firstCar.getDescription()
                +"\n"+firstCar.getColor()
                +"\n"+firstCar.getWheelSize()
                +"\n"+firstCar.getSpoiler());

        System.out.println("-- tune car --");

        Car paintedCar = new ChangeColor(firstCar,"blue");
        Car bigWheelsCar = new ChangeWheels(paintedCar,22);
        Car spoiledCar = new ChangeSpoiler(bigWheelsCar,true);

        System.out.println(spoiledCar.getDescription()
                +"\n"+spoiledCar.getColor()
                +"\n"+spoiledCar.getWheelSize()
                +"\n"+spoiledCar.getSpoiler());
    }
}
