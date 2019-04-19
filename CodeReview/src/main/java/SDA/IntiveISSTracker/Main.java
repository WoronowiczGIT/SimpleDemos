package SDA.IntiveISSTracker;

import SDA.IntiveISSTracker.Model.Position;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.net.MalformedURLException;

public class Main {
    public static void main(String[] args) throws IOException, ParseException, InterruptedException {
        String address = "http://api.open-notify.org/iss-now.json";
       JSONConverter converter = new JSONConverter();
       JSONReceiver reciever = new JSONReceiver(address);
        Double totalDistance = 0D;

        Position oldPosition = converter.getPosition(reciever.receive());
       while (true){
           Thread.sleep(5000);
        Position newPosition = converter.getPosition(reciever.receive());
        double distance = Logic.getDistance(oldPosition,newPosition);
        distance = Math.round(distance);
        double speed = Logic.getSpeed(oldPosition,newPosition);
        speed = Math.round(speed);

        totalDistance+=Math.round(distance);

           System.out.println("speed: "+speed+" Distance from last point: "+distance+" total distance: "+totalDistance);
        oldPosition = newPosition;

       }
    }
}
