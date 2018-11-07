import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
public class JSONFactory {
    private JSONObject postCodeData;

    public JSONObject getPostCodeJSON() {
        return postCodeData;
    }
    public void convertPostCodeDataToJSON(String postCodeJSONString) {
        JSONParser jsonParser = new JSONParser();
        try {
            this.postCodeData = (JSONObject) jsonParser.parse(postCodeJSONString);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
