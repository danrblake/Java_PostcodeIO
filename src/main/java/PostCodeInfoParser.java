import org.json.simple.JSONObject;
public class PostCodeInfoParser {

    JSONObject postCodeData;

    public PostCodeInfoParser() {
        PostCodeHTTPManager postCodeHTTPManager = new PostCodeHTTPManager();
        JSONFactory jsonFactory = new JSONFactory();
        postCodeHTTPManager.getAndStorePostCodeData("HA72AG");
        jsonFactory.convertPostCodeDataToJSON(postCodeHTTPManager.getPostCodeData());
        this.postCodeData = jsonFactory.getPostCodeJSON();
    }

    public JSONObject getPostCodeData(){
        return postCodeData;
    }
}
