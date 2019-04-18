package SDA.IntiveISSTracker;

import jdk.nashorn.internal.parser.JSONParser;
import jdk.nashorn.internal.parser.Scanner;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ConnectException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class ReadFile {
    private HttpURLConnection connection;
    private URL url;


    public ReadFile() throws IOException {
    }

    public void setUpConnection(String adress) throws IOException {
        this.url = new URL("http://api.open-notify.org/iss-now.json");
        this.connection = (HttpURLConnection) url.openConnection();
    }

    private void checkResponse(URL url) throws IOException {
        if (connection.getResponseCode() != 200)
            throw new RuntimeException("incorrect response code");

    }

    public String fetchJSON(URL url) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();
        return response.toString();
    }

    public static void main(String[] args) throws IOException {
        ReadFile file = new ReadFile();

    }

}


