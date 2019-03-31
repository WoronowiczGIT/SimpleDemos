package SDA.SOLID.DependencyInversion;

import SDA.SOLID.DependencyInversion.UniversalRemote.ControllableDevice;
import SDA.SOLID.DependencyInversion.UniversalRemote.Radio;
import SDA.SOLID.DependencyInversion.UniversalRemote.TV;

public class Main {
    public static void main(String[] args) {
        ControllableDevice tv = new TV();
        ControllableDevice radio = new Radio();

        tv.turnON();
        tv.increaseVolume();

        radio.turnON();
        radio.increaseVolume();
    }
}
