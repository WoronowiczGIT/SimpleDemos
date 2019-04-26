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

class JsonMapper {

    private Map<Object, Object> map;

    public Map convert(String json) {
        this.map = new HashMap<>();
        JsonObject obj = new JsonParser()
                .parse(json)
                .getAsJsonObject();

        JsonObjToMap(obj);
        return this.map;
    }

    private void JsonObjToMap(JsonObject object) {
        for (Object key : object.keySet()) {
            if (object.get((String) key).isJsonPrimitive()) {
                map.put(key, object.get((String) key));
            } else JsonObjToMap(object.get((String) key).getAsJsonObject());
        }
    }


}
