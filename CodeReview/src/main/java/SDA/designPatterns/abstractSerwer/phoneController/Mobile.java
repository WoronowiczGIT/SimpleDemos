package SDA.designPatterns.abstractSerwer.phoneController;

public class Mobile {

    public void turnOn(MobilAble device){
        device.turnOn();
    }

    public void turnOff(MobilAble device){
        device.turnOn();
    }

    public static void main(String[] args) {
        Mobile m = new Mobile();
        MobilAble soundbar = new SoundBar();
        MobilAble tv = new Tv();

        m.turnOn(soundbar);
        m.turnOff(tv);


    }
}
