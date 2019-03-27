package SDA;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class DrawSS {

    public static void main(String[] args) throws AWTException, IOException {

        Robot wallE = new Robot();
        Rectangle picture = new Rectangle(1000,1000);
        String myFile = "./resources/img.jpg";
        BufferedImage image = wallE.createScreenCapture(picture);
        // save file
        ImageIO.write(image,"jpg",new File(myFile));
        // open file
        Desktop.getDesktop().open(new File(myFile));



    }
}
