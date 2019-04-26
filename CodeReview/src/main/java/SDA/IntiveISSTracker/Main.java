package SDA.IntiveISSTracker;
import SDA.IntiveISSTracker.Model.DataPackage;
import SDA.IntiveISSTracker.Model.Position;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException, ParseException, InterruptedException {
        String address = "http://api.open-notify.org/iss-now.json";

        JsonToJsPrimitiveMapConverter toMapConverter = new JsonToJsPrimitiveMapConverter();
        PrimitiveMapToPositionConverter toPositionConverter = new PrimitiveMapToPositionConverter();
        DataFetcher dataFetcher = new DataFetcher(address);

        GeographicalCalculator calculator = new GeographicalCalculator();
            calculator.isTimeFixed(true);
            calculator.setFixedTimeInSec(5);

        int clientPollIntervalInMs = calculator.getFixedTime()*1000;

        Map map = toMapConverter.convert(dataFetcher.fetch());
        Position oldPosition = toPositionConverter.getPosition(map);
        while (true) {
            Thread.sleep(clientPollIntervalInMs);

            map = toMapConverter.convert(dataFetcher.fetch());
            Position newPosition = toPositionConverter.getPosition(map);
            DataPackage data = calculator.getCalculations(oldPosition,newPosition);
            Presenter(data);
            oldPosition = newPosition;
        }
    }

    static private void Presenter(DataPackage dataPackage){
        System.out.println(  " speed: "         +(int)dataPackage.getSpeed()         + " km/h,"
                            +" distance: "      +(int)dataPackage.getDistance()      + " km,"
                            +" time: "          +(int)dataPackage.getTime()          + " sec,"
                            +" total time: "    +(int)dataPackage.getTotalTime()     + " sec,"
                            +" total distance: "+(int)dataPackage.getTotalDistance() + " km,"
                            +" avarage speed: " +(int)dataPackage.getAvarageSpeed()  + " km/h.");
        }

}
