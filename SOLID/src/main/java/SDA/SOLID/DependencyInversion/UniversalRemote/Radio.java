package SDA.SOLID.DependencyInversion.UniversalRemote;

public class Radio implements ControllableDevice {
    private int volume =0;
    @Override
    public void turnON() {
        System.out.println("Radio is ON");
    }

    @Override
    public void turnOFF() {
        System.out.println("Radio is OFF");
    }

    @Override
    public void increaseVolume() {
        System.out.println("volume ++"+ ++volume);
    }

    @Override
    public void decreaseVolume() {
        System.out.println("volume--"+ --volume);
    }
}
