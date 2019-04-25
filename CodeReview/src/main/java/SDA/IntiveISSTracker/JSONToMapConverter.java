package SDA.IntiveISSTracker;

import SDA.IntiveISSTracker.Model.Position;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

class JSONToMapConverter {

    private JSONObject JSONtoPOJO(String JSONString) throws ParseException {
        JSONParser parser = new JSONParser();
        return (JSONObject) parser.parse(JSONString);
    }

    private long getTimeStamp(JSONObject object) {
        return (long) object.get("timestamp");
    }

    private Double getAngularCoordinate(JSONObject position, String typeOfCoordinate) {
        return Double.valueOf((String) position.get(typeOfCoordinate));
    }

    private Position JSONtoPosition(JSONObject obj) {

        long time = getTimeStamp(obj);
        JSONObject position = new JSONObject((JSONObject) obj.get("iss_position"));
        Double longitude = getAngularCoordinate(position, "longitude");
        Double latitude = getAngularCoordinate(position, "latitude");
        return new Position(time, longitude, latitude);
    }

    Position getPosition(String json) throws ParseException {
        try {
            JSONObject obj = JSONtoPOJO(json);
            return JSONtoPosition(obj);

        } catch (NullPointerException e) {
            System.out.println("invalid JSON string");
        }
        return null;
    }

    private Map<Object, Object> map;

    void JsonObjToMap(JsonObject object) {
        for (Object key : object.keySet()) {
            if (object.get((String) key).isJsonPrimitive()) {
                map.put(key, object.get((String) key));
            } else JsonObjToMap(object.get((String) key).getAsJsonObject());
        }
    }

    public Map convert(String json) {
        this.map = new HashMap<>();
        JsonObject obj = new JsonParser()
                .parse(json)
                .getAsJsonObject();

        JsonObjToMap(obj);
        return this.map;
    }

    public static void main(String[] args) throws ParseException, IOException {
        String address = "http://api.open-notify.org/iss-now.json";
        DataFetcher fetcher = new DataFetcher(address);
        JSONToMapConverter parser = new JSONToMapConverter();
        String js = fetcher.fetch();
        //System.out.println(js);


        for (Object key : parser.convert(js).keySet()) {
            System.out.println(key);
        }

//        Position p = parser.getPosition(js);
//        System.out.println(p.getTimeStamp()+" "+p.getLongitude()+" "+p.getLatitude());
    }
}
