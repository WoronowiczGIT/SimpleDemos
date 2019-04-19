package SDA.IntiveISSTracker;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class JSONReciever {
    private HttpURLConnection connection;
    private URL url;
    //String address = "http://api.open-notify.org/iss-now.json";
    JSONReciever(String address) throws MalformedURLException {
        this.url = new URL(address);
    }

    private void openConnection() throws IOException {
        this.connection = (HttpURLConnection) url.openConnection();
    }

    private void checkResponse() throws IOException {
        if (connection.getResponseCode() != 200)
            throw new RuntimeException("incorrect response code");
    }

    private String getJSON() throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        StringBuffer response = new StringBuffer();
        String line;
        while ((line = input.readLine()) != null) {
            response.append(line);
        }
        input.close();
        return response.toString();
    }

    public String recieve() throws IOException {
        try {
            openConnection();
            checkResponse();
            String JSON = getJSON();
            return JSON;
        }catch (IOException e){
            System.out.println("faild to recieve data");
        }
        return null;
    }

}
