import com.google.gson.Gson;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicHeader;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.IOException;
public class HTTPManagerPost {

    private String requestedPostCodeString;
    private String baseURI = "https://api.postcodes.io/postcodes/";

    public void getAndStorePostCodeData(String[] requestedPostCode) {
        try {
            CloseableHttpClient httpClient = HttpClients.createDefault();
            HttpPost httpPost = new HttpPost(baseURI);
            JSONObject postcodesToLookFor = new JSONObject();
            postcodesToLookFor.put("postcodes", requestedPostCode);
            System.out.println(postcodesToLookFor.toString());
            httpPost.setHeader("Content-Type", "application/json");
            Gson gson = new Gson();
            httpPost.setEntity(new StringEntity(gson.toJson(postcodesToLookFor)));
            HttpResponse response = httpClient.execute(httpPost);
            requestedPostCodeString = EntityUtils.toString(response.getEntity());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public String getRequestedPostCodeString(){
        return requestedPostCodeString;
    }
}
