import java.io.IOException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
public class PostCodeHTTPManager {

        private String baseURI = "https://api.postcodes.io/postcodes/";
        private String postCodeData;
        public void getAndStorePostCodeData() {
            try {
                CloseableHttpClient httpClient = HttpClients.createDefault();
                HttpGet getLatestRates = new HttpGet(baseURI+"HA72AG");
                CloseableHttpResponse response = httpClient.execute(getLatestRates);
                postCodeData = EntityUtils.toString(response.getEntity());
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        public String getPostCodeData(){
            return postCodeData;
        }
}
