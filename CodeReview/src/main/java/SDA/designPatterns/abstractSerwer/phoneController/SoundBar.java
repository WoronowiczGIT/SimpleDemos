package SDA.designPatterns.abstractSerwer.phoneController;

public class SoundBar implements MobilAble {

    @Override
    public void turnOff() {
        System.out.println("Soundbar OFF");
    }

    @Override
    public void turnOn() {
        System.out.println("Soundbar ON");

    }
}
