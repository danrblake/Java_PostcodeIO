import org.json.simple.JSONObject;
public class PostCodeInfoParser {

    JSONObject postCodeData;
    JSONObject resultData;

    public PostCodeInfoParser() {
        PostCodeHTTPManager postCodeHTTPManager = new PostCodeHTTPManager();
        JSONFactory jsonFactory = new JSONFactory();
        postCodeHTTPManager.getAndStorePostCodeData("HA72AG");
        jsonFactory.convertPostCodeDataToJSON(postCodeHTTPManager.getPostCodeData());
        postCodeData = jsonFactory.getPostCodeJSON();
        if(getJSONSuccess()) {
            setResultData();
        }
    }

    public JSONObject getPostCodeData(){
        return postCodeData;
    }

    public void setResultData() {
        resultData = (JSONObject) getJSONValueFromOriginalData("result");
    }

    public boolean getJSONSuccess() {
        if(getJSONValueFromOriginalData("status").toString().equals("200")){
            return true;
        } else {
            return false;
        }
    }

    //Information Getters
    public String getRegionName(){
        return (String) getJSONValueFromResultData("region");
    }

    public Double getLongitude(){
        return (Double) getJSONValueFromResultData("longitude");
    }
    public Double getLatitude(){
        return (Double) getJSONValueFromResultData("latitude");
    }
    public String getParlimentaryConstituency(){
        return (String) getJSONValueFromResultData("parliamentary_constituency");
    }

//Private helper methods
    private Object getJSONValueFromOriginalData(String key) {
        return postCodeData.get(key);
    }

    private Object getJSONValueFromResultData(String key) {
        return resultData.get(key);
    }

}
