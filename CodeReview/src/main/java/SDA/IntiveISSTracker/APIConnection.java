package SDA.IntiveISSTracker;


import jdk.nashorn.internal.objects.Global;
import jdk.nashorn.internal.runtime.Context;
import netscape.javascript.JSObject;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class APIConnection {
    private HttpURLConnection connection;
    private URL url;


    public APIConnection() throws IOException {
    }

    public void setUpConnection() throws IOException {
        this.url = new URL("http://api.open-notify.org/iss-now.json");
        this.connection = (HttpURLConnection) url.openConnection();
    }

    private void checkResponse() throws IOException {
        if (connection.getResponseCode() != 200)
            throw new RuntimeException("incorrect response code");

    }

    public String fetchJSON() throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        StringBuffer response = new StringBuffer();
        String line;
        while ((line = input.readLine()) != null) {
            response.append(line);
        }
        input.close();
        return response.toString();
    }

    public JSONObject mapJson(String JSONString) throws ParseException {
        JSONParser parser = new JSONParser();
        JSONObject object = (JSONObject) parser.parse(JSONString);
        return object;
    }

    public static void main(String[] args) throws IOException, ParseException, InterruptedException {
        //Metoda szablonowa -> connecting protocol
        APIConnection apiConnection = new APIConnection();
        apiConnection.setUpConnection();
        apiConnection.checkResponse();
        //getData
        String json1 = apiConnection.fetchJSON();
        Thread.sleep(60000);
        apiConnection.setUpConnection();
        String json2 = apiConnection.fetchJSON();

        JSONObject obj1 = apiConnection.mapJson(json1);
        JSONObject obj2 = apiConnection.mapJson(json2);
        System.out.println(json1);
        System.out.println(json2);
        System.out.println(obj1.get("iss_position"));

        JSONObject secondlvl = new JSONObject((JSONObject) obj1.get("iss_position"));
        System.out.println(secondlvl.get("latitude"));
        System.out.println("speed = " + calculateSpeed(obj1, obj2));
        JSONObject newObject = new JSONObject((JSONObject) new JSONParser().parse(json1));


    }

    static double calculateSpeed(JSONObject obj1, JSONObject obj2) {
        long time1 = (long) obj1.get("timestamp");
        long time2 = (long) obj2.get("timestamp");

        JSONObject position1 = new JSONObject((JSONObject) obj1.get("iss_position"));
        JSONObject position2 = new JSONObject((JSONObject) obj2.get("iss_position"));

        Double latitude1 = Double.valueOf((String) position1.get("latitude"));
        System.out.println(latitude1);
        Double latitude2 = Double.valueOf((String) position2.get("latitude"));
        System.out.println(latitude2);
        Double longitude1 = Double.valueOf((String) position1.get("longitude"));
        System.out.println(longitude1);
        Double longitude2 = Double.valueOf((String) position2.get("longitude"));
        System.out.println(longitude2);

        long timeInSeconds =  (time2 - time1);
        Double distanceInKm = getDistance(latitude1, longitude1, latitude2, longitude2);
        Double velocity = distanceInKm/timeInSeconds;
        return velocity*3600;
    }

    public static double getDistance(double lat1, double long1, double lat2, double long2) {
        double earthRadius = 6371;
        double distance = Math.acos(Math.sin(lat2 * Math.PI / 180.0) * Math.sin(lat1 * Math.PI / 180.0) +
                Math.cos(lat2 * Math.PI / 180.0) * Math.cos(lat1 * Math.PI / 180.0) *
                        Math.cos((long1 - long2) * Math.PI / 180.0)) * earthRadius;
        return distance;
    }

}


