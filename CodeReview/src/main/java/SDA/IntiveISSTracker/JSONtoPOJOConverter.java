package SDA.IntiveISSTracker;

import SDA.IntiveISSTracker.Model.Position;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

class JSONtoPOJOConverter {

    private JSONObject JSONtoPOJO(String JSONString) throws ParseException {
        JSONParser parser = new JSONParser();
        return (JSONObject) parser.parse(JSONString);
    }

    private long getTimeStamp(JSONObject object){
        return (long) object.get("timestamp");
    }

    private Double getAngularCoordinate(JSONObject position, String typeOfCoordinate){
        return Double.valueOf((String) position.get(typeOfCoordinate));
    }

    private Position JSONtoPosition(JSONObject obj){
        long time = getTimeStamp(obj);
        JSONObject position = new JSONObject((JSONObject) obj.get("iss_position"));
        Double longitude = getAngularCoordinate(position,"longitude");
        Double latitude = getAngularCoordinate(position,"latitude");
        return new Position(time,longitude,latitude);
    }

    Position getPosition(String json) throws ParseException {
        try {
            JSONObject obj = JSONtoPOJO(json);
            return JSONtoPosition(obj);
        }catch (NullPointerException e){
            System.out.println("invalid JSON string");
        }
        return null;
    }
}
