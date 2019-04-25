package SDA.IntiveISSTracker;
import SDA.IntiveISSTracker.Model.DataPackage;
import SDA.IntiveISSTracker.Model.Position;
import org.json.simple.parser.ParseException;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, ParseException, InterruptedException {
        String address = "http://api.open-notify.org/iss-now.json";
        int clientPollInterval = 5000;
        JSONToMapConverter parser = new JSONToMapConverter();
        DataFetcher dataFetcher = new DataFetcher(address);
        DataRepository repository = new DataRepository();

        Position oldPosition = parser.getPosition(dataFetcher.fetch());
        while (true) {
            Thread.sleep(clientPollInterval);
            String JSON = dataFetcher.fetch();
            Position newPosition = parser.getPosition(JSON);
            DataPackage data = repository.getDisplayableData(oldPosition,newPosition);
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
