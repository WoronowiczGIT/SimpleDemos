package SDA.SOLID.DependencyInversion;

import SDA.SOLID.DependencyInversion.UniversalRemote.ControllableDevice;
import SDA.SOLID.DependencyInversion.UniversalRemote.Radio;
import SDA.SOLID.DependencyInversion.UniversalRemote.TV;
import SDA.SOLID.DependencyInversion.XOgame.BigBoard;
import SDA.SOLID.DependencyInversion.XOgame.Board;
import SDA.SOLID.DependencyInversion.XOgame.Game;
import SDA.SOLID.DependencyInversion.XOgame.SmallBoard;

public class Main {
    public static void main(String[] args) {
        ControllableDevice tv = new TV();
        ControllableDevice radio = new Radio();

        tv.turnON();
        tv.increaseVolume();

        radio.turnON();
        radio.increaseVolume();

        Board b1 = new SmallBoard(new int[]{1,2,3});
         Game g1 = new Game(b1);

        Board b2 = new BigBoard(new int[]{1,2,3});
        Game g2 = new Game(b2);

        g2.tryField(2);
        g1.tryField(2);

    }
}
