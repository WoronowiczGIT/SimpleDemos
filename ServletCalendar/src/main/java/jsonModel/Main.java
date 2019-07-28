package jsonModel;

import org.json.JSONObject;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        JsonModel jan = new JsonModel(
                "jan",
                "kowalski",
                54,
                LocalDate.now().getDayOfWeek());

        JSONObject mappedObject = new JSONObject(jan);
        String myJson = JSONObject.valueToString(mappedObject);
        System.out.print(myJson);
    }
}
