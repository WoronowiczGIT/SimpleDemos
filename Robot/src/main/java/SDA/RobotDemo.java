package SDA;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;

public class RobotDemo {
    public static void main(String[] args) throws IOException, AWTException, InterruptedException {
        // one way to open a file
        File myTxtFile = new File("./resources/file.txt");
        Desktop.getDesktop().open(myTxtFile);
        // second way
        String command = "notepad.exe";
        Runtime run = Runtime.getRuntime();
        run.exec(command);

        Robot wallE = new Robot();
        Thread.sleep(2000);
        wallE.keyPress(KeyEvent.VK_H);
        Thread.sleep(1000);
        wallE.keyPress(KeyEvent.VK_E);
        Thread.sleep(1000);
        wallE.keyPress(KeyEvent.VK_L);
        Thread.sleep(1000);
        wallE.keyPress(KeyEvent.VK_L);
        Thread.sleep(1000);
        wallE.keyPress(KeyEvent.VK_O);

        Color color = wallE.getPixelColor(1000,1000);
        System.out.println(color.toString());

        wallE.mouseMove(500,500);

    }

}
