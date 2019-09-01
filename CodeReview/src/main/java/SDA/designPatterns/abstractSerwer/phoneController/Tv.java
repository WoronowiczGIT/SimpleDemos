package SDA.designPatterns.abstractSerwer.phoneController;

public class Tv implements MobilAble {

    @Override
    public void turnOff() {
        System.out.println("Tv OFF");
    }

    @Override
    public void turnOn() {
        System.out.println("Tv ON");

    }
}
