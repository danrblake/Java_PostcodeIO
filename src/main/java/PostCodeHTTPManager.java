import java.io.IOException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
public class PostCodeHTTPManager {

        private String baseURI = "https://api.postcodes.io/postcodes/";
        private String postCodeData;
        public void getAndStorePostCodeData(String requestedPostCode) {
            try {
                CloseableHttpClient httpClient = HttpClients.createDefault();
                HttpGet getPostCodeData = new HttpGet(baseURI+requestedPostCode);
                CloseableHttpResponse response = httpClient.execute(getPostCodeData);
                postCodeData = EntityUtils.toString(response.getEntity());
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        public String getPostCodeData(){
            return postCodeData;
        }
}
