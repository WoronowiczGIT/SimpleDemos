package Woronowicz;

import java.io.*;
import java.util.Properties;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException {
        Properties properties = new Properties();
        setProperties(properties);
        saveProperties(properties);
        loadProperties(properties);
        System.out.println(properties.getProperty("pass"));
    }

    public static void setProperties(Properties properties){
        properties.setProperty("uName","Jan");
        properties.setProperty("address","google.pl");
        properties.setProperty("pass","Admin1");
    }
    public static void saveProperties(Properties properties) throws IOException {
        OutputStream toFile = new FileOutputStream("myProperties.cfg");
        properties.store(toFile,null);
    }
    public static void loadProperties(Properties properties) throws IOException {
        InputStream fromFile = new FileInputStream("myProperties.cfg");
        properties.load(fromFile);
    }

}
