package SDA.SOLID.DependencyInversion.UniversalRemote;

public class TV implements ControllableDevice {
    private int volume =0;
    @Override
    public void turnON() {
        System.out.println("TV is ON");
    }

    @Override
    public void turnOFF() {
        System.out.println("TV is off");
    }

    @Override
    public void increaseVolume() {
        System.out.println("Volume++ "+ ++volume);
    }

    @Override
    public void decreaseVolume() {
        System.out.println("Volume-- " + --volume);

    }
}
