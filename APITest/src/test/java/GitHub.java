import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GitHub {
    @Test
    public void searchForRepositoriesWithName_Java_WrittenIn_Java_SortByNoOf_Stars_OrderIn_Desc()
            throws IOException {

        HttpResponse response = Utility.getRequest("Java+language:java", "stars", "desc");

        String responseContent = EntityUtils.toString(response.getEntity());

        Assert.assertEquals(response.getStatusLine().getStatusCode(), 200);

        System.out.println(responseContent);
    }
}
