import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

public class Utility {

    public static HttpResponse getRequest(String query, String sortQuery, String orderQuery) throws IOException {

        String githubUrl = "https://api.github.com/search/repositories?q=";
        githubUrl += query + "&sort=" + sortQuery + "&order=" + orderQuery;

        HttpUriRequest request = new HttpGet(githubUrl);

        HttpResponse response = HttpClientBuilder.create().build().execute(request);

        return response;
    }
}
