package lottoHandler;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class FetchJSON {
    private HttpURLConnection connection;
    private URL url = new URL("http://serwis.mobilotto.pl/mapi_v6/index.php?json=getGames");

    public FetchJSON() throws MalformedURLException {
    }


    private void openConnection() throws IOException {


        this.connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
    }

    private void checkResponse() throws IOException {
        if (connection.getResponseCode() != 200)
            throw new RuntimeException("incorrect response code");
    }

    public String getJSON() throws IOException {
        openConnection();
        checkResponse();
        BufferedReader input = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        StringBuffer response = new StringBuffer();
        String line;
        while ((line = input.readLine()) != null) {
            response.append(line);
        }
        input.close();
        return response.toString();
    }



    public static void main(String[] args) throws IOException {
        FetchJSON f= new FetchJSON();
        String json = f.getJSON();
        JSONObject all = new JSONObject(json);
        System.out.println(json);

        JSONObject lotto = all.getJSONObject("Lotto");
        String numbers = lotto.getString("numerki");
        System.out.println(numbers);
//        System.out.println(lotto.keySet());
        for (String key: all.keySet()) {
            System.out.println(key);
        }
       // String num = (String)lotto.get("numerki");
    }
}

