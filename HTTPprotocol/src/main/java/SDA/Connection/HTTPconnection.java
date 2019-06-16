package SDA.Connection;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class HTTPconnection {

    public void run() throws IOException {

        String key = "39dd2f7e45ea0f1e377e54adba31b271/";
        String adress = "https://api.darksky.net/forecast/";
        String longitude = "37.8267,";
        String latitude = "-122.4233";
        URL url = new URL(adress + key + longitude + latitude);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");

        BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        //print result
        System.out.println(response.toString());

    }

    public static void main(String[] args) throws IOException {
        HTTPconnection h = new HTTPconnection();
        h.run();

    }
}
