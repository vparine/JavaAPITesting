import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class Utility {

    String githubUrl = "";
    HttpUriRequest request = null;
    HttpResponse response = null;
    int responseCode = 0;
    JSONObject jsonResponse = null;
    int totalCount = 0;

    public void searchForRepositories(String query, String sortQuery, String orderQuery) {
        githubUrl = "https://api.github.com/search/repositories?q=";
        try{
            githubUrl += URLEncoder.encode(query, "UTF-8") + "&sort=" + sortQuery + "&order=" + orderQuery;
        }catch(UnsupportedEncodingException e){
            System.out.println("Looks like encoding format is not supported. Please check and try again!");
        }
        System.out.println(githubUrl);

        request = new HttpGet(githubUrl);
        try {
            response = HttpClientBuilder.create().build().execute(request);
        } catch (IOException e) {
            System.out.println("Looks like there is a problem with Connection. Please try again!");
        }

        setResponseCode(response.getStatusLine().getStatusCode());
        try {
            setJsonResponse(new JSONObject(EntityUtils.toString(response.getEntity())));
        } catch (IOException e) {
            System.out.println("Looks like response is not available for converting it to String. Please check the response once!");
        }
        try {
            setTotalCount(jsonResponse.getInt("total_count"));
        } catch (JSONException e) {
            setTotalCount(0);
        }
    }

    public void setJsonResponse(JSONObject jsonResponse) {
        this.jsonResponse = jsonResponse;
    }

    public void setResponseCode(int responseCode) {
        this.responseCode = responseCode;
    }

    public int getResponseCode() {
        return responseCode;
    }

    public int getTotalCount(){
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }
}
