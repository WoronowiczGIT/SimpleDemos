package SDA.IntiveISSTracker;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JSONConwerter {

    private JSONObject JSONtoPOJO(String JSONString) throws ParseException {
        JSONParser parser = new JSONParser();
        JSONObject object = (JSONObject) parser.parse(JSONString);
        return object;
    }

    private long getTimeStamp(JSONObject object){
        long time = (long) object.get("timestamp");
        return time;
    }

    private Double getAngularCordinate(JSONObject position, String typeOfCoordinate){
        Double coordinate = Double.valueOf((String) position.get(typeOfCoordinate));
        return coordinate;
    }

    private Position JSONtoPosition(JSONObject obj){
        long time = getTimeStamp(obj);
        JSONObject position = new JSONObject((JSONObject) obj.get("iss_position"));
        Double longitude = getAngularCordinate(position,"longitude");
        Double latitude = getAngularCordinate(position,"latitude");
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
}
