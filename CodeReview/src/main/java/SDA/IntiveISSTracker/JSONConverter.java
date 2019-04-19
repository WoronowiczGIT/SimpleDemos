package SDA.IntiveISSTracker;

import SDA.IntiveISSTracker.Model.Position;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.IOException;

public class JSONConverter {

    private JSONObject JSONtoPOJO(String JSONString) throws ParseException {
        JSONParser parser = new JSONParser();
        JSONObject object = (JSONObject) parser.parse(JSONString);
        return object;
    }

    private long getTimeStamp(JSONObject object){
        long time = (long) object.get("timestamp");
        return time;
    }

    private Double getAngularCoordinate(JSONObject position, String typeOfCoordinate){
        Double coordinate = Double.valueOf((String) position.get(typeOfCoordinate));
        return coordinate;
    }

    private Position JSONtoPosition(JSONObject obj){
        long time = getTimeStamp(obj);
        JSONObject position = new JSONObject((JSONObject) obj.get("iss_position"));
        Double longitude = getAngularCoordinate(position,"longitude");
        Double latitude = getAngularCoordinate(position,"latitude");
        return new Position(time,longitude,latitude);
    }

    public Position getPosition(String json) throws ParseException {
        try {
            JSONObject obj = JSONtoPOJO(json);
            Position position = JSONtoPosition(obj);
            return position;
        }catch (NullPointerException e){
            System.out.println("invalid JSON string");
        }
        return null;
    }

    public static void main(String[] args) throws IOException, ParseException {
        String address = "http://api.open-notify.org/iss-now.json";
        JSONReceiver reciever = new JSONReceiver(address);
        JSONConverter converter = new JSONConverter();
        Position pos = converter.getPosition(reciever.receive());
        System.out.println(pos.getTimeStamp()+" lat: "+pos.getLatitude()+" long: "+pos.getLongitude());


    }
}
